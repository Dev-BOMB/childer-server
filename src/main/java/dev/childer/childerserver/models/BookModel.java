package dev.childer.childerserver.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BookModel")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = BookModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class BookModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Schoolname", nullable = false)
    private String schoolName;

    @Column(name = "SchoolLocation", nullable = false)
    private String schoolLocation;

    @Column(name = "Affiliation", nullable = false)
    private String affiliation;

    @Column(name = "SchoolYear", nullable = false)
    private int schoolYear;

    @Column(name = "Room" , nullable = false)
    private int room;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ChildrenModel children;
}
