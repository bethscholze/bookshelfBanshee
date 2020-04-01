package com.bookshelfBanshee.service;

import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json/users")
public class JSONUsers {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //TODO figure out how to do a list with json
    public Response getUsersJSON() {

        ObjectMapper mapper = new ObjectMapper();
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getAll();
        //TODO remove duplicate code
        try {
            String jsonString = mapper.writeValueAsString(users);
            logger.info(jsonString);
            return Response.status(200).entity(jsonString).build();
        } catch (JsonProcessingException e){
            logger.error(e);
            return Response.status(400).build();
        }
        /*if(users != null) {
            return Response.status(200).entity(users).build();
        } else {
            return Response.status(404).build();
        }*/
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserJSON(@PathParam("param") String id) {

        ObjectMapper mapper = new ObjectMapper();
        int userId = Integer.parseInt(id);
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);
        logger.info(user);
        try {
            String jsonString = mapper.writeValueAsString(user);
            logger.info(jsonString);
            return Response.status(200).entity(jsonString).build();
        } catch (JsonProcessingException e){
            logger.error(e);
            return Response.status(400).build();
        }

//        if(user != null) {
//            return Response.status(200).entity(jsonString).build();
//        } else {
//            return Response.status(404).build();
//        }
    }
}