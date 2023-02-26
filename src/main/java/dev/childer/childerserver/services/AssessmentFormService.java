package dev.childer.childerserver.services;

import dev.childer.childerserver.models.AssessmentFormModel;
import dev.childer.childerserver.repositories.AssessmentFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentFormService {

    private final AssessmentFormRepository assessmentFormRepository;

    public AssessmentFormService(AssessmentFormRepository assessmentFormRepository) {
        this.assessmentFormRepository = assessmentFormRepository;
    }


    public List<AssessmentFormModel> findAllAssessmentForm() {
        return this.assessmentFormRepository.findAll();
    }

    public Optional<AssessmentFormModel> findAssessmentFormByID(Long id) {
        return this.assessmentFormRepository.findById(id);
    }

    public AssessmentFormModel saveAssessmentForm(AssessmentFormModel assessmentForm) {
        return this.assessmentFormRepository.save(assessmentForm);
    }

    public Optional<AssessmentFormModel> updateAssessmentForm(Long id, AssessmentFormModel newAssessmentForm) {
        return assessmentFormRepository.findById(id).map(assessmentForm -> {
            assessmentForm.setTitle(newAssessmentForm.getTitle());
            assessmentForm.setObjective(newAssessmentForm.getObjective());
            return assessmentFormRepository.save(assessmentForm);
        });
    }

    public void deleteByID(Long id) {
        this.assessmentFormRepository.deleteById(id);
    }

    public List<AssessmentFormModel> saveAssessmentFormAll(List<AssessmentFormModel> assessmentForm) {
        return this.assessmentFormRepository.saveAll(assessmentForm);
    }
}
