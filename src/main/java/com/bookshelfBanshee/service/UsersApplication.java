package com.bookshelfBanshee.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

// TODO create a security tag for all /admin files
@ApplicationPath("/api")
public class UsersApplication extends Application{
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Users.class);
        h.add(JSONUsers.class);
        return h;
    }

}