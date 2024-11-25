package com.example.CRUDapi.services;

import com.example.CRUDapi.entities.Task;
import com.example.CRUDapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task taskEntity){
        taskRepository.save(taskEntity);
    }


    public List<Task> getAll(){
        return taskRepository.findAll();
    }
}
