package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " - adding to a database");
    }

    @Override
    public boolean noop() {
        System.out.println(getClass() + "noop()");
        return false;
    }
}
