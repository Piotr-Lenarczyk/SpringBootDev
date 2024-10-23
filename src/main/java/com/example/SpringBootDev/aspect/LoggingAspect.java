package com.example.SpringBootDev.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
// An Aspect is a Java class with a collection of advices
public class LoggingAspect {
    // Pointcut declaration - allows reusing a pointcut expression os multiple advices
    // @Pointcut("execution(* com.example.SpringBootDev..*(..))")
    // @Before("execution(* add*(com.example.SpringBootDev.entity.Account, boolean))")          // Matches on any method starting with "add" and taking Account and boolean as arguments
    // @Before("execution(boolean add*())")                                                     // Matches any boolean method starting with "add"
    // @Before("execution(public void add*())")                                                 // Matches on any method starting with "add"
    // @Before("execution(public void addAccount())")                                           // Matches on any addAccount() method, regardless of the class
    // @Before("execution(public void com.example.SpringBootDev.dao.AccountDAO.addAccount())")  // Matches only the addAccount() method of AccountDAO class
    private void firstDeclaration() {
    }

    @Before("processing()")
    public void firstAdvice() {
        System.out.println("=====> Calling logging advice on the method");
    }

    @Pointcut("execution(* com.example.SpringBootDev.dao.*.*(..))")
    private void daoLogging() {
    }

    @Pointcut("execution(* com.example.SpringBootDev.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("execution(* com.example.SpringBootDev.dao.*.get*(..))")
    private void getter() {
    }

    // Combined pointcut expression
    @Pointcut("daoLogging() && !(setter() || getter())")
    private void processing() {
    }
}
