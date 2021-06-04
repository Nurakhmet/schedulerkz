package kz.matanov.schedulerkz.rest;

import kz.matanov.schedulerkz.entities.Roles;
import kz.matanov.schedulerkz.entities.Tasks;
import kz.matanov.schedulerkz.entities.Users;
import kz.matanov.schedulerkz.models.UserDTO;
import kz.matanov.schedulerkz.repositories.RolesRepository;
import kz.matanov.schedulerkz.repositories.TaskRepository;
import kz.matanov.schedulerkz.services.TaskService;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MainRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RolesRepository rolesRepository;


    Logger logger = LoggerFactory.getLogger(MainRestController.class);

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        Users new_user =  userService.getUserByEmail(user.getUsername());
        if(new_user!=null){
            logger.error("please try again registration part");
            return ResponseEntity.notFound().build();
        }
        else{
            logger.info("registration was successfully");
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
        logger.info("jwt was used");
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
        Users user = getUser();
        logger.info("all tasks by user with id:" + user.getId());
        List<Tasks> tasks = taskService.getUsersTasks(user.getId());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<?> addDish(@RequestBody Tasks tasks){
        Users user = getUser();
        tasks.setUsers(user);
        tasks.setDone(false);
        taskService.addTask(tasks);
        logger.info("task was successfully added by user with id:"+ user.getId());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value = "/getTask/{id}")
    public ResponseEntity<?> getTask(@PathVariable(name = "id") Long id){
        Tasks tasks = taskService.getTask(id);
        if(tasks!=null){
            logger.info("Task was successfully found");
            return ResponseEntity.ok(tasks);
        }else{
            logger.error("There is no task!");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/getCurrentTask")
    public ResponseEntity<?> getCurrentTask() throws ParseException {
        Users user = getUser();

        Date in = new Date();
        Date out = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(in);
        logger.info("local date "+date);
        List<Tasks> tasks = taskService.getAllCurrentDayByUsers(new SimpleDateFormat("yyyy-MM-dd").parse(date), user.getId());
        if(tasks!=null){
            logger.info("Task was successfully found");
            return ResponseEntity.ok(tasks);
        }else{
            logger.error("There is no task!");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/saveTasks")
    public ResponseEntity<?> saveTask(@RequestBody Tasks tasks){
        Users user = getUser();
        Tasks tasks1 = taskService.getTask(tasks.getId());
        tasks1.setUsers(user);
        tasks1.setDone(tasks.isDone());
        tasks1.setTaskText(tasks.getTaskText());
        tasks1.setToDateExp(tasks.getToDateExp());
        taskService.saveTask(tasks1);
        logger.info("Task was successfully updated");
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/getTaskByDate/{toSearchDateExp}")
    public ResponseEntity<?> getSearchDishes(@PathVariable(name = "toSearchDateExp") String toSearchDateExp) throws ParseException {
        Users user = getUser();
        Date in = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(toSearchDateExp);
        logger.info("Date from request method"+toSearchDateExp);
        if(startDate!=in) {
            logger.info("There are tasks with "+toSearchDateExp + " date.");
            List<Tasks> tasks = taskService.getAllCurrentDayByUsers(startDate,user.getId());
            return new ResponseEntity<>(tasks,HttpStatus.OK);
        }else{
            logger.error("Tasks with "+toSearchDateExp + " not founded");
            List<Tasks> tasks = taskService.getUsersTasks(user.getId());
            return new ResponseEntity<>(tasks,HttpStatus.OK);

        }
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public ResponseEntity<?> deleteTasks(@PathVariable(name = "id")Long id){

        taskService.deleteTask(taskService.getTask(id));
        logger.info("The task was deleted (Task ID was: "+id+ ")");
        return ResponseEntity.ok().build();
    }



}
