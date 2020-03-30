package com.bookshelfBanshee.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// TODO create a security tag for all /admin files
@ApplicationPath("/admin")
public class UsersApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Users.class);
        return h;
    }
}
