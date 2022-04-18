package dev.rvz.agenda.inteligente.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import dev.rvz.agenda.inteligente.webservice.resource.CategoryResource;

@ApplicationPath("/")
public class AgendaInteligenteWebServiceApplication extends Application {

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> empty = new HashSet<>();

	public AgendaInteligenteWebServiceApplication() {
		this.singletons.add(new CategoryResource());
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
