package com.restro.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RESTfulAppConfig  extends  ResourceConfig {
	
	public RESTfulAppConfig () {
		packages("com.restro.rest");
	}

}
