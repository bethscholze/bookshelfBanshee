package com.bookshelfBanshee.service;

import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json/users")
public class JSONUsers {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersJSON() {
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getAll();
        return Response.status(200).entity(users.toString()).build();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserJSON(@PathParam("param") String id) {
        int userId = Integer.parseInt(id);
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);
        return Response.status(200).entity(user.toString()).build();
    }
}
