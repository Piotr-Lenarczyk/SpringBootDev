package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    boolean noop();
}
