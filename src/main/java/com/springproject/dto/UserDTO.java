package com.springproject.dto;

import com.springproject.entity.Check;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class UserDTO {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 100)
    private String lastName;

    private LocalDate birth;

    @Min(value = 1)
    private double height;

    @Min(value = 1)
    private double weight;

    private List<CheckDTO> checksDTO;




    public UserDTO() {
    }

    public UserDTO(final Long id, @NotBlank @Size(min = 1, max = 100) final String firstName, @NotBlank @Size(min = 1, max = 100) final String lastName, final LocalDate birth, @Min(value = 1) final double height, @Min(value = 1) final double weight, final List<CheckDTO> checksDTO) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.checksDTO = checksDTO;
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

    public List<CheckDTO> getChecksDTO() {
        return checksDTO;
    }

    public void setChecksDTO(final List<CheckDTO> checksDTO) {
        this.checksDTO = checksDTO;
    }
}
