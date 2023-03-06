package dev.childer.childerserver.services;

import dev.childer.childerserver.models.DesirableConditionModel;
import dev.childer.childerserver.repositories.DesirableConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesirableConditionService {

    @Autowired
    private DesirableConditionRepository desirableConditionRepository;

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

    public Optional<DesirableConditionModel> updateDesirableCondition(DesirableConditionModel newDesirableCondition){
        return desirableConditionRepository.findByTopic(newDesirableCondition.getTopic()).map(desirableCondition -> {
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
