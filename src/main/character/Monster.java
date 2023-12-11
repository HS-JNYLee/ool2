package src.main.character;

public class Monster {
    int attack;
    private String name;
    public Monster(int attack, String name) { //몬스터 생성(공격력,이름)
        this.attack = attack;
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
