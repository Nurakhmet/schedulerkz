package kz.matanov.schedulerkz.services;

import kz.matanov.schedulerkz.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Users saveUser(Users user);
    Users addUser(Users user);
    Users getUser(Long id);
    void deleteUser(Users user);
    List<Users> getAllUsers();

    Users getUserByEmail(String email);
}
