package info.uaic.ro.laboratory7.beans;

import com.google.common.hash.Hashing;
import info.uaic.ro.laboratory7.entities.User;
import info.uaic.ro.laboratory7.entities.UserRole;
import info.uaic.ro.laboratory7.services.UserRoleService;
import info.uaic.ro.laboratory7.services.UserService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@Getter
@Setter
@Named
@ApplicationScoped
public class RegisterUserBean implements Serializable {
    @Inject
    UserService userService;
    @Inject
    UserRoleService userRoleService;
    @Inject
    TimeFrameStoreBean timeFrameStoreBean;

    private String username;
    private String password;
    private String role;

    @Transactional
    public void register() {
        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        User user = new User(username, password);
        UserRole userRole = new UserRole(username, role);

        userService.persist(user);
//        userRoleService.persist(userRole);
    }
}
