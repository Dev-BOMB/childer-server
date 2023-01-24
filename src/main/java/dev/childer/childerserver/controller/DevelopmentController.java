package dev.childer.childerserver.controller;

import dev.childer.childerserver.dtos.response.MessageResponse;
import dev.childer.childerserver.models.DevelopmentModel;
import dev.childer.childerserver.services.DevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/development")
public class DevelopmentController {

    @Autowired
    private DevelopmentService developmentService;

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<DevelopmentModel>> getAllDevelopment(){
        try {
            return new ResponseEntity<>(this.developmentService.findAllDevelopment(), HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<DevelopmentModel>> getOneDevelopment(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.developmentService.findDevelopmentByID(id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<DevelopmentModel> postDevelopment(@RequestBody DevelopmentModel development){
        try {
            return new ResponseEntity<>(this.developmentService.saveDevelopment(development),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<MessageResponse> putDevelopment(@PathVariable Long id , @RequestBody DevelopmentModel development){
        try {
            Optional<DevelopmentModel> updateData = this.developmentService.updateDevelopment(id,development);

            return new ResponseEntity<>(new MessageResponse(String.format("%d has updated.",updateData.get().getId())),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteDevelopment(@PathVariable Long id){
        try {
            this.developmentService.deleteByID(id);
            return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
}
