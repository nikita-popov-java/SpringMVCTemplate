package com.nikitaee.springwebapp.models;

public class Otter {
    private String type;
    private int averageWeight;
    private int averageLength;
    private String photoName;

    public Otter(String type, int averageWeight, int averageLength, String photoName) {
        this.type = type;
        this.averageWeight = averageWeight;
        this.averageLength = averageLength;
        this.photoName = photoName;
    }

    public String getType() {
        return type;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public int getAverageLength() {
        return averageLength;
    }

    public String getPhotoName() {
        return photoName;
    }
}
