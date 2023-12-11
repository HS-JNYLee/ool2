package src.main.inventory;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 설명 : 캐릭터의 [수분]과 아이템 [물]에 관한 클래스
 **/

public class Water extends Item{
    private int remainDays; // 물을 복용할 수 있는 날짜를 저장
    private int addWater; // 이 음식을 먹었을 때 증가하는 수분 수치

    public Water() {
        this.remainDays = 0;
        this.addWater = 0;
    }

    public Water(int remainDays, int addWater) { // 물 객체를 생성할 때 남은 날짜와 수분 수치를 정해줌
        this.remainDays = remainDays;
        this.addWater = addWater;
    }

    public void subtractDay() { // 하루가 지나서 물의 남은 날짜 -1
        this.remainDays--;
        if(this.remainDays < 0) this.remainDays = 0; // 남은 일수가 0일보다 작아지면, 0을 유지
    }

    public boolean isEatable() { // 물을 먹을 수 있는지 (남은 일수가 0이상인지) 확인하는 메서드
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

    public int getAddWater() {
        return addWater;
    }

    public void setAddWater(int addWater) {
        this.addWater = addWater;
    }
}
