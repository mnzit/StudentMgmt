package com.nepalaya.studentmgmt;

import com.nepalaya.studentmgmt.controller.StudentV2Controller;
import com.nepalaya.studentmgmt.provider.JacksonProvider;
import com.nepalaya.studentmgmt.provider.ValidationProvider;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("v2")
public class ApplicationStarter extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // this make jersey work with jackson
        classes.add(JacksonFeature.class);
        classes.add(JacksonProvider.class);
        classes.add(ValidationProvider.class);
        classes.add(StudentV2Controller.class);
        return classes;
    }
}
