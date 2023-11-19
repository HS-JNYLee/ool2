import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // 레이아웃 매니저를 null로 설정

        JLabel label = new JLabel("");
        label.setBounds(100, 100, 100, 30);  // 레이블의 위치와 크기 설정
        add(label);

        // 설정 버튼 생성
        JButton settingButton = new JButton("설정");
        settingButton.setBounds(1, 1, 60, 30);  // 버튼의 위치와 크기 설정
        add(settingButton);

        // 버튼 생성 및 배치
        JButton button1 = new JButton("식량");
        button1.setBounds(10, 480, 200, 70);  // 버튼의 위치와 크기 설정
        add(button1);

        JButton button2 = new JButton("물");
        button2.setBounds(350, 480, 200, 70);  // 버튼의 위치와 크기 설정
        add(button2);

        JButton button3 = new JButton("무기");
        button3.setBounds(680, 480, 200, 70);  // 버튼의 위치와 크기 설정
        add(button3);

        // 가운데에 위치할 패널 생성
        JPanel panel = new JPanel();
        panel.setBounds(00, 40, 900, 420);  // 패널의 위치와 크기 설정
        panel.setBackground(Color.GRAY);  // 패널의 배경색 설정
        add(panel);  // 패널 추가

        // 창 크기 설정
        setSize(900, 600);

        setLocationRelativeTo(null);

        setVisible(true);
    }
}


