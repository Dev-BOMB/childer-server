package dev.childer.childerserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.childer.childerserver.dtos.ChildrenDTO;
import dev.childer.childerserver.dtos.convert.ChildrenConvert;
import dev.childer.childerserver.dtos.response.MessageResponse;
import dev.childer.childerserver.models.ChildrenModel;
import dev.childer.childerserver.services.ChildrenService;
import dev.childer.childerserver.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/children")
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ObjectMapper objectMapper;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<ChildrenModel>> getAllChildren() {
        List<ChildrenModel> children = this.childrenService.findAllChildren();
        return new ResponseEntity<>(children, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ChildrenModel> getOneChildren(@PathVariable Long id) {
        Optional<ChildrenModel> childrenModel = this.childrenService.findChildrenByID(id);
        return new ResponseEntity<>(childrenModel.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<MessageResponse> postChildren(@RequestPart("image") MultipartFile file, @RequestPart("child") String childrenJson) throws IOException {
        try {
            ChildrenModel children = objectMapper.readValue(childrenJson, ChildrenModel.class);
            children.setGrade(this.childrenService.calGrade(children.getBod()));
            String image = this.imageService.uploadImage(file);
            children.setImage(image);
            this.childrenService.saveChildren(children);
            return new ResponseEntity<>(new MessageResponse("Child registered successfully!"), HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<ChildrenModel>> putChildren(@PathVariable Long id, @RequestBody ChildrenModel children) {
        return new ResponseEntity<>(this.childrenService.updateChildren(id, children), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<MessageResponse> deleteChildren(@PathVariable Long id) {
        this.childrenService.deleteByID(id);
        return new ResponseEntity<>(new MessageResponse(String.format("%d has delete.", id)), HttpStatus.OK);
    }
}
