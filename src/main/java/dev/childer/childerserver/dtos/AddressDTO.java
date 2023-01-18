package dev.childer.childerserver.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String houseNumber;
    private String moo;
    private String tambon;
    private String district;
    private String province;
}
