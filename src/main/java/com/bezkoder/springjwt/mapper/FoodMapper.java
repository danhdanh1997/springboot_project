package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.CustomerDTO;
import com.bezkoder.springjwt.dto.FoodDTO;
import com.bezkoder.springjwt.models.Customer;
import com.bezkoder.springjwt.models.Food;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
    public FoodDTO entityToDTO(Food food)
    {
        ModelMapper modelMapper = new ModelMapper();
        FoodDTO foodDTO = modelMapper.map(food,FoodDTO.class);
        return foodDTO;
    }

    public List<FoodDTO> entityToDTO(List<Food>foods)
    {
        return foods.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Food dtoToEntity(FoodDTO foodDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Food food = modelMapper.map(foodDTO,Food.class);
        return food;
    }

    public List<Food>dtoToEntity(List<FoodDTO>foodDTOS)
    {
        return foodDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
