package dev.childer.childerserver.controller;

import dev.childer.childerserver.dtos.response.MessageResponse;
import dev.childer.childerserver.models.AssessmentFormModel;
import dev.childer.childerserver.services.AssessmentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/assessmentForm")
public class AssessmentFormController {

    @Autowired
    private AssessmentFormService assessmentFormService;

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<AssessmentFormModel>> getAllAssessmentForm(){
        try {
            return new ResponseEntity<>(this.assessmentFormService.findAllAssessmentForm(), HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<AssessmentFormModel>> getOneAssessmentForm(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.assessmentFormService.findAssessmentFormByID(id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<AssessmentFormModel> postAssessment(@RequestBody AssessmentFormModel assessmentForm){
        try {
            return new ResponseEntity<>(this.assessmentFormService.saveAssessmentForm(assessmentForm),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<MessageResponse> putAssessmentForm(@PathVariable Long id , @RequestBody AssessmentFormModel assessmentForm){
        try {
            Optional<AssessmentFormModel> updateData = this.assessmentFormService.updateAssessmentForm(id,assessmentForm);

            return new ResponseEntity<>(new MessageResponse(String.format("%d has updated.",updateData.get().getId())),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteAssessmentForm(@PathVariable Long id){
        try {
            this.assessmentFormService.deleteByID(id);
            return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
}
