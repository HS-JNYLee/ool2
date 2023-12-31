package src.main.character;

import src.main.inventory.*;
import src.main.inventory.Character;

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

    public String reward() {
        // 승리 시 보상 (식량, 물, 무기)
        Random random = new Random();
        int addSatiety = random.nextInt(20) + 1;  // 1에서 20까지의 식량 게이지 랜덤 생성
        int randomWeaponDamage = random.nextInt(20) + 1;  // 1에서 30까지의 무기 데미지 랜덤 생성
        int rewardIndex = random.nextInt(3);

        if (rewardIndex == 0) {
            // 식량 지급
            Food food = new Food( 3, addSatiety);
            inventory.addFood(food);
            return "<html><div style='text-align:center;'>승리하였습니다.<br>식량을 획득하였습니다.</div></html>";
        } else if (rewardIndex == 1) {
            // 물 지급
            Water water = new Water( 3, addSatiety);
            inventory.addWater(water);
            return "<html><div style='text-align:center;'>승리하였습니다.<br>물을 획득하였습니다.</div></html>";
        } else {
            // 무기 지급
            Weapon weapon = new Weapon ("weapon",1, randomWeaponDamage); //
            inventory.addWeapon(weapon);
            return "<html><div style='text-align:center;'>승리하였습니다.<br>무기를 획득하였습니다.</div></html>";
        }
    }
}