package src.main.gui.Panels.EndingPanel;

import src.main.app.common.CommonPanelFunction;
import src.main.character.ChooseCharacterFrame;
import src.main.character.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameOverPanel extends JFrame {
    private static final String[] TIPS = {
            //게임에서 승리할 수 있는 조언들
            "Tip 1: 상상부기는 거북이 이므로 방어력이 높아요!",
            "Tip 2: 뭐 쓰지",
            "Tip 3: ??."

    };

    public GameOverPanel() {
        super("Game Over");
        ExecutorService executor = Executors.newFixedThreadPool(2); // 병렬 실행을 위한 스레드 풀 생성
        executor.execute(() -> {
            CommonPanelFunction.playClickSound("game_over.wav");
        });
        executor.execute(() -> {
        // 패널을 생성할 때 배경색을 검은색으로 설정
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);  // 전체 패널의 배경색을 검은색으로 변경
        add(mainPanel);

        // 게임 오버 이미지
        ImageIcon gameOverImage = new ImageIcon("src/resources/images/gameover2.png");
        JLabel gameOverImageLabel = new JLabel(gameOverImage);

        // 팁 표시 라벨
        JLabel tipLabel = new JLabel(getRandomTip());
        tipLabel.setHorizontalAlignment(JLabel.CENTER);
        tipLabel.setFont(new Font("NanumGothic", Font.TRUETYPE_FONT, 15));
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
        restartButton.setBackground(Color.RED);
        restartButton.setForeground(Color.WHITE);

        // 게임 종료 버튼
        JButton gameExitButton = new JButton("게임 종류");
        gameExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        // 버튼 크기 설정
        gameExitButton.setPreferredSize(new Dimension(200, 100));
        // 버튼 배경색 및 글자색 설정
        gameExitButton.setBackground(Color.RED);
        gameExitButton.setForeground(Color.WHITE);

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
        });
        executor.shutdown();
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
                new GameOverPanel();
            }
        });
    }
}
