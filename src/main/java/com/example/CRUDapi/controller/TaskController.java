package com.example.CRUDapi.controller;

import com.example.CRUDapi.entities.Task;
import com.example.CRUDapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<Task>> listAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok().body(tasks);
    }
}
