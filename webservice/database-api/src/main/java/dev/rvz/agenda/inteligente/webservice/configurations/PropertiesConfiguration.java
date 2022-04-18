package dev.rvz.agenda.inteligente.webservice.configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesConfiguration {
	private final static Logger LOGGER = LoggerFactory.getLogger(PropertiesConfiguration.class);
	private final Properties properties;

	public PropertiesConfiguration() {
		InputStream applicationProperties = getPathResrouces();
		this.properties = new Properties();

		loadProperties(applicationProperties);
	}

	public Properties getProperties() {
		return properties;
	}

	private void loadProperties(InputStream applicationProperties) {
		try {
			this.properties.load(applicationProperties);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private InputStream getPathResrouces() {
		InputStream applicationProperties = getClass().getResourceAsStream("/application.properties");
		LOGGER.info("getPathResrouces - {}", applicationProperties);
		return applicationProperties;
	}

}
