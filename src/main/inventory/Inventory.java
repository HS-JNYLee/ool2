package src.main.inventory;

import src.main.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Food> foods;

    private List<Water> waters;
    private List<Weapon> weapons;

    private Weapon equippedWeapon;

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

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
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

    public List<Weapon> useWeapon(Character c, Weapon weapon) {
        List<Weapon> weaponsToRemove = new ArrayList<>();
        for(Weapon useWeapon : weapons) {
            if(useWeapon.getId().equals(weapon.getId())) {
                useWeapon.decreaseRemainNumber(1); // 사용횟수 1회 차감
                if(useWeapon.getRemainNumber() <= 0) { // 0회로 떨어지면
                    weaponsToRemove.add(useWeapon); // 제거할 무기를 추가 // 소지 무기에서 삭제
                }
            }
        }
        weapons.removeAll(weaponsToRemove);
        if(1 <= weaponsToRemove.size()) { // 만약 삭제가 되었다면, 장착된 무기도 변경해줘야 한다.
            c.setEquippedWeapon(weapons.get(0));  // 아직 남아있는 무기 중 하나로 변경
        }
        return weapons;
    }

    public List<Water> deleteWater(Water water) {
        List<Water> removeWaters = new ArrayList<>();
        for(Water w : waters) {
            if(w.getId().equals(water.getId())) {
                removeWaters.add(water);
            }
        }
        waters.removeAll(removeWaters);
        return waters;
    }

    public List<Food> deleteFood(Food food) {
        List<Food> removeFoods = new ArrayList<>();
        for(Food f : foods) {
            if(f.getId().equals(food.getId())) {
                removeFoods.add(food);
            }
        }
        foods.removeAll(removeFoods);
        return foods;
    }


}
