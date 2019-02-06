package com.reprezen.core;

import static com.reprezen.core.ConfigVariable.ConfigMeans.ENV;
import static com.reprezen.core.ConfigVariable.ConfigMeans.PROPS;

/**
 * Various environment variables used throughout RepreZen
 */
public enum ConfigVariable {
	REPREZEN_DEBUG_MODELPATH, REPREZEN_ENABLE_AUTO_REALIZATION, REPREZEN_MAJOR_MINOR;

	public boolean isSet() {
		return isSet(null);
	}

	public boolean isSet(ConfigMeans means) {
		return get(means) != null;
	}

	public boolean isUnset() {
		return isUnset(null);
	}

	public boolean isUnset(ConfigMeans means) {
		return !isSet(means);
	}

	public String get() {
		return get(null);
	}

	public String get(ConfigMeans means) {
		String prop = useMeans(means, PROPS) ? System.getProperty(name()) : null;
		return prop != null ? prop //
				: useMeans(means, ENV) ? System.getenv(name()) : null;
	}

	public void clear() {
		clear(null);
	}

	public void clear(ConfigMeans means) {
		if (useMeans(means, PROPS)) {
			System.clearProperty(name());
		}
		if (useMeans(means, ENV)) {
			System.getenv().put(name(), null);
		}
	}

	public void set(String value) {
		set(value, null);
	}

	public void set(String value, ConfigMeans means) {
		if (useMeans(means, PROPS)) {
			System.setProperty(name(), value);
		}
		if (useMeans(means, ENV)) {
			System.getenv().put(name(), value);
		}

	}

	private boolean useMeans(ConfigMeans means, ConfigMeans testMeans) {
		return means == null || means == testMeans;
	}

	public enum ConfigMeans {
		ENV, PROPS
	}
}
