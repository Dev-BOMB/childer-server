package dev.childer.childerserver.controller;

import dev.childer.childerserver.models.EstimateModel;
import dev.childer.childerserver.services.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estimate")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @GetMapping("")
    public @ResponseBody ResponseEntity<?> getAllEstimate() {
        List<EstimateModel> estimates = estimateService.getAll();
        return new ResponseEntity<>(estimates, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<?> postEstimate(@RequestBody EstimateModel estimate, @PathVariable Long id) {
        return new ResponseEntity<>(this.estimateService.postEstimate(estimate, id), HttpStatus.CREATED);
    }

}
