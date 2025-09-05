package com.example.Controller;

import com.example.Service.UserService;
import com.example.Service.model.UserDto;
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
    public ResponseEntity<List<UserDto>> gelAllStudents(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

//    @GetMapping("/api/users-pop")
//    public ResponseEntity<List<UserDto>> getAllUsersNamedPop(){
//        return ResponseEntity.ok(userService.findAllNamedPop());
//    }
    @PostMapping("/api/users")
    public void createUser(@RequestBody UserDto userRequest){
        this.userService.createOrUpdateUser(userRequest);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") String userId,
                                     @RequestBody UserDto userRequest){
        this.userService.createOrUpdateUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable("id") Long userId){
        this.userService.deleteUserById(userId);
    }



}
