package dev.childer.childerserver.services;

import dev.childer.childerserver.models.DesirableConditionModel;
import dev.childer.childerserver.repositories.DesirableConditionRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class DesirableConditionService {

    private final DesirableConditionRepository desirableConditionRepository;

    public DesirableConditionService(DesirableConditionRepository desirableConditionRepository) {
        this.desirableConditionRepository = desirableConditionRepository;
    }

    public List<DesirableConditionModel> findAllDesirableCondition(){
        return this.desirableConditionRepository.findAll();
    }

    public Optional<DesirableConditionModel> findDesirableConditionByID(Long id){
        return this.desirableConditionRepository.findById(id);
    }

    public DesirableConditionModel saveDesirableCondition(DesirableConditionModel desirableCondition){

        return this.desirableConditionRepository.save(desirableCondition);
    }

    public Optional<DesirableConditionModel> updateDesirableCondition(Long id, DesirableConditionModel newDesirableCondition){
        return desirableConditionRepository.findById(id).map(desirableCondition -> {
            desirableCondition.setTopic(newDesirableCondition.getTopic());
            desirableCondition.setTermOne(newDesirableCondition.getTermOne());
            desirableCondition.setTermTwo(newDesirableCondition.getTermTwo());
            return desirableConditionRepository.save(desirableCondition);
        });
    }

    public void deleteByID(Long id){
        this.desirableConditionRepository.deleteById(id);
    }
}
