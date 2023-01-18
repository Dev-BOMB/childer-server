package dev.childer.childerserver.dtos.convert;

import dev.childer.childerserver.dtos.ChildrenDTO;
import dev.childer.childerserver.models.ChildrenModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ChildrenConvert {
    public ChildrenDTO modelToDto(Optional<ChildrenModel> childrenModel) {
        ModelMapper mapper = new ModelMapper();
        ChildrenDTO childrenDTO = mapper.map(childrenModel, ChildrenDTO.class);
        return childrenDTO;
    }

    public List<ChildrenDTO> modelToDto(List<ChildrenModel> childrenModel) {
        return childrenModel.stream().map(child -> modelToDto(Optional.ofNullable(child))).collect(Collectors.toList());
    }

    public ChildrenModel dtoToModel(ChildrenDTO childrenDTO) {
        ModelMapper mapper = new ModelMapper();
        ChildrenModel childrenModel = mapper.map(childrenDTO, ChildrenModel.class);
        return childrenModel;
    }

    public List<ChildrenModel> dtoToModel(List<ChildrenDTO> childrenDTO) {
        return childrenDTO.stream().map(child -> dtoToModel(child)).collect(Collectors.toList());
    }
}
