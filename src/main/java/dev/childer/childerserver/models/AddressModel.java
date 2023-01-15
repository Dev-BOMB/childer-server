package dev.childer.childerserver.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = AddressModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AddressModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "HouseNumber",nullable = false)
    private String houseNumber;

    @Column(name = "Moo",nullable = false)
    private String moo;

    @Column(name = "Tambon",nullable = false)
    private String tambon;

    @Column(name = "District",nullable = false)
    private String district;

    @Column(name = "Province",nullable = false)
    private String province;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private ChildrenModel children;
}
