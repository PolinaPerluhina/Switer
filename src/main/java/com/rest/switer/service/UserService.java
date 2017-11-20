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

/**
 *
 * @author Palina_Piarlukhina
 */
@Path("users")
public class UserService {

    // URI:
    // /switer-1.0/rest/users
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getAllUsers() {
        List<User> listOfUsers = UserDAO.getAllUsers();
        return listOfUsers;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("id") long id) {
        return UserDAO.getUser(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public void addUser(User user) {
        UserDAO.addUser(user);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public void updateUser(User user) {
        UserDAO.updateUserInfo(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteMessage(@PathParam("id") long id) {
        UserDAO.deleteUser(id);
    }
}
