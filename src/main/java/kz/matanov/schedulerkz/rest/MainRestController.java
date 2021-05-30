package kz.matanov.schedulerkz.rest;

import kz.matanov.schedulerkz.entities.Roles;
import kz.matanov.schedulerkz.entities.Tasks;
import kz.matanov.schedulerkz.entities.Users;
import kz.matanov.schedulerkz.models.UserDTO;
import kz.matanov.schedulerkz.repositories.RolesRepository;
import kz.matanov.schedulerkz.repositories.TaskRepository;
import kz.matanov.schedulerkz.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping(value = "/api")
public class MainRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private TaskRepository tasksRepository;

    Logger logger = LoggerFactory.getLogger(MainRestController.class);

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        Users new_user =  userService.getUserByEmail(user.getUsername());
        if(new_user!=null){
            return ResponseEntity.notFound().build();
        }
        else{

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            List<Roles> roles = new ArrayList<>();
            roles.add(rolesRepository.getOne(1L));
            user.setRoles(roles);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<?> profilePage(){
        Users user = getUser();
        logger.info("kirdi");
//        logger.error("kirmedi");
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(),user.getFullName(), user.getRoles()), HttpStatus.OK);
    }

    private Users getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            Users user = (Users)authentication.getPrincipal();
            return user;
        }
        return null;
    }

    @GetMapping(value = "/allTasks")
    public ResponseEntity<?> getAllTasks(){
        List<Tasks> tasks = tasksRepository.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
