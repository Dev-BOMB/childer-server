package dev.childer.childerserver.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class AddressDTO {

    @NotBlank
    private String houseNumber;

    @NotBlank
    private String moo;

    @NotBlank
    private String tambon;

    @NotBlank
    private String district;

    @NotBlank
    private String province;
}
