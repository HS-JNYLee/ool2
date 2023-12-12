package src.main.gui.Panels.EndingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndingPanel extends JFrame {
    public EndingPanel(String message) {
        super("Ending");

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 메시지 라벨
        JLabel messageLabel = new JLabel(message);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));



        // 패널에 컴포넌트 추가
        panel.add(messageLabel, BorderLayout.CENTER);

        // 프레임 설정
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // 예제 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EndingPanel("게임 오버");
                // 또는 new EndingPanel("게임 클리어");
            }
        });
    }
}
