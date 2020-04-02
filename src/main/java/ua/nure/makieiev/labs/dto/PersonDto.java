package ua.nure.makieiev.labs.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonDto {

    private long id;

    @NotNull
    @Size(min = 6)
    private String firstName;

    @NotNull
    @Size(min = 6)
    private String lastName;

    @NotNull
    private int age;

    @NotNull
    private String gender;

    @NotNull
    private double weight;

    @NotNull
    private double height;

}