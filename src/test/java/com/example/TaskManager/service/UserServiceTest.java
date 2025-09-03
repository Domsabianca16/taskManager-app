package com.example.TaskManager.service;

import com.example.Model.User;
import com.example.Model.dao.UserEntity;
import com.example.Repository.UserRepository;
import com.example.Service.UserService;
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
public class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Test

    void getAllUsers(){
        UserEntity expectedFromDb = new UserEntity();
        expectedFromDb.setId(1L);
        expectedFromDb.setFirstName("Bianca");
        expectedFromDb.setLastName("Domsa");
        expectedFromDb.setProfession("back-end developer");
        List<UserEntity> usersFromDb = new ArrayList<>();
        usersFromDb.add(expectedFromDb);
        Mockito.when(this.repository.findAll()).thenReturn(usersFromDb);
        List<User> expectedUsers = service.getAllUsers();
        Assertions.assertEquals(usersFromDb.size(),expectedUsers.size());
        User actualUser = expectedUsers.get(0);
        Assertions.assertEquals(expectedFromDb.getId(), actualUser.getId());
        Assertions.assertEquals(expectedFromDb.getFirstName(), actualUser.getFirstName());
        Assertions.assertEquals(expectedFromDb.getLastName(), actualUser.getLastName());
        Assertions.assertEquals(expectedFromDb.getProfession(), actualUser.getProfession());
    }
}
