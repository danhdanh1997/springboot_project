package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.FoodListDTO;
import com.bezkoder.springjwt.dto.ListTableDTO;
import com.bezkoder.springjwt.models.FoodList;
import com.bezkoder.springjwt.models.ListTable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListTableMapper {
    public ListTableDTO entityToDTO(ListTable listTable)
    {
        ModelMapper modelMapper = new ModelMapper();
        ListTableDTO listTableDTO = modelMapper.map(listTable,ListTableDTO.class);
        return listTableDTO;
    }

    public List<ListTableDTO> entityToDTO(List<ListTable>listTables)
    {
        return listTables.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public ListTable dtoToEntity(ListTableDTO listTableDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        ListTable listTable = modelMapper.map(listTableDTO,ListTable.class);
        return listTable;
    }

    public List<ListTable>dtoToEntity(List<ListTableDTO>listTableDTOS)
    {
        return listTableDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
