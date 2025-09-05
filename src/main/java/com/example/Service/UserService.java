package com.example.Service;

import com.example.Repository.dao.UserEntity;
import com.example.Repository.UserRepository;
import com.example.Service.model.TaskDto;
import com.example.Service.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository injectedUserRepository) {
        this.userRepository = injectedUserRepository;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> all = this.userRepository.findAll();
        return all.stream().map(userEntity -> {
            UserDto user = new UserDto();
            user.setId(userEntity.getId());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setProfession(userEntity.getProfession());
            return user;
        }).collect(Collectors.toList());
    }

    public void createOrUpdateUser(UserDto user) {
        UserEntity createOrUpdateMe = new UserEntity();
        createOrUpdateMe.setId(user.getId());
        createOrUpdateMe.setFirstName(user.getFirstName());
        createOrUpdateMe.setLastName(user.getLastName());
        createOrUpdateMe.setProfession(user.getProfession());
        this.userRepository.save(createOrUpdateMe);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

//    public List<UserDto> findAllNamedPop() {
//        return this.userRepository.findAllNamedPop()
//                .stream()
//                .map(userEntity -> {
//                    UserDto dto = new UserDto();
//                    dto.setFirstName(userEntity.getFirstName());
//                    dto.setId(userEntity.getId());
//                    dto.setLastName(userEntity.getLastName());
//                    dto.setProfession(userEntity.getProfession());
//                    dto.setTasks(userEntity.getTasks().stream()
//                            .map(taskEntity -> {
//                                TaskDto taskDto = new TaskDto();
//                                taskDto.setId(taskEntity.getId());
//                                taskDto.setTitle(taskEntity.getTitle());
//                                taskDto.setCompleted(taskEntity.isCompleted());
//                                taskDto.setDescription(taskEntity.getDescription());
//                                return taskDto;
//                            }).collect(Collectors.toSet()));
//                    return dto;
//                         }).collect(Collectors.toList());
//    }
}
