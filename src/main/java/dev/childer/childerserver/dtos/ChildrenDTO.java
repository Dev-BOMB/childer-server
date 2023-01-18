package dev.childer.childerserver.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class ChildrenDTO {
    private Long id;
    private String fname;
    private String lname;
    private String nickName;
    private String ethnicity;
    private String nationality;
    private String idCard;
    private Date bod;
    private String parentName;
    private String tel;
    private String grade;
    private String image;
    private AddressDTO address;
    private BookDTO book;
}
