package com.backend.backend_project.dto;

import com.backend.backend_project.models.Client;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
// import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientRequest {

    @NotNull
    private Integer gender;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 5, max = 255, message = "Name length min=5 and max=255")
    private String name;

    @NotNull(message = "Bonus can not be null")
    @Min(value = 0, message = "Bonus Min value = 0")
    @Max(value = 100, message = "Bonus Max value = 100")
    private Double bonus;

    @NotNull(message = "Salary can not be null")
    @Positive(message = "Salary can not be <= 0")
    private Double salary;

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Client toEntity() {

        Client client = new Client();

        client.setGender(gender);
        client.setName(name);
        client.setSalary(salary);
        client.setBonus(bonus);

        return client;
    }

}
