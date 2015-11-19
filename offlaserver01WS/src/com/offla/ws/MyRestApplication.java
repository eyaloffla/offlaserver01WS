package com.offla.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyRestApplication extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HolaWS.class);
        classes.add(GoogleTokensWS.class);
        classes.add(NotificationSenderWS.class);
        classes.add(NotificationSenderWSTestReceptor.class);
        return classes;
    }

}
