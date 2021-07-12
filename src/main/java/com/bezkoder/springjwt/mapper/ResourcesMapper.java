package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.ListTableDTO;
import com.bezkoder.springjwt.dto.ResourcesDTO;
import com.bezkoder.springjwt.models.ListTable;
import com.bezkoder.springjwt.models.Resources;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourcesMapper {
    public ResourcesDTO entityToDTO(Resources resources)
    {
        ModelMapper modelMapper = new ModelMapper();
        ResourcesDTO resourcesDTO = modelMapper.map(resources,ResourcesDTO.class);
        return resourcesDTO;
    }

    public List<ResourcesDTO> entityToDTO(List<Resources>resources)
    {
        return resources.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Resources dtoToEntity(ResourcesDTO resourcesDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Resources resources = modelMapper.map(resourcesDTO,Resources.class);
        return resources;
    }

    public List<Resources>dtoToEntity(List<ResourcesDTO>resourcesDTOS)
    {
        return resourcesDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
