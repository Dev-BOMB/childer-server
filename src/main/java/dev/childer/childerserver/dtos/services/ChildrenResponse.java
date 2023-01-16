package dev.childer.childerserver.dtos.services;

import dev.childer.childerserver.dtos.AddressDTO;
import dev.childer.childerserver.dtos.BookDTO;
import dev.childer.childerserver.dtos.ChildrenDTO;
import dev.childer.childerserver.services.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildrenResponse {

    @Autowired
    private ChildrenService childrenService;

    public ChildrenDTO childRes(Long id){
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
        return childrenDTO;
    }
}
