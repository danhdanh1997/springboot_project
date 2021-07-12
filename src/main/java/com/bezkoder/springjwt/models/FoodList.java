package com.bezkoder.springjwt.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food_list")
public class FoodList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_list_id")
    private Long id;

    @Column(name = "food_list_name")
    private String foodListName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "foodList",cascade = CascadeType.ALL)
    private List<Food> foodList;

    public FoodList() {
    }

    public FoodList(Long id, String foodListName, String description) {
        this.id = id;
        this.foodListName = foodListName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodListName() {
        return foodListName;
    }

    public void setFoodListName(String foodListName) {
        this.foodListName = foodListName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
