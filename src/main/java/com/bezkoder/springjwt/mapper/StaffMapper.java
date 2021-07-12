package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.ResourcesDTO;
import com.bezkoder.springjwt.dto.StaffDTO;
import com.bezkoder.springjwt.models.Resources;
import com.bezkoder.springjwt.models.Staff;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffMapper {
    public StaffDTO entityToDTO(Staff staff)
    {
        ModelMapper modelMapper = new ModelMapper();
        StaffDTO staffDTO = modelMapper.map(staff,StaffDTO.class);
        return staffDTO;
    }

    public List<StaffDTO> entityToDTO(List<Staff>staff)
    {
        return staff.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Staff dtoToEntity(StaffDTO staffDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Staff staff = modelMapper.map(staffDTO,Staff.class);
        return staff;
    }

    public List<Staff>dtoToEntity(List<StaffDTO>staffDTOS)
    {
        return staffDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
