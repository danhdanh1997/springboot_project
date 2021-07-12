package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.FoodDTO;
import com.bezkoder.springjwt.dto.FoodListDTO;
import com.bezkoder.springjwt.models.Food;
import com.bezkoder.springjwt.models.FoodList;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodListMapper {
    public FoodListDTO entityToDTO(FoodList food)
    {
        ModelMapper modelMapper = new ModelMapper();
        FoodListDTO foodDTO = modelMapper.map(food,FoodListDTO.class);
        return foodDTO;
    }

    public List<FoodListDTO> entityToDTO(List<FoodList>foods)
    {
        return foods.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public FoodList dtoToEntity(FoodListDTO foodListDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        FoodList foodList = modelMapper.map(foodListDTO,FoodList.class);
        return foodList;
    }

    public List<FoodList>dtoToEntity(List<FoodListDTO>foodListDTOS)
    {
        return foodListDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
