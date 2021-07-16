package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.FoodList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodListRepository extends JpaRepository<FoodList,Long> {
    Page<FoodList> findByFoodListName(String foodListName, Pageable pageable);
    Page<FoodList> findByFoodListNameContaining(String title, Pageable pageable);
}
