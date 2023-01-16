package dev.childer.childerserver.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class BookDTO {

    @NotBlank
    private String schoolName;

    @NotBlank
    private String schoolLocation;

    @NotBlank
    private String affiliation;

    @NotBlank
    private int schoolYear;

}
