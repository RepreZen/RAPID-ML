/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.rapidml.realization.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.common.collect.Lists;
import com.reprezen.jsonoverlay.JsonLoader;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.RealizationModel;
import com.reprezen.rapidml.realization.model.impl.RealizationModelImpl;

public class RealizationModelParser {

	private static JsonSchema validator = null;

	public RealizationModel parse(String spec, URL resolutionBase) {
		try {
			JsonLoader loader = new JsonLoader();
			JsonNode tree = loader.loadString(resolutionBase, spec);
			validateWithSchema(tree);
			ReferenceManager manager = new ReferenceManager(resolutionBase, tree, loader);
			return (RealizationModel) ((Object) RealizationModelImpl.factory.create(tree, null, manager));
		} catch (IOException e) {
			throw new RealizationModelParseException("Failed to parse spec as JSON or YAML", e);
		}
	}

	private void validateWithSchema(JsonNode model) {
		createValidator();
		try {
			ProcessingReport report = validator.validate(model);
			if (report != null) {
				List<String> msgs = Lists.newArrayList();
				report.forEach(msg -> {
					if (msg.getLogLevel().compareTo(LogLevel.ERROR) >= 0) {
						String ptr = msg.asJson().at("/instance/pointer").asText();
						msgs.add(String.format("At %s: %s", ptr.isEmpty() ? "/" : ptr, msg.getMessage()));
					}
				});
				if (!msgs.isEmpty()) {
					throw new RealizationModelParseException(msgs);
				}
			}
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
	}

	private void createValidator() {
		if (validator == null) {
			try {
				URL schemaUrl = getClass().getClassLoader().getResource("schema/auto-realization-config-schema.json");
				try (InputStream s = schemaUrl.openStream()) {
					JsonNode schema = new ObjectMapper().readTree(s);
					validator = JsonSchemaFactory.byDefault().getJsonSchema(schema);
				} catch (ProcessingException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class RealizationModelParseException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		private List<String> messages = Lists.newArrayList();

		public RealizationModelParseException() {
			super();
		}

		public RealizationModelParseException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			this(Collections.singletonList(message), cause, enableSuppression, writableStackTrace);
		}

		public RealizationModelParseException(List<String> messages, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(joinMessages(messages), cause, enableSuppression, writableStackTrace);
			this.messages.addAll(messages);
		}

		public RealizationModelParseException(String message, Throwable cause) {
			this(Collections.singletonList(message), cause);
		}

		public RealizationModelParseException(List<String> messages, Throwable cause) {
			super(joinMessages(messages), cause);
			this.messages.addAll(messages);
		}

		public RealizationModelParseException(String message) {
			this(Collections.singletonList(message));
		}

		public RealizationModelParseException(List<String> messages) {
			super(joinMessages(messages));
			this.messages.addAll(messages);
		}

		public RealizationModelParseException(Throwable cause) {
			super(cause);
		}

		public List<String> getMessages() {
			return messages;
		}

		private static String joinMessages(List<String> messages) {
			return String.join("\n", messages);
		}

	}
}