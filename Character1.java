public class Character1 {
    private int hp; // 체력
    private int fullness; // 포만감
    private int water; // 수분
    int attack; // 공격력
    private int defense; // 방어력

    public void SetFullness(int fullness) {
        this.fullness += fullness; // 포만감 증가
    }

    void setHp(int hp){ this.hp=hp;}
   public void SetWater(int water) {
        this.water += water; // 수분 증가
    }

    void setAtk(int attack) {
        this.attack = attack; // 공격력 설정
    }

    void setDef(int defense) {
        this.defense = defense; // 방어력 설정
    }

     void decreaseHp(int hp) {
        this.hp -= hp;
    }
    void increaseHp(int amount) {
        hp += amount;
    }

    void increaseAtk(int amount) {
        attack += amount;
    }

    void increaseFullness(int amount) {
        fullness += amount;
    }

    void increaseWater(int amount) {
        water += amount;
    }
}
