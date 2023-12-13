package src.main.environment;

import src.main.gui.Panels.TimeSettings.TimestampPanel;

import javax.swing.*;
import java.time.LocalTime;

/**
 * 작성자 : JNYLee
 * 마지막 수정 : 23.11.13
 * 게임 우측 상단에 보이는 날짜 관련 class
 **/

public class TimestampThread extends Thread{
    private String region; // 현재 지역
    private int day; // 생존한 일수
    private LocalTime time = LocalTime.of(6, 0, 0); // 오늘의 시간 00:00:00 부터 시작
    private TimestampThread intervalTime; // 스레드로 초마다 돌릴 객체 생성
    private  TimestampPanel.TimestampLabel realtime;
    private  TimestampPanel.TimestampLabel dayLabel;
    private boolean running = true; // 스레드 실행 플래그

    public void stopThread() {
        running = false; // 스레드 일시 중지
    }
    public void resetThread() {
        time = LocalTime.of(6, 0, 0); // 오늘의 시간 00:00:00 부터 시작
    }

    public void startThread() {
        if(!running) {
            running = true; // 스레드 다시 시작
            new Thread(this::run).start();
        }
    }

    @Override
    public void run() {
        while (running) { // 실행 플래그가 true일 때만 루프 실행
            try {
                time = time.plusHours(1);
                if(time.getHour() == 0) {
                    day++;
                    SwingUtilities.invokeLater(() -> dayLabel.setText("Day " + String.format("%02d",day)));
                }
                SwingUtilities.invokeLater(() -> realtime.setText(String.valueOf(time)));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public TimestampThread() {
        this.region = "서울";
        this.day = 0;
        this.time = LocalTime.of(0, 0, 0);
    }
    public TimestampThread(TimestampPanel.TimestampLabel rt, TimestampPanel.TimestampLabel dl) {
        this.realtime = rt;
        this.dayLabel = dl;
        this.day = 1;
    }

    public TimestampThread(String region, int day) {
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

    public TimestampThread getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(TimestampThread intervalTime) {
        this.intervalTime = intervalTime;
    }
}
