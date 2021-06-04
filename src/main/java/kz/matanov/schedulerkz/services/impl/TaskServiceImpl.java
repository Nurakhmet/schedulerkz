package kz.matanov.schedulerkz.services.impl;

import kz.matanov.schedulerkz.entities.Roles;
import kz.matanov.schedulerkz.entities.Tasks;
import kz.matanov.schedulerkz.repositories.RolesRepository;
import kz.matanov.schedulerkz.repositories.TaskRepository;
import kz.matanov.schedulerkz.services.RoleService;
import kz.matanov.schedulerkz.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository tasksRepository;

    @Override
    public Tasks saveTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks addTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks getTask(Long id) {
        Optional<Tasks> opt = tasksRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public void deleteTask(Tasks task) {
        tasksRepository.delete(task);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public List<Tasks> getAllCurrentDay(Date date) {
        return tasksRepository.findAllByToDateExp(date);
    }

    @Override
    public List<Tasks> getAllCurrentDayByUsers(Date date, Long id) {
        return tasksRepository.findAllByToDateExpAndUsers_Id(date,id);
    }

    @Override
    public List<Tasks> getUsersTasks(Long id) {
        return tasksRepository.findAllByUsers_Id(id);
    }
}