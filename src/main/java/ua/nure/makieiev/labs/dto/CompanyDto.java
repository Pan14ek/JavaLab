package ua.nure.makieiev.labs.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CompanyDto {

    private long id;

    @NotNull
    @Size(min = 2)
    private String title;

}