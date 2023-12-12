package src.main.gui.Panels.EndingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EndingPanel extends JFrame {
    private static final String[] TIPS = {
            "Tip 1: ",
            "Tip 2: ",
            "Tip 3: "
            // 여기에 더 많은 팁을 추가할 수 있습니다.
    };

    public EndingPanel(String message) {
        super("Ending");

        // 전체 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK); // 전체 패널 배경색을 검은색으로 설정

        // 메시지 라벨
        JLabel messageLabel = new JLabel(message);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("NanumGothic", Font.BOLD, 20));
        messageLabel.setForeground(Color.WHITE); // 글자색을 흰색으로 설정

        // 메시지 라벨을 담을 상단 패널
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Color.BLACK); // 상단 패널 배경색을 검은색으로 설정
        messagePanel.add(messageLabel);

        // 하단 패널 (Tip 등을 표시할 부분)
        JPanel tipPanel = new JPanel();
        tipPanel.setBackground(Color.BLACK); // 하단 패널 배경색을 검은색으로 설정
        JLabel tipLabel = new JLabel(getRandomTip());
        tipLabel.setForeground(Color.WHITE); // 글자색을 흰색으로 설정
        tipPanel.add(tipLabel);

        // 전체 패널에 상단 패널과 하단 패널 추가
        mainPanel.add(messagePanel, BorderLayout.CENTER);
        mainPanel.add(tipPanel, BorderLayout.NORTH);

        // 프레임 설정
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String getRandomTip() {
        // 랜덤으로 팁을 선택
        Random random = new Random();
        int index = random.nextInt(TIPS.length);
        return TIPS[index];
    }

    public static void main(String[] args) {
        // 예제 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EndingPanel("게임 클리어 이미지");
            }
        });
    }
}
