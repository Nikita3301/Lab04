package com.springproject.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Check {
    private Long id;
    private double price;
    private LocalDateTime leaseStartTime;
    private LocalDateTime leaseEndTime;
    private User user;
    private List<Bike> bikes;


    public Check() {
    }

    public Check(final Long id, final double price, final LocalDateTime leaseStartTime,
                 final LocalDateTime leaseEndTime, final User user, final List<Bike> bikes) {
        this.id = id;
        this.price = price;
        this.leaseStartTime = leaseStartTime;
        this.leaseEndTime = leaseEndTime;
        this.user = user;
        this.bikes = bikes;
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public LocalDateTime getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(final LocalDateTime leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public LocalDateTime getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(final LocalDateTime leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(final List<Bike> bikes) {
        this.bikes = bikes;
    }
}
