package dev.childer.childerserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DesirableCondition")
@Data
@NoArgsConstructor
public class DesirableConditionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "Topic",nullable = false)
    private String topic;

    @Column(name = "Term1")
    private int termOne;

    @Column(name = "Term2")
    private int termTwo;
}
