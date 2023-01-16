package dev.childer.childerserver.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Children")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = ChildrenModel.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChildrenModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Fname", nullable = false)
    private String fname;

    @Column(name = "Lname", nullable = false)
    private String lname;

    @Column(name = "Nickname", nullable = false)
    private String nickName;

    @Column(name = "Ethnicity", nullable = false)
    private String ethnicity;

    @Column(name = "Nationality", nullable = false)
    private String nationality;

    @Column(name = "IDcard", length = 13, nullable = false)
    private String idCard;

    @Column(name = "BOD", nullable = false)
    private Date bod;

    @Column(name = "Parentname", nullable = false)
    private String parentName;

    @Column(name = "Grade")
    private String grade;

    @Column(name = "Tel", nullable = false, length = 10)
    private String tel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookModel book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressModel address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private ImageModel image;

}
