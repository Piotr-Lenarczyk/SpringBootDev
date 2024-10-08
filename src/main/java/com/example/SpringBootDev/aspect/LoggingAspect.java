package com.example.SpringBootDev.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
// An Aspect is a Java class with a collection of advices
public class LoggingAspect {
    // Pointcut expression
    @Before("execution(* com.example.SpringBootDev..*(..))")
    // Matches on any method starting with "add" in the repository package
    // @Before("execution(* add*(com.example.SpringBootDev.entity.Account, boolean))")          // Matches on any method starting with "add" and taking Account and boolean as arguments
    // @Before("execution(boolean add*())")                                                     // Matches any boolean method starting with "add"
    // @Before("execution(public void add*())")                                                 // Matches on any method starting with "add"
    // @Before("execution(public void addAccount())")                                           // Matches on any addAccount() method, regardless of the class
    // @Before("execution(public void com.example.SpringBootDev.dao.AccountDAO.addAccount())")  // Matches only the addAccount() method of AccountDAO class
    public void beforeAddAccountAdvice() {
        System.out.println("=====> Calling @Before advice on addAccount() method");
    }
}
