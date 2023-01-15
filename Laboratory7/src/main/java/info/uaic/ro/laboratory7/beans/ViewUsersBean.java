package info.uaic.ro.laboratory7.beans;

import info.uaic.ro.laboratory7.entities.User;
import info.uaic.ro.laboratory7.services.UserService;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Setter
@Named
@SessionScoped
public class ViewUsersBean implements Serializable {
    @Inject
    private UserService userService;

    private List<User> users;

    @PostConstruct
    public void init() {
        users = userService.findAll();
    }

    public List<User> getUsers() {
        users = userService.findAll();
        return users;
    }

}
