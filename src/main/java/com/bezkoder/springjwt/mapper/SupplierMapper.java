package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.StaffDTO;
import com.bezkoder.springjwt.dto.SupplierDTO;
import com.bezkoder.springjwt.models.Staff;
import com.bezkoder.springjwt.models.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierMapper {
    public SupplierDTO entityToDTO(Supplier supplier)
    {
        ModelMapper modelMapper = new ModelMapper();
        SupplierDTO supplierDTO = modelMapper.map(supplier,SupplierDTO.class);
        return supplierDTO;
    }

    public List<SupplierDTO> entityToDTO(List<Supplier>suppliers)
    {
        return suppliers.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Supplier dtoToEntity(SupplierDTO supplierDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Supplier supplier = modelMapper.map(supplierDTO,Supplier.class);
        return supplier;
    }

    public List<Supplier>dtoToEntity(List<SupplierDTO>supplierDTOS)
    {
        return supplierDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
