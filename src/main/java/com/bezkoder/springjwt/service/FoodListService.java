package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.FoodList;
import com.bezkoder.springjwt.repository.FoodListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodListService {
    private final FoodListRepository foodListRepository;
    public FoodListService(FoodListRepository foodListRepository){
        this.foodListRepository = foodListRepository;
    }

    public Optional<FoodList> findOne(Long id){
        return foodListRepository.findById(id);
    }

    public List<FoodList>findAll(){
        return foodListRepository.findAll();
    }

    public FoodList save(FoodList foodList){
        return foodListRepository.save(foodList);
    }

    public FoodList update(Long id,FoodList foodList){
        Optional<FoodList>foodList1 = foodListRepository.findById(id);
        FoodList foodList2 = foodList1.get();
        foodList2.setFoodListName(foodList.getFoodListName());
        foodList2.setDescription(foodList.getDescription());

        FoodList foodListUpdate = foodListRepository.save(foodList2);
        return foodListUpdate;
    }

    public void delete(FoodList foodList){
        foodListRepository.delete(foodList);
    }
}
