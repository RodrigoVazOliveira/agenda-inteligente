package dev.rvz.agenda.inteligente.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import dev.rvz.agenda.inteligente.webservice.configurations.CategoryRestBuilder;
import dev.rvz.agenda.inteligente.webservice.configurations.PropertiesConfiguration;
import dev.rvz.agenda.inteligente.webservice.resource.CategoryResource;
import dev.rvz.agenda.inteligente.webservice.rest.databases.CategoryDatabaseRest;

@ApplicationPath("/")
public class AgendaInteligenteWebServiceApplication extends Application {

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> empty = new HashSet<>();
	private final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();

	public AgendaInteligenteWebServiceApplication() {
		createCategoryResource();
	}

	private void createCategoryResource() {
		CategoryRestBuilder categoryRestBuild = new CategoryRestBuilder(propertiesConfiguration);
		CategoryDatabaseRest categoryDatabaseRest = categoryRestBuild.build();

		this.singletons.add(new CategoryResource(categoryDatabaseRest));
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}

}
