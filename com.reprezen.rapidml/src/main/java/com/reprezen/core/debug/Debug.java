/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.core.debug;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.reprezen.core.ConfigVariable;

public abstract class Debug<OptClass extends Enum<OptClass>> {
	private final String name;
	private Class<OptClass> debugOptionsEnumClass;
	private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	static {
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
	}
	private Map<String, OptClass> optsByName = Maps.newHashMap();
	private Set<OptClass> activeOptions = Sets.newHashSet();
	private boolean debugAll = false;
	private boolean debugDefault = false;

	public Debug(Class<OptClass> debugOptionsEnumClass) {
		this.name = getName();
		this.debugOptionsEnumClass = debugOptionsEnumClass;
		ConfigVariable debugVar = getDebugVar();
		computeOptsByName(debugOptionsEnumClass);
		if (debugVar.isSet()) {
			String optNames = debugVar.get();
			for (String optName : optNames.split(",")) {
				OptClass option = optsByName.get(optName);
				if (option != null) {
					activeOptions.add(option);
				}
			}
			if (activeOptions.isEmpty()) {
				debugAll = true;
				debugDefault = true;
			} else if (optsByName.containsKey("DEFAULT")) {
				debugDefault = activeOptions.contains(optsByName.get("DEFAULT"));
			} else {
				debugDefault = true;
			}
		}
	}

	protected abstract String getName();

	protected abstract ConfigVariable getDebugVar();

	private void computeOptsByName(Class<OptClass> debugOptionsEnumClass) {
		if (debugOptionsEnumClass != null) {
			try {
				Method valuesMethod = debugOptionsEnumClass.getMethod("values");
				valuesMethod.setAccessible(true);
				@SuppressWarnings("unchecked")
				OptClass values[] = (OptClass[]) valuesMethod.invoke(null);
				for (OptClass value : values) {
					optsByName.put(value.name(), value);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
			}
		}
	}

	public void _debug(Object... args) {
		boolean enabled = debugAll;
		int argsPos = 0;
		OptClass firstOpt = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] != null && args[i].getClass() == debugOptionsEnumClass) {
				@SuppressWarnings("unchecked")
				OptClass argOpt = (OptClass) args[i];
				enabled = enabled || activeOptions.contains(argOpt);
				argsPos = i + 1;
				firstOpt = firstOpt != null ? firstOpt : argOpt;
			} else {
				break;
			}
		}
		if (argsPos == 0) {
			enabled = enabled || debugDefault;
		}
		if (enabled) {
			doDebug(firstOpt, Arrays.copyOfRange(args, argsPos, args.length));
		}
	}

	private void doDebug(OptClass labelOpt, Object[] args) {
		String title = args.length > 0 && args[0] instanceof String && ((String) args[0]).startsWith(":")
				? ((String) args[0]).substring(1)
				: "";
		String labelName = labelOpt != null ? labelOpt.name() : "*";
		System.err.printf("DEBUG %s [%s] %s\n", name, labelName, title);
		for (int i = title.length() > 0 ? 1 : 0; i < args.length; i++) {
			if (args[i] instanceof String && i + 1 < args.length && ((String) args[i]).endsWith("=")) {
				String argName = (String) args[i];
				print(argName.substring(0, argName.length() - 1), args[++i]);
			} else {
				print(args[i], 2);
			}
		}
	}

	private void print(String name, Object obj) {
		System.err.print("  " + name + ": ");
		print(obj, -4);
	}

	private void print(Object obj, int indent) {
		String output = null;
		if (obj == null) {
			output = "null";
		} else if (obj instanceof JsonNode) {
			output = getYaml(obj);
		} else if (obj instanceof Throwable) {
			getThrowable((Throwable) obj);
		} else if (obj.getClass().isArray()) {
			List<String> elts = getCollection(Arrays.asList(obj));
			output = StringUtils.join(elts, ", \n");
		} else if (obj instanceof Collection<?>) {
			List<String> elts = getCollection(obj);
			output = StringUtils.join(elts, ", \n");
		} else {
			output = String.valueOf(obj);
		}
		String[] lines = output.split("[\\r\\n]+");
		if (lines.length > 0) {
			System.err.println(indent(indent < 0 ? 0 : indent) + lines[0]);
		}
		for (int i = 1; i < lines.length; i++) {
			System.err.println(indent(indent < 0 ? -indent : indent) + lines[i]);
		}
	}

	private List<String> getCollection(Object obj) {
		List<String> elts = Lists.newArrayList();
		for (Object elt : (Collection<?>) obj) {
			elts.add(String.valueOf(elt));
		}
		return elts;
	}

	private String indent(int n) {
		return StringUtils.repeat(' ', n);
	}

	private static String getYaml(Object obj) {
		try {
			String content = mapper.writeValueAsString(obj);
			if (!content.endsWith("\n")) {
				content = content + "\n";
			}
			return content;
		} catch (JsonProcessingException e) {
			return String.valueOf(obj);
		}
	}

	private static String getThrowable(Throwable e) {
		String stacktrace = Arrays.stream(e.getStackTrace()).map(ste -> String.valueOf(ste))
				.collect(Collectors.joining("\n"));
		return String.valueOf(e) + "\n" + stacktrace;

	}
}
