package com.example.Service;

import com.example.Model.User;
import com.example.Model.dao.UserEntity;
import com.example.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository injectedUserRepository){
        this.userRepository=injectedUserRepository;
    }

    public List<User> getAllUsers(){
        List<UserEntity> all = this.userRepository.findAll();
        return all.stream().map(userEntity -> {
            User user = new User();
            user.setId(userEntity.getId());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setProfession(userEntity.getProfession());
            return user;
        }).collect(Collectors.toList());
    }

    public void createOrUpdateUser(User user){
        UserEntity createOrUpdateMe = new UserEntity();
        createOrUpdateMe.setId(user.getId());
        createOrUpdateMe.setFirstName(user.getFirstName());
        createOrUpdateMe.setLastName(user.getLastName());
        createOrUpdateMe.setProfession(user.getProfession());
        this.userRepository.save(createOrUpdateMe);
    }

    public void deleteUserById(Long id){
        this.userRepository.deleteById(id);
    }
}
