package dev.childer.childerserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estimate")
@Data
@NoArgsConstructor
public class EstimateModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubModel> body = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubModel> emotional = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubModel> society = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubModel> brain = new ArrayList<>();
}
