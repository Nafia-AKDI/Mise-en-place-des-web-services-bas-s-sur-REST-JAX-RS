package ma.fstt.services;

import org.glassfish.jersey.server.ResourceConfig;

public class EndPoint extends ResourceConfig{
	
	public EndPoint() {
		
		packages("ma.fstt.services");
	}

}
