package dev.childer.childerserver.services;

import dev.childer.childerserver.models.*;
import dev.childer.childerserver.repositories.ChildrenRepository;
import dev.childer.childerserver.repositories.DevelopmentRepository;
import dev.childer.childerserver.repositories.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private ChildrenRepository childrenRepository;

    @Autowired
    private DevelopmentService developmentService;
    @Autowired
    private DevelopmentRepository developmentRepository;

    public List<EstimateModel> getAll() {
        return estimateRepository.findAll();
    }

    public EstimateModel postEstimate(EstimateModel estimate, Long id) {
        EstimateModel estimateData = estimateRepository.save(estimate);
        Optional<ChildrenModel> children = this.childrenRepository.findById(id).map(child -> {
            child.getEstimates().add(estimateData);
            childrenRepository.save(child);
            return null;
        });
        estimate.getBody().forEach(data -> {
            DevelopmentModel developmentBody = new DevelopmentModel();
            DesirableConditionModel desirableConditionBody = new DesirableConditionModel();
            developmentBody.setChild_id(id);
            developmentBody.setDevelopmentTopic("ร่างกาย");
            developmentBody.setStandard(String.valueOf(data.getTitle().charAt(2)));
            developmentBody.setPoint(String.valueOf(data.getTitle().charAt(4)));
            desirableConditionBody.setTopic(data.getTitle());
            desirableConditionBody.setTermOne(data.getScore());
            developmentBody.setDesirableCondition(desirableConditionBody);
            developmentRepository.save(developmentBody);
        });
        estimate.getBrain().forEach(data -> {
            DevelopmentModel developmentBrain = new DevelopmentModel();
            DesirableConditionModel desirableConditionBrain = new DesirableConditionModel();
            developmentBrain.setChild_id(id);
            developmentBrain.setDevelopmentTopic("สติปัญญา");
            developmentBrain.setStandard(String.valueOf(data.getTitle().charAt(2)));
            developmentBrain.setPoint(String.valueOf(data.getTitle().charAt(4)));
            desirableConditionBrain.setTopic(data.getTitle());
            desirableConditionBrain.setTermOne(data.getScore());
            developmentBrain.setDesirableCondition(desirableConditionBrain);
            developmentRepository.save(developmentBrain);
        });
        estimate.getEmotional().forEach(data -> {
            DevelopmentModel developmentEmotional = new DevelopmentModel();
            DesirableConditionModel desirableConditionEmotional = new DesirableConditionModel();
            developmentEmotional.setChild_id(id);
            developmentEmotional.setDevelopmentTopic("อารมณ์ จิตใจ");
            developmentEmotional.setStandard(String.valueOf(data.getTitle().charAt(2)));
            developmentEmotional.setPoint(String.valueOf(data.getTitle().charAt(4)));
            desirableConditionEmotional.setTopic(data.getTitle());
            desirableConditionEmotional.setTermOne(data.getScore());
            developmentEmotional.setDesirableCondition(desirableConditionEmotional);
            developmentRepository.save(developmentEmotional);
        });
        estimate.getSociety().forEach(data -> {
            DevelopmentModel developmentSociety = new DevelopmentModel();
            DesirableConditionModel desirableConditionSociety = new DesirableConditionModel();
            developmentSociety.setChild_id(id);
            developmentSociety.setDevelopmentTopic("สังคม");
            developmentSociety.setStandard(String.valueOf(data.getTitle().charAt(2)));
            developmentSociety.setPoint(String.valueOf(data.getTitle().charAt(4)));
            desirableConditionSociety.setTopic(data.getTitle());
            desirableConditionSociety.setTermOne(data.getScore());
            developmentSociety.setDesirableCondition(desirableConditionSociety);
            developmentRepository.save(developmentSociety);
        });

        return estimateData;
    }

}
