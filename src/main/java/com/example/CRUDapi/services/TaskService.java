package com.example.CRUDapi.services;

import com.example.CRUDapi.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void saveTask(TaskDto taskDto);

    void updateTask(int id, TaskDto taskDto);

    List<TaskDto> getAllTasks();

    Optional<TaskDto> getTaskById(int id);

    void deleteTask(int id);
}
