package src.main.character;

public class Character {
    private int hp; // 체력
    private int fullness; // 포만감
    private int water; // 수분
    int attack; // 공격력
    private int defense; // 방어력


    String equippedWeaponId; // 장비하고 있는 무기명

    public Character() {
        hp = 100;
        fullness = 0;
        water = 0;
    }
    public void increaseFullness(int fullness) {
        this.fullness += fullness; // 포만감 증가
    }
    
    public String getEquippedWeaponId() {
        return equippedWeaponId;
    }

    public void setEquippedWeaponId(String equippedWeaponId) {
        this.equippedWeaponId = equippedWeaponId;
    }

    void setHp(int hp){ this.hp=hp;}
   public void increaseWater(int water) {
        this.water += water; // 수분 증가
    }

    public void setAttack(int attack) {
        this.attack = attack; // 공격력 설정
    }

    void decreaseHp(int hp) {
        this.hp -= hp;
    }
    void increaseHp(int hp) {
        this.hp += hp;
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
