package com.offla.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import com.offla.test.HolaWS;
import com.offla.test.NotificationSenderWSTestReceptor;

@ApplicationPath("/rest")
public class MyRestApplication extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HolaWS.class);
        classes.add(GoogleTokensWS.class);
        classes.add(NotificationSenderWSTestReceptor.class);
        classes.add(IsPersonOnDB.class);
        classes.add(IsIPAproved.class);
        
      //  classes.add(SimpleWS.class);
        return classes;
    }

}
