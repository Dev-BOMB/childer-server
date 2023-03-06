package dev.childer.childerserver.controller;

import dev.childer.childerserver.models.DesirableConditionModel;
import dev.childer.childerserver.services.DesirableConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/desirable")
public class DesirableConditionController {

    @Autowired
    private DesirableConditionService desirableConditionService;

    @GetMapping("")
    public @ResponseBody ResponseEntity<?> findAllDesirable(){
        return new ResponseEntity<>(this.desirableConditionService.findAllDesirableCondition(), HttpStatus.OK);
    }

    @PutMapping("")
    public @ResponseBody ResponseEntity<?> updateByTopic(@RequestBody DesirableConditionModel model){
        this.desirableConditionService.updateDesirableCondition(model);
        return new ResponseEntity<>("update success..",HttpStatus.OK);
    }
}
