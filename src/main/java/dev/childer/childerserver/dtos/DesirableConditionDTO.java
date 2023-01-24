package dev.childer.childerserver.dtos;

import lombok.Data;

@Data
public class DesirableConditionDTO {
    private Long id;
    private String topic;
    private int termOne;
    private int termTwo;
}
