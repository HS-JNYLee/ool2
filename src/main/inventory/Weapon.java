package src.main.inventory;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 설명 : 아이템 [무기]에 관한 클래스
 **/

public class Weapon extends Item{
    private String name; // 무기의 이름
    private int remainNumber; // 사용 가능한 횟수
    private int attackStatus; // 무기의 공격력

    // constructor
    public Weapon() {
        this.name = "";
        this.remainNumber = 0;
        this.attackStatus = 0;
    }

    public Weapon(String name, int remainNumber, int attackStatus) {
        this.name = name;
        this.remainNumber = remainNumber;
        this.attackStatus = attackStatus;
    }

    public void subtractNumber() { // 사용 후 사용 가능 횟수 차감
        this.remainNumber--;
        if(this.remainNumber < 0) this.remainNumber = 0;
    }

    public boolean isUsable() {
        return this.remainNumber > 0;
    } // 현재 사용 가능 횟수가 남아있는지 확인


    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(int remainNumber) {
        this.remainNumber = remainNumber;
    }

    public int getAttackStatus() {
        return attackStatus;
    }

    public void setAttackStatus(int attackStatus) {
        this.attackStatus = attackStatus;
    }
}
