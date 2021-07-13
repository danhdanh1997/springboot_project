package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Food;
import com.bezkoder.springjwt.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    public final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository){
        this.foodRepository=foodRepository;
    }

    public Optional<Food>findOne(String id){
        return foodRepository.findById(id);
    }

    public List<Food>findAll(){
        return foodRepository.findAll();
    }

    public Food save(Food food){
        return foodRepository.save(food);
    }

    public Food update(String id , Food food){
        Optional<Food>food1 = foodRepository.findById(id);
        Food food2 = food1.get();
        food2.setFoodName(food.getFoodName());
        food2.setPrice(food.getPrice());
        food2.setFoodList(food.getFoodList());

        Food foodUpdate = foodRepository.save(food2);
        return foodUpdate;
    }

    public void delete(Food food){
        foodRepository.delete(food);
    }
}
