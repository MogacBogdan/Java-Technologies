package info.uaic.ro.laboratory7.services;

import info.uaic.ro.laboratory7.entities.UserRole;
import info.uaic.ro.laboratory7.repositories.UserRoleRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserRoleService {
    @Inject
    private UserRoleRepository userRoleRepository;

    public void persist(UserRole userRole) {
       userRoleRepository.persist(userRole);
    }
}
