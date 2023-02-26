package dev.childer.childerserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "AssessmentForm")
@Data
@NoArgsConstructor
public class AssessmentFormModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "Title",nullable = false)
    private String title;

    @Column(name = "Objective",nullable = false)
    private String objective;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String field;

    @Column(nullable = false)
    private String week;

}
