package com.nikitaee.springwebapp.models;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.NumberFormat;

public class Otter implements Cloneable{

    @NotNull
    @Size(min = 2, max = 20, message = "Некорректный тип выдры!")
    @NotBlank
    private String type;
    @Positive(message = "Вес выдры не может быть неположительным!")
    @Max(value = 100, message = "Выдр такого веса не бывает!")
    @NotBlank
    private int averageWeight;
    @Positive(message = "Длина выдры не может быть не положительной!")
    @Max(value = 200, message = "Выдр такой длины не бывает!")
    @NotBlank
    private int averageLength;
    @URL(message = "Поле должно содерджать ссылку на фото!")
    @NotBlank
    private String photoName;

    public Otter() {

    }

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

    public void setType(String type) {
        this.type = type;
    }

    public void setAverageWeight(int averageWeight) {
        this.averageWeight = averageWeight;
    }

    public void setAverageLength(int averageLength) {
        this.averageLength = averageLength;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%s", type, averageWeight, averageLength, photoName);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
