package dev.rvz.agenda.inteligente.webservice.configurations;

import dev.rvz.agenda.inteligente.webservice.rest.databases.CategoryDatabaseRest;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class CategoryRestBuilder {

	private final PropertiesConfiguration propertiesConfiguration;
	private final JacksonEncoder jacksonEncoder = new JacksonEncoder();
	private final JacksonDecoder jacksonDecoder = new JacksonDecoder();

	public CategoryRestBuilder(PropertiesConfiguration propertiesConfiguration) {
		this.propertiesConfiguration = propertiesConfiguration;
	}

	public CategoryDatabaseRest build() {
		String urlBase = this.propertiesConfiguration.getProperties().getProperty("url.categories");

		return Feign.builder().encoder(jacksonEncoder).decoder(jacksonDecoder).target(CategoryDatabaseRest.class,
				urlBase);
	}
}
