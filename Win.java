import src.main.inventory.Food;
import src.main.inventory.Inventory;
import src.main.inventory.Water;
import src.main.inventory.Weapon;

import java.util.Random;

public class Win {
    private Inventory inventory;

    public Win(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean chWin(Character c, Monster m) {
        // 이기면 true, 지면 false
        if(c.attack > m.attack){
            return true;
        }
        else
            return false;
    }

    public void Reward() {
        // 승리 시 보상 (식량, 물, 무기)
        Random random = new Random();
        int rewardIndex = random.nextInt(3);

        if (rewardIndex == 0) {
            // 식량 지급
            Food food = new Food( 3, 10);
            inventory.getFood().add(food);
        } else if (rewardIndex == 1) {
            // 물 지급
            Water water = new Water( 3, 10);
            inventory.getWater().add(water);
        } else {
            // 무기 지급
            Weapon weapon = new Weapon ("weaopon",1, 20); //
            inventory.getWeapon().add(weapon);
        }
    }
}