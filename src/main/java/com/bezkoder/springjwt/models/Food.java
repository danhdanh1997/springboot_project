package com.bezkoder.springjwt.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "foodId")
    @Id
    private String id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_list_id",referencedColumnName = "food_list_id")
    private FoodList foodList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "food_details",
            joinColumns = @JoinColumn(name = "foodId"),
            inverseJoinColumns = @JoinColumn(name = "resourcesId"))
    private Set<Resources> resources = new HashSet<>();

    public Food() {
    }

    public Food(String id, String foodName, BigDecimal price, FoodList foodList) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.foodList = foodList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }
}
