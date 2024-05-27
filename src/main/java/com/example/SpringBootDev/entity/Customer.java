package com.example.SpringBootDev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    //Validations
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Column(name = "passes")
    @Min(value = 0, message = "cannot be less than 0")
    @Max(value = 10, message = "cannot be more than 10")
    private int passes;

    public Customer() {
    }

    public Customer(String firstName, String lastName, int passes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passes = passes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passes='" + passes + '\'' +
                '}';
    }
}
