import java.time.LocalTime;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 게임 우측 상단에 보이는 날짜 관련 class
 **/

public class Timestamp extends Thread{
    private String region; // 현재 지역
    private int day; // 생존한 일수
    private LocalTime time; // 오늘의 시간 00:00:00 부터 시작
    private Timestamp intervalTime; // 스레드로 초마다 돌릴 객체 생성
    @Override
    public void run() {
        try { // 초마다 1시간씩 증가
            this.time = LocalTime.of(time.getHour() + 1, time.getMinute(), time.getSecond());
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Timestamp() {
        this.region = "서울";
        this.day = 0;
        this.time = LocalTime.of(0, 0, 0);
    }

    public Timestamp(String region, int day) {
        this.region = region;
        this.day = day;
    }

    public void startTime() { // 하루 시작/계속
        intervalTime.start();
    }

    public void stopTime() throws InterruptedException { // 몬스터가 출몰한 경우, 보상을 획득한 경우 시잔을 멈춤
        intervalTime.join();
    }

    public void addDay(int days) { // days 만큼 날짜가 지났을 떄 생존일수에 추가
        this.day += days;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    // getter & setter
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Timestamp getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Timestamp intervalTime) {
        this.intervalTime = intervalTime;
    }
}
