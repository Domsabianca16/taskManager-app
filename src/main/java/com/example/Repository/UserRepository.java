package com.example.Repository;

import com.example.Repository.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

//    List<UserEntity> findAllByLastNameContains(String lastName);
//
//    @Query("SELECT u FROM users u WHERE u.lastname LIKE '%Pop%'")
//    List<UserEntity> findAllNamedPop();
}
