package dev.childer.childerserver.services;

import dev.childer.childerserver.models.ChildrenModel;
import dev.childer.childerserver.repositories.ChildrenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildrenService {

    private final ChildrenRepository childrenRepository;

    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public List<ChildrenModel> findAllChildren(){
        return this.childrenRepository.findAll();
    }

    public Optional<ChildrenModel> findChildrenByID(Long id){
        return this.childrenRepository.findById(id);
    }

    public ChildrenModel saveChildren(ChildrenModel children){

        return this.childrenRepository.save(children);
    }

    public Optional<ChildrenModel> updateChildren(Long id , ChildrenModel newChildren){
        return childrenRepository.findById(id).map(children -> {
            children.setFname(newChildren.getFname());
            children.setLname(newChildren.getLname());
            children.setBod(newChildren.getBod());
            children.setGrade(newChildren.getGrade());
            children.setIdCard(newChildren.getIdCard());
            children.setTel(newChildren.getTel());
            children.setParentName(newChildren.getParentName());
            children.setNickName(newChildren.getNickName());
            children.setBook(newChildren.getBook());
            children.setAddress(newChildren.getAddress());
            return childrenRepository.save(children);
        });

    }

    public void deleteByID(Long id){
        this.childrenRepository.deleteById(id);
    }
}
