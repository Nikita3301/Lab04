package com.springproject.entity;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private double height;
    private double weight;

    private List<Check> checks;




    public User(){
    }

    public User(final Long id, final String firstName, final String lastName, final LocalDate birth,
                final double height, final double weight, final List<Check> checks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.checks = checks;
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(final List<Check> checks) {
        this.checks = checks;
    }
}
