package com.example.SpringBootDev.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addMembership() {
        System.out.println(getClass() + " - adding to a membership database table");
        return true;
    }

    @Override
    public String skip() {
        return getClass() + " skipped";
    }
}
