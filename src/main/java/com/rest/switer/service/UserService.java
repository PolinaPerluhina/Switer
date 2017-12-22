package com.rest.switer.service;

import com.rest.switer.dao.UserDAO;
import com.rest.switer.model.User;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Palina_Piarlukhina
 */
@Path("users")
public class UserService {
    UserDAO dao = new UserDAO();

    // URI:
    // /switer-1.0/rest/users
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getAllUsers() {
        List<User> listOfUsers = dao.getAllUsers();
        return listOfUsers;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("id") long id) {
        return dao.getUser(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})    
    public Response addUser(User user) {
        User created = dao.addUser(user);
        return Response.ok(created).status(Response.Status.OK).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUser(User user) {        
        User updated = dao.updateUserInfo(user);
        return Response.ok(updated).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteMessage(@PathParam("id") long id) {
        dao.deleteUser(id);
    }
}
