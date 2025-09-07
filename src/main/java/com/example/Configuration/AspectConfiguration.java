package com.example.Configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfiguration {
    @Before("execution(* com.example.Service.UserService.getAllUsers(..))")
    public void serviceMethod(){
        System.out.println("S-a chemat service-ul");
    }
}
