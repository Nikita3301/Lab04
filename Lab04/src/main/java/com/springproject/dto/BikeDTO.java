package com.springproject.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BikeDTO {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String type;

    @NotBlank
    @Size(min = 1, max = 100)
    private String frameSize;

    @Min(value = 1)
    private double wheelSize;

    @Min(value = 1)
    private double wheelWidth;

    @Min(value = 1)
    private int numberOfSpeeds;

    @NotBlank
    @Size(min = 1, max = 100)
    private String typeOfBrakes;

    private String userFirstName;
    private String userLastName;
    private double userHeight;
    private double userWeight;


    public BikeDTO() {
    }

    public BikeDTO(final Long id, final String type, final String frameSize, final double wheelSize,
                   final double wheelWidth, final int numberOfSpeeds, final String typeOfBrakes,
                   final String userFirstName, final String userLastName, final double userHeight, final double userWeight) {
        this.id = id;
        this.type = type;
        this.frameSize = frameSize;
        this.wheelSize = wheelSize;
        this.wheelWidth = wheelWidth;
        this.numberOfSpeeds = numberOfSpeeds;
        this.typeOfBrakes = typeOfBrakes;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(final String frameSize) {
        this.frameSize = frameSize;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(final double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public double getWheelWidth() {
        return wheelWidth;
    }

    public void setWheelWidth(final double wheelWidth) {
        this.wheelWidth = wheelWidth;
    }

    public int getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(final int numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public String getTypeOfBrakes() {
        return typeOfBrakes;
    }

    public void setTypeOfBrakes(final String typeOfBrakes) {
        this.typeOfBrakes = typeOfBrakes;
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

    public double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(final double userHeight) {
        this.userHeight = userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(final double userWeight) {
        this.userWeight = userWeight;
    }
}
