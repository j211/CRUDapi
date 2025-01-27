package com.example.CRUDapi.controller;

import com.example.CRUDapi.dto.TaskDto;
import com.example.CRUDapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable int id) {
        Optional<TaskDto> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> addNewTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id, @RequestBody TaskDto taskDto) {
        taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
