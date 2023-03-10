package dev.childer.childerserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Development")
@Data
@NoArgsConstructor
public class DevelopmentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private long child_id;

    @Column(name = "DevelopmentTopic",nullable = false)
    private String developmentTopic;

    @Column(name = "Standard",nullable = false)
    private String standard;

    @Column(name = "Point",nullable = false)
    private String point;

    @OneToOne(cascade = CascadeType.ALL)
    private DesirableConditionModel desirableCondition;

}
