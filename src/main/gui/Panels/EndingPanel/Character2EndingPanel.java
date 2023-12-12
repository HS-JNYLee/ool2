package src.main.gui.Panels.EndingPanel;

import src.main.character.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Character2EndingPanel extends JFrame {
    private static final String[] TIPS = {
            //게임에서 승리할 수 있는 조언들
            "안전지대인 제주도로 탈출에 성공했어요!!",

    };

    public Character2EndingPanel() {
        super("Game Over");

        // 패널을 생성할 때 배경색을 검은색으로 설정
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);  // 전체 패널의 배경색을 검은색으로 변경
        add(mainPanel);

        // 게임 오버 이미지
        ImageIcon winImage = new ImageIcon("src/resources/images/character2win.png");
        JLabel gameOverImageLabel = new JLabel(winImage);

        // 팁 표시 라벨
        JLabel tipLabel = new JLabel(getRandomTip());
        tipLabel.setHorizontalAlignment(JLabel.CENTER);
        tipLabel.setFont(new Font("NanumGothic", Font.BOLD, 25));
        tipLabel.setForeground(Color.WHITE); // 글자색을 흰색으로 설정

        // 팁을 담을 패널
        JPanel tipPanel = new JPanel();
        tipPanel.setBackground(Color.BLACK); // 패널 배경색을 검은색으로 설정
        tipPanel.add(tipLabel);

        // 게임 다시 시작 버튼
        JButton restartButton = new JButton("  재시작   ");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 게임 다시 시작 코드 추가 (ChooseCharacterFrame 생성)
                new TitlePanel();
                dispose();
            }
        });
        // 버튼 크기 설정
        restartButton.setPreferredSize(new Dimension(200, 100));
        // 버튼 배경색 및 글자색 설정
        restartButton.setBackground(Color.CYAN);
        restartButton.setForeground(Color.BLACK);

        // 게임 종료 버튼
        JButton gameExitButton = new JButton("게임 종료");
        gameExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        // 버튼 크기 설정
        gameExitButton.setPreferredSize(new Dimension(200, 100));
        // 버튼 배경색 및 글자색 설정
        gameExitButton.setBackground(Color.CYAN);
        gameExitButton.setForeground(Color.BLACK);

        // 버튼을 담을 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(false);  // 배경을 투명하게 설정
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(restartButton);
        buttonPanel.add(Box.createHorizontalStrut(100)); // 버튼 간에 일정한 간격을 주기 위해 수평 간격 추가
        buttonPanel.add(gameExitButton);
        buttonPanel.add(Box.createHorizontalGlue());

        mainPanel.add(gameOverImageLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(tipPanel, BorderLayout.NORTH);  // 팁 패널을 상단에 추가

        // 프레임 설정
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
                new Character2EndingPanel();
            }
        });
    }
}
