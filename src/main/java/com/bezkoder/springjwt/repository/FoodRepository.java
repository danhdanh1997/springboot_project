package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,String> {
}
