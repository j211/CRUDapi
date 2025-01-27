package com.example.CRUDapi.services;

import com.example.CRUDapi.dto.TaskDto;
import com.example.CRUDapi.entities.Task;
import com.example.CRUDapi.exception.TaskNotFoundException;
import com.example.CRUDapi.mappers.TaskMapper;
import com.example.CRUDapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
    }

    @Override
    public void updateTask(int id, TaskDto taskDto) {
        TaskDto updTask = getTaskById(id).orElseThrow(() -> new TaskNotFoundException("Task with "+id+" is not found!"));
        updTask.setTitle(taskDto.getTitle());
        updTask.setDescription(taskDto.getDescription());
        updTask.setUserId(taskDto.getUserId());
        taskMapper.toDto(taskRepository.save(taskMapper.toEntity(updTask)));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> listTasks =  taskRepository.findAll();
        return listTasks.stream().map(taskMapper::toDto).toList();
    }

    @Override
    public Optional<TaskDto> getTaskById(int id) {
        Optional<Task> optTask = taskRepository.findById(id);
        return optTask.map(taskMapper::toDto);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
