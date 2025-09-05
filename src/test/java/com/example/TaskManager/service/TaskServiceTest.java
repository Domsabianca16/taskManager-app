package com.example.TaskManager.service;

import com.example.Model.Task;
import com.example.Repository.dao.TaskEntity;
import com.example.Repository.TaskRepository;
import com.example.Service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
 class TaskServiceTest {

    @InjectMocks  /*
    Junit cauta un mock si il injecteaza lui taskRep din
   Task Service ca dependinta
    */

    TaskService service; // this will be tested
    @Mock // imita student repository
    TaskRepository repository;

    @Test
     void firstTest(){
        List<Task> expectedTasks = service.gelAllTasks();

        Assertions.assertTrue(expectedTasks.isEmpty());
    }


    @Test
    void getAllTasksWithSingleTask(){
        TaskEntity expectedFromDb = new TaskEntity();
        expectedFromDb.setId(101L);
        expectedFromDb.setCompleted(true);
        expectedFromDb.setDescription("abc");
        expectedFromDb.setTitle("A");
        List<TaskEntity> tasksFromDb = new ArrayList<>();
        tasksFromDb.add(expectedFromDb);
        Mockito.when(this.repository.findAll()).thenReturn(tasksFromDb);
        List<Task> expectedTasks = service.gelAllTasks();
        Assertions.assertEquals(tasksFromDb.size(),expectedTasks.size());
        Task actualTask = expectedTasks.get(0);
        Assertions.assertEquals(expectedFromDb.getId(),actualTask.getId());
        Assertions.assertEquals(expectedFromDb.getDescription(),actualTask.getDescription());
        Assertions.assertEquals(expectedFromDb.getTitle(),actualTask.getTitle());
        Assertions.assertEquals(expectedFromDb.isCompleted(),actualTask.isCompleted());
    }

    @Test
    void deleteTaskById(){
        this.service.deleteTaskById(100L);
        Mockito.verify(this.repository).deleteById(100L);
    }

}
