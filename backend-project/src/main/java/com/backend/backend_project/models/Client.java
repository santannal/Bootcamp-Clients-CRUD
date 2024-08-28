package com.backend.backend_project.models;

import java.io.Serializable;

import com.backend.backend_project.dto.ClientResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    private String name;
    private Double salary;
    private Double bonus;

    public Client() {
    }

    public Client(Long id, String gender, String name, Double salary, Double bonus) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (bonus == null) {
            if (other.bonus != null)
                return false;
        } else if (!bonus.equals(other.bonus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", gender=" + gender + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus
                + "]";
    }

    // public ClientResponse toDTO(){
    //     ClientResponse clientResponse = new ClientResponse();

    //     clientResponse.setId(id);
    //     //gender, name, salary, bonus
    //     clientResponse.setGender(gender);
    //     clientResponse.setName(name);
    //     clientResponse.setSalary(salary);
    //     clientResponse.setBonus(bonus);

    //     return clientResponse;
    // }

}
