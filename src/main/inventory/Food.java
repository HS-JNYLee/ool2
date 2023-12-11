package src.main.inventory;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 설명 : 캐릭터의 [포만감]과 아이템 [음식]에 관한 클래스
 **/

public class Food extends Item{
    private int remainDays; // 음식을 복용할 수 있는 날짜를 저장
    private int addSatiety; // 이 음식을 먹었을 때 증가하는 포만감 수치

    public Food() {
        this.remainDays = 0;
        this.addSatiety = 0;
    }

    public Food(int remainDays, int addSatiety) { // 음식 객체를 생성할 때 남은 날짜와 포만감 수치를 정해줌
        this.remainDays = remainDays;
        this.addSatiety = addSatiety;
    }

    public void subtractDay() { // 하루가 지나서 음식의 남은 날짜 -1
        this.remainDays--;
        if(this.remainDays < 0) this.remainDays = 0; // 남은 일수가 0일보다 작아지면, 0을 유지
    }

    public boolean isEatable() {
        if(remainDays <= 0) return false;
        else return true;
    }

    // getter & setter
    public int getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(int remainDays) {
        this.remainDays = remainDays;
    }

    public int getAddSatiety() {
        return addSatiety;
    }

    public void setAddSatiety(int addSatiety) {
        this.addSatiety = addSatiety;
    }
}
