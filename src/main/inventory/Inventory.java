package src.main.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Food> food;

    private List<Water> water;
    private List<Weapon> weapon;

    public Inventory() {
        this.food = new ArrayList<>();
        this.water = new ArrayList<>();
        this.weapon = new ArrayList<>();
    }

    // getters and setters
    public List<Food> getFood() {
        return food;
    }

    public List<Water> getWater() {
        return water;
    }

    public List<Weapon> getWeapon() {
        return weapon;
    }
    
    // 소지한 아이템 [무기]의 배열 리턴
    public List<Weapon> getWeapons() {
        return weapon;
    }

    public List<Weapon> addWeapon(Weapon w) {
        weapon.add(w);
        return weapon;
    }
}
