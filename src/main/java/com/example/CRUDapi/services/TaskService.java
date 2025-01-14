package com.example.CRUDapi.services;

import com.example.CRUDapi.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(int id);

    void deleteTask(int id);
}
