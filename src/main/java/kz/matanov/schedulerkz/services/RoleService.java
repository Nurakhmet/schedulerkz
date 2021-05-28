package kz.matanov.schedulerkz.services;

import kz.matanov.schedulerkz.entities.Roles;
import kz.matanov.schedulerkz.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface RoleService {

    Roles getRole(Long id);
    List<Roles> getAllRoles();

}
