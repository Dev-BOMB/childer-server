package dev.childer.childerserver.dtos;

import dev.childer.childerserver.models.DesirableConditionModel;
import lombok.Data;

import java.util.Set;

@Data
public class DevelopmentDTO {
    private long id;
    private String developmentTopic;
    private String standard;
    private String point;
    private Set<DevelopmentDTO> desirableCondition;
}
