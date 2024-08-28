package com.backend.backend_project.dto;

import jakarta.validation.constraints.Min;

public class IntegerDTO {

    @Min(value = 1, message = "Min Value 1")

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
