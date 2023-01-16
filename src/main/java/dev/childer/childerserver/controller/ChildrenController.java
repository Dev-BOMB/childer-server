package dev.childer.childerserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.childer.childerserver.dtos.AddressDTO;
import dev.childer.childerserver.dtos.BookDTO;
import dev.childer.childerserver.dtos.ChildrenDTO;
import dev.childer.childerserver.models.AddressModel;
import dev.childer.childerserver.models.BookModel;
import dev.childer.childerserver.models.ChildrenModel;
import dev.childer.childerserver.models.ImageModel;
import dev.childer.childerserver.services.ChildrenService;
import dev.childer.childerserver.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
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
        return new ResponseEntity<>(this.childrenService.findAllChildren(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ChildrenDTO> getOneChildren(@PathVariable Long id) {
        ChildrenDTO childrenDTO = new ChildrenDTO();
        this.childrenService.findChildrenByID(id).map(child -> {
            AddressDTO addressDTO = new AddressDTO();
            BookDTO bookDTO = new BookDTO();
            childrenDTO.setFname(child.getFname());
            childrenDTO.setLname(child.getLname());
            childrenDTO.setNickName(child.getNickName());
            childrenDTO.setEthnicity(child.getEthnicity());
            childrenDTO.setNationality(child.getNationality());
            childrenDTO.setIdCard(child.getIdCard());
            childrenDTO.setBod(child.getBod());
            childrenDTO.setParentName(child.getParentName());
            childrenDTO.setTel(child.getTel());
            childrenDTO.setGrade(child.getGrade());
            childrenDTO.setImage(child.getImage().getName());
            addressDTO.setHouseNumber(child.getAddress().getHouseNumber());
            addressDTO.setMoo(child.getAddress().getMoo());
            addressDTO.setTambon(child.getAddress().getTambon());
            addressDTO.setDistrict(child.getAddress().getDistrict());
            addressDTO.setProvince(child.getAddress().getProvince());
            bookDTO.setSchoolName(child.getBook().getSchoolName());
            bookDTO.setSchoolLocation(child.getBook().getSchoolLocation());
            bookDTO.setAffiliation(child.getBook().getAffiliation());
            bookDTO.setSchoolYear(child.getBook().getSchoolYear());
            childrenDTO.setAddress(addressDTO);
            childrenDTO.setBook(bookDTO);
            return childrenDTO;
        });
        return new ResponseEntity<>(childrenDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<String> postChildren(@RequestPart("image") MultipartFile file, @RequestPart("child") String childrenJson, @RequestPart("address") String addressJson, @RequestPart("book") String bookJson) throws IOException {
        try {
            ChildrenModel children = objectMapper.readValue(childrenJson, ChildrenModel.class);
            AddressModel address = objectMapper.readValue(addressJson, AddressModel.class);
            BookModel book = objectMapper.readValue(bookJson, BookModel.class);
            children.setGrade(this.childrenService.calGrade(children.getBod()));
            children.setBook(book);
            children.setAddress(address);
            ImageModel image = this.imageService.uploadImage(file);
            children.setImage(image);
            this.childrenService.saveChildren(children);
            return new ResponseEntity<>("post success", HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<ChildrenModel>> putChildren(@PathVariable Long id, @RequestBody ChildrenModel children) {
        return new ResponseEntity<>(this.childrenService.updateChildren(id, children), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteChildren(@PathVariable Long id) {
        this.childrenService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has delete.", id), HttpStatus.OK);
    }
}
