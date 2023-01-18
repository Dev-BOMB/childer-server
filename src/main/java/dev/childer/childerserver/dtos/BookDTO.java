package dev.childer.childerserver.dtos;

import lombok.Data;


@Data
public class BookDTO {
    private Long id;
    private String schoolName;
    private String schoolLocation;
    private String affiliation;
    private int schoolYear;

}
