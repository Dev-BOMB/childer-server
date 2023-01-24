package dev.childer.childerserver.services;

import dev.childer.childerserver.models.DevelopmentModel;
import dev.childer.childerserver.repositories.DevelopmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevelopmentService {

    private final DevelopmentRepository developmentRepository;

    public DevelopmentService(DevelopmentRepository developmentRepository) {
        this.developmentRepository = developmentRepository;
    }

    public List<DevelopmentModel> findAllDevelopment(){
        return this.developmentRepository.findAll();
    }

    public Optional<DevelopmentModel> findDevelopmentByID(Long id){
        return this.developmentRepository.findById(id);
    }

    public DevelopmentModel saveDevelopment(DevelopmentModel development){

        return this.developmentRepository.save(development);
    }

    public Optional<DevelopmentModel> updateDevelopment(Long id, DevelopmentModel newDevelopment){
        return developmentRepository.findById(id).map(development -> {
            development.setDevelopmentTopic(newDevelopment.getDevelopmentTopic());
            development.setStandard(newDevelopment.getStandard());
            development.setPoint(newDevelopment.getPoint());
            development.setDesirableCondition(newDevelopment.getDesirableCondition());
            return developmentRepository.save(development);
        }) ;
    }

    public void deleteByID(Long id){
        this.developmentRepository.deleteById(id);
    }
}
