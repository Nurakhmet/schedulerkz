package kz.matanov.schedulerkz.services.impl;

import kz.matanov.schedulerkz.entities.Roles;
import kz.matanov.schedulerkz.repositories.RolesRepository;
import kz.matanov.schedulerkz.repositories.UserRepository;
import kz.matanov.schedulerkz.services.RoleService;
import kz.matanov.schedulerkz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles getRole(Long id) {
        Optional<Roles> opt = rolesRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }
}