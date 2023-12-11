package src.main.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Food> foods;

    private List<Water> waters;
    private List<Weapon> weapons;

    private Weapon equipedWeapon;

    public Inventory() {
        this.foods = new ArrayList<>();
        this.waters = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    // getters and setters
    public List<Food> getFoods() {
        return foods;
    }

    public List<Water> getWaters() {
        return waters;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }


    public List<Weapon> addWeapon(Weapon w) {
        weapons.add(w);
        return weapons;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setWaters(List<Water> waters) {
        this.waters = waters;
    }

    public List<Water> addWater(Water water) {
        waters.add(water);
        return  waters;
    }
    public List<Food> addFood(Food food) {
        foods.add(food);
        return  foods;
    }
}
