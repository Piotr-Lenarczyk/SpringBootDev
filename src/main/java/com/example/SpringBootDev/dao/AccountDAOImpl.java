package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + " setName()");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode()");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " - adding to a database");
    }

    @Override
    public boolean noop() {
        System.out.println(getClass() + " noop()");
        return false;
    }
}
