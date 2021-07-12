package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.SupplierDTO;
import com.bezkoder.springjwt.dto.TimeWorkDTO;
import com.bezkoder.springjwt.models.Supplier;
import com.bezkoder.springjwt.models.TimeWork;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeWorkMapper {
    public TimeWorkDTO entityToDTO(TimeWork timeWork)
    {
        ModelMapper modelMapper = new ModelMapper();
        TimeWorkDTO timeWorkDTO = modelMapper.map(timeWork,TimeWorkDTO.class);
        return timeWorkDTO;
    }

    public List<TimeWorkDTO> entityToDTO(List<TimeWork>timeWorks)
    {
        return timeWorks.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public TimeWork dtoToEntity(TimeWorkDTO timeWorkDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        TimeWork timeWork = modelMapper.map(timeWorkDTO,TimeWork.class);
        return timeWork;
    }

    public List<TimeWork>dtoToEntity(List<TimeWorkDTO>timeWorkDTOS)
    {
        return timeWorkDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
