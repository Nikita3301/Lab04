package com.springproject.entity;

public class Bike {
    private Long id;
    private String type;
    private String frameSize;
    private double wheelSize;
    private double wheelWidth;
    private int numberOfSpeeds;
    private String typeOfBrakes;



    public Bike() {
    }

    public Bike(final Long id, final String type, final String frameSize, final double wheelSize,
                final double wheelWidth, final int numberOfSpeeds, final String typeOfBrakes) {
        this.id = id;
        this.type = type;
        this.frameSize = frameSize;
        this.wheelSize = wheelSize;
        this.wheelWidth = wheelWidth;
        this.numberOfSpeeds = numberOfSpeeds;
        this.typeOfBrakes = typeOfBrakes;
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
}
