package com.springproject.dto;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

public class CheckDTO {
    private Long id;

    @Min(value = 1)
    private double price;

    private LocalDateTime leaseStartTime;
    private LocalDateTime leaseEndTime;

    private String userFirstName;
    private String userLastName;

    private List<BikeDTO> bikesDTO;


    public CheckDTO() {
    }

    public CheckDTO(final Long id, final double price, final LocalDateTime leaseStartTime,
                    final LocalDateTime leaseEndTime, final String userFirstName, final String userLastName,
                    final List<BikeDTO> bikesDTO) {
        this.id = id;
        this.price = price;
        this.leaseStartTime = leaseStartTime;
        this.leaseEndTime = leaseEndTime;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.bikesDTO = bikesDTO;
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

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(final String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(final String userLastName) {
        this.userLastName = userLastName;
    }

    public List<BikeDTO> getBikesDTO() {
        return bikesDTO;
    }

    public void setBikesDTO(final List<BikeDTO> bikesDTO) {
        this.bikesDTO = bikesDTO;
    }
}
