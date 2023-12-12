package src.main.character;

import src.main.inventory.Weapon;

public class Character {
    private int hp; // 체력
    private int fullness; // 포만감
    private int water; // 수분
    int attack; // 공격력
    private int defense; // 방어력


    Weapon equippedWeapon; // 장비하고 있는 무기명

    public Character() {
        hp = 100;
        fullness = 0;
        water = 0;
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

    void setHp(int hp){ this.hp=hp;}
   public void increaseWater(int water) {
        this.water += water; // 수분 증가
       if(this.water >= 100) this.water = 100;
    }

    public void setAttack(int attack) {
        this.attack = attack; // 공격력 설정
    }

    public void decreaseHp(int hp) {
        this.hp += hp;
        if(this.hp < 0) this.hp =0;
    }
    public void increaseHp(int hp) {
        this.hp += hp;
        if(this.hp >= 100) this.hp = 100;
    }

    void increaseAttack(int attack) {

        this.attack += attack;

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
