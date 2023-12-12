package src.main.character;

import src.main.inventory.Item;
import src.main.inventory.Weapon;

public class Character extends Item {
    private int hp; // 체력
    private int fullness; // 포만감
    private int water; // 수분
    int attack; // 공격력
    private int defense; // 방어력
    private String name;

    Weapon equippedWeapon; // 장비하고 있는 무기명

    public Character() {
        hp = 100;
        fullness = 0;
        water = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseFullness(int fullness) {

        this.fullness += fullness; // 포만감 증가
        if(this.fullness >= 100) this.fullness = 100;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        this.attack = equippedWeapon.getAttackStatus();
    }

    public int setHp(int hp){ this.hp=hp;
        return hp;
    }
   public void increaseWater(int water) {
        this.water += water; // 수분 증가
       if(this.water >= 100) this.water = 100;
    }

    public void setAttack(int attack) {
        this.attack = attack; // 공격력 설정
    }

    public void decreaseHp(int hp) {
        this.hp -= hp;
        if(this.hp < 0) this.hp =0;
    }
    public void decreaseFullnessAndWater() { // 포만감과 수분 하루치 감소
        int starvedDecreaseSize = 10; // 감소하는 정도
        if(this.water == 0) decreaseHp(starvedDecreaseSize); // 이미 수분이 0이라면 체력 감소
        if(this.fullness == 0) decreaseHp(starvedDecreaseSize); // 이미 포만감이 0이라면 체력 감소
        int dayOfDecreaseSize = 30; // 감소하는 정도
        this.water -= dayOfDecreaseSize;
        this.fullness -= dayOfDecreaseSize;
        if(this.water < 0) this.water =0;
        if(this.fullness < 0) this.fullness =0;
    }

    public void increaseHp(int hp) {
        this.hp += hp;
        if(this.hp >= 100) this.hp = 100;
    }

    void increaseAttack(int attack) {

        this.attack += attack;

    }
    void increaseDefense(int defense) {
        this.defense += defense;
    }

    public int getHp() {
        return hp;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getWater() {
        return water;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
