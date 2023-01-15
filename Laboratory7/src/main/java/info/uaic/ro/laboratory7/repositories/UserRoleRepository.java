package info.uaic.ro.laboratory7.repositories;

import info.uaic.ro.laboratory7.entities.UserRole;

import javax.ejb.Stateless;

@Stateless
public class UserRoleRepository extends DataRepository<UserRole> {
    public UserRoleRepository() {
        super(UserRole.class);
    }
}