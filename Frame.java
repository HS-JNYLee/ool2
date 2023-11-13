import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("");
        getContentPane().add(label, BorderLayout.NORTH);

        // 설정 버튼 생성
        JButton settingButton = new JButton("설정");
        // 버튼의 크기 설정
        Dimension settingButtonSize = new Dimension(60, 1);
        settingButton.setPreferredSize(settingButtonSize);
        // 왼쪽 상단에 설정 버튼 추가
        getContentPane().add(settingButton, BorderLayout.WEST);

        // 버튼을 담을 패널 생성
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0)); // 간격을 조절하는 부분

        // 각각의 버튼 생성
        JButton button1 = new JButton("식량");
        JButton button2 = new JButton("물");
        JButton button3 = new JButton("무기");

        // 각 버튼의 크기 설정
        Dimension buttonSize = new Dimension(260, 80);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        // 패널에 각 버튼 추가
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // 창의 SOUTH에 패널 추가
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // 창 크기 설정
        setSize(800, 500);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        Frame GFrame = new Frame();
    }
}
