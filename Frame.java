import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // 레이아웃 매니저를 null로 설정

        JLabel label = new JLabel("Character");
        label.setBounds(100, 100, 100, 30);  // 레이블의 위치와 크기 설정
        add(label);

        // 설정 버튼 생성
        JButton settingButton = new JButton("설정");
        settingButton.setBounds(1, 1, 60, 30);  // 버튼의 위치와 크기 설정
        add(settingButton);

        // 버튼 생성 및 배치
        JButton button1 = new JButton("식량");
        button1.setBounds(10, 360, 200, 70);  // 버튼의 위치와 크기 설정
        add(button1);

        JButton button2 = new JButton("물");
        button2.setBounds(300, 360, 200, 70);  // 버튼의 위치와 크기 설정
        add(button2);

        JButton button3 = new JButton("무기");
        button3.setBounds(580, 360, 200, 70);  // 버튼의 위치와 크기 설정
        add(button3);

        // 창 크기 설정
        setSize(800, 500);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        Frame GFrame = new Frame();
    }
}
