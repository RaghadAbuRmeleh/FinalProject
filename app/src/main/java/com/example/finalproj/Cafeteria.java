package com.example.finalproj;

import java.util.List;

public class Cafeteria {
    public String name;
    public List <FoodItem> foodItems;

    public Cafeteria() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}

 class FoodItem {
    public String name;
    public double price;

     public FoodItem() {
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }
 }