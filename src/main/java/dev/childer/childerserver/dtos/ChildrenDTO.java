package dev.childer.childerserver.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ChildrenDTO {

    @NotBlank
    private String fname;

    @NotBlank
    private String lname;

    @NotBlank
    private String nickName;

    @NotBlank
    private String ethnicity;

    @NotBlank
    private String nationality;

    @NotBlank
    private String idCard;

    @NotBlank
    private Date bod;

    @NotBlank
    private String parentName;

    @NotBlank
    private String tel;

    private String grade;
    private String image;

    private AddressDTO address;
    private BookDTO book;
}
