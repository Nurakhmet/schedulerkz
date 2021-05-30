package kz.matanov.schedulerkz.services;

import kz.matanov.schedulerkz.entities.Tasks;
import java.util.List;

public interface TaskService {
    Tasks saveTask(Tasks task);
    Tasks addTask(Tasks task);
    Tasks getTask(Long id);
    void deleteTask(Tasks task);
    List<Tasks> getAllTasks();

}
