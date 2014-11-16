package eu.epitech.intra.commons.helpers;

import java.util.Properties;

public class IntraPropertiesHelper {
	private static Properties properties;

	private final static String getProperty(String key) {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(IntraPropertiesHelper.class.getClassLoader().getResourceAsStream("client.properties"));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return properties.getProperty(key);
	}

	public final static String getLogin() {
		return getProperty("login");
	}

	public final static String getPassword() {
		return getProperty("password");
	}

	public final static String getLogasPath(String path) {
		String prefix = getProperty("logas");
		if (prefix == null) {
			prefix = "";
		}
		if (!prefix.isEmpty()) {
			prefix = String.format("/%s-logas-303f9727c630", prefix);
		}
		return prefix + path;
	}
}
