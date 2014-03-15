package com.seascape.enterprise.rest;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class MainApplication  extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public MainApplication() {
		singletons.add(new ScoutREST());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}