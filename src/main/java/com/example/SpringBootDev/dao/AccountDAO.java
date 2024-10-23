package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Account;

public interface AccountDAO {
    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    void addAccount(Account account, boolean vipFlag);

    boolean noop();
}
