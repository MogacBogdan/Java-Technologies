package info.uaic.ro.laboratory7.services;

import info.uaic.ro.laboratory7.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Named
@ApplicationScoped
public class UserService {
    final static String API_URL = "http://localhost:8080/RestService-1.0-SNAPSHOT/api";
    final static String GET_ALL_USERS = API_URL + "/users";
    final static String ADD_USER = API_URL + "/users";

    public List<User> findAll() {
        try {
            return ClientBuilder.newClient()
                    .target(URI.create(new URL(GET_ALL_USERS).toExternalForm()))
                    .request(MediaType.APPLICATION_JSON)
                    .get()
                    .readEntity(new GenericType<List<User>>() {});
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void persist(User user) {
        try {
            ClientBuilder.newClient()
                    .target(URI.create(new URL(ADD_USER).toExternalForm()))
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(user, MediaType.APPLICATION_JSON));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
