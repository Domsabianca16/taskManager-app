package com.example.Service;


import com.example.Repository.TaskRepository;
import com.example.Repository.dao.TaskEntity;
import com.example.Service.model.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository injectedTaskRepository){
        this.taskRepository = injectedTaskRepository;
    }

    public List<TaskDto> gelAllTasks(){
        final List<TaskEntity> all = this.taskRepository.findAll();
        return all.stream().map(taskEntity -> {
            TaskDto createdTask = new TaskDto();
            createdTask.setId(taskEntity.getId());
            createdTask.setCompleted(taskEntity.isCompleted());
            createdTask.setDescription(taskEntity.getDescription());
            createdTask.setTitle(taskEntity.getTitle());
            return createdTask;
        }).collect(Collectors.toList());
    }

    public void createOrUpdateTask(TaskDto task){
        TaskEntity createOrUpdateMe = new TaskEntity();
        createOrUpdateMe.setId(task.getId());
        createOrUpdateMe.setCompleted(task.isCompleted());
        createOrUpdateMe.setDescription(task.getDescription());
        createOrUpdateMe.setTitle(task.getTitle());
        this.taskRepository.save(createOrUpdateMe);
    }

    public void deleteTaskById(Long id){
        this.taskRepository.deleteById(id);
    }


}