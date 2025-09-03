package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService injectedUserService){
        this.userService=injectedUserService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> gelAllStudents(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/api/users")
    public void createUser(@RequestBody User userRequest){
        this.userService.createOrUpdateUser(userRequest);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") String userId,
                                     @RequestBody User userRequest){
        this.userService.createOrUpdateUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable("id") Long userId){
        this.userService.deleteUserById(userId);
    }


}
