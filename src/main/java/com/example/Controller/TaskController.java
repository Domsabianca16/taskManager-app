package com.example.Controller;

import com.example.Model.Task;
import com.example.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService injectedTaskService) {
        this.taskService = injectedTaskService;
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> gelAllTasks() {
        return ResponseEntity.ok(taskService.gelAllTasks());
    }

    @PostMapping("/api/tasks")
    public void createTask(@RequestBody Task taskRequest) {
        this.taskService.createOrUpdateTask(taskRequest);
    }


    @PutMapping("/api/tasks/{id}")
    public ResponseEntity updateTask(@PathVariable("id") String taskId,
                                     @RequestBody Task taskRequest) {
        this.taskService.createOrUpdateTask(taskRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/tasks/{id}")
    public void deleteTaskById(@PathVariable("id") Long taskId) {
        this.taskService.deleteTaskById(taskId);
    }
}
