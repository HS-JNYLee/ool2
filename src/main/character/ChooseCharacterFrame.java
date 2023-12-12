package src.main.character;

import src.main.gui.Panels.SettingPanel.SettingPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import static src.main.gui.Panels.SettingPanel.SettingPanel.*;

public class ChooseCharacterFrame extends JFrame {
    private AtomicInteger availablePoints = new AtomicInteger(20); //왼쪽 캐릭터에게 부여할 수 있는 능력치 포인트 20
    private AtomicInteger availablePoints2 = new AtomicInteger(20);//오른쪽 캐릭터에게 부여할 수 있는 능력치 포인트 20

    private JLabel availablePointsLabel;  // 클래스 필드로 선언
    private JLabel availablePointsLabel2;  // 클래스 필드로 선언

    // private int availablePoints = 20; // 최대로 사용 가능한 포인트
    private Character character1;
    private Character character2;
    private JProgressBar ch1Bar1;
    private JProgressBar ch1Bar2;
    private JProgressBar ch1Bar3;
    private JProgressBar ch1Bar4;
    private JProgressBar ch1Bar5;

    private JProgressBar ch2Bar1;
    private JProgressBar ch2Bar2;
    private JProgressBar ch2Bar3;
    private JProgressBar ch2Bar4;
    private JProgressBar ch2Bar5;

    private Clip clip;
    SettingPanel SettingPanel = new SettingPanel(null); // null 대신 실제 Clip 인스턴스를 전달해야 합니다.

    public ChooseCharacterFrame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        character1 = new Character();
        character2 = new Character();
        Ch1setvalue(character1); //초기값
        Ch2setvalue(character2);
        // 배경화면을 검은색으로 설정

        // 다른 클래스에서 updateVolume 메서드 호출
        SettingPanel.updateVolume();
        int volume = SettingPanel.getVolume();
        setVolume();
        getContentPane().setBackground(Color.BLACK);
        JLabel label = new JLabel("");
        label.setBounds(100, 100, 100, 30);
        label.setForeground(Color.WHITE);  // 글씨 색 변경
        add(label);
        try {
            File bgmFile = new File("src/resources/sounds/in_day.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bgmFile);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // 무한 반복하도록 설정합니다.
            clip.stop();
            // 클립을 처음으로 되감습니다.
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // 배경음악을 재생합니다.
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JButton settingButton = new JButton("설정");
        settingButton.addActionListener(new ActionListener() {  //음량 조절
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingPanel settingPanel = new SettingPanel(clip);  //음악 재생 clip
                JOptionPane.showMessageDialog(ChooseCharacterFrame.this, settingPanel, "설정", JOptionPane.PLAIN_MESSAGE);
            }
        });
        settingButton.setBounds(1, 1, 60, 30);
        add(settingButton, BorderLayout.WEST);
        settingButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        settingButton.setForeground(Color.BLACK);  // 글씨 색 변경
        add(settingButton);


        // 캐릭터 1의 막대 그래프
        ch1Bar1 = new JProgressBar();
        ch1Bar1.setBounds(150, 370, 200, 20);
        ch1Bar1.setStringPainted(true);
        ch1Bar1.setForeground(Color.RED);  // HP 바의 색상
        add(ch1Bar1);
        ch1Bar2 = new JProgressBar();
        ch1Bar2.setBounds(150, 390, 200, 20);
        ch1Bar2.setStringPainted(true);
        ch1Bar2.setForeground(Color.MAGENTA);  // ATK 바의 색상
        add(ch1Bar2);
        ch1Bar3 = new JProgressBar();
        ch1Bar3.setBounds(150, 410, 200, 20);
        ch1Bar3.setStringPainted(true);
        ch1Bar3.setForeground(Color.DARK_GRAY);  // 방어력 바의 색상
        add(ch1Bar3);
        ch1Bar4 = new JProgressBar();
        ch1Bar4.setBounds(150, 430, 200, 20);
        ch1Bar4.setStringPainted(true);
        ch1Bar4.setForeground(Color.GREEN);  // 포만감 바의 색상
        add(ch1Bar4);
        ch1Bar5 = new JProgressBar();
        ch1Bar5.setBounds(150, 450, 200, 20);
        ch1Bar5.setStringPainted(true);
        ch1Bar5.setForeground(Color.CYAN);  // 수분 바의 색상
        add(ch1Bar5);
        JLabel ch1Label1 = new JLabel("HP");
        ch1Label1.setBounds(90, 370, 100, 20);
        ch1Label1.setForeground(Color.WHITE);
        add(ch1Label1);
        JLabel ch1Label2 = new JLabel("ATK");
        ch1Label2.setBounds(90, 390, 100, 20);
        ch1Label2.setForeground(Color.WHITE);
        add(ch1Label2);
        JLabel ch1Label3 = new JLabel("DEFENSE");
        ch1Label3.setBounds(90, 410, 100, 20);
        ch1Label3.setForeground(Color.WHITE);
        add(ch1Label3);
        JLabel ch1Label4 = new JLabel("FULLness");
        ch1Label4.setBounds(90, 430, 100, 20);
        ch1Label4.setForeground(Color.WHITE);
        add(ch1Label4);
        JLabel ch1Label5 = new JLabel("WATER");
        ch1Label5.setBounds(90, 450, 100, 20);
        ch1Label5.setForeground(Color.WHITE);
        add(ch1Label5);


        // 캐릭터 2의 막대 그래프
        ch2Bar1 = new JProgressBar();
        ch2Bar1.setBounds(550, 370, 200, 20);
        ch2Bar1.setStringPainted(true);
        ch2Bar1.setForeground(Color.RED);  // HP 바의 색상
        add(ch2Bar1);
        ch2Bar2 = new JProgressBar();
        ch2Bar2.setBounds(550, 390, 200, 20);
        ch2Bar2.setStringPainted(true);
        ch2Bar2.setForeground(Color.MAGENTA);  // 공격력 바의 색상
        add(ch2Bar2);
        ch2Bar3 = new JProgressBar();
        ch2Bar3.setBounds(550, 410, 200, 20);
        ch2Bar3.setStringPainted(true);
        ch2Bar3.setForeground(Color.DARK_GRAY);  // 방어력 바의 색상
        add(ch2Bar3);
        ch2Bar4 = new JProgressBar();
        ch2Bar4.setBounds(550, 430, 200, 20);
        ch2Bar4.setStringPainted(true);
        ch2Bar4.setForeground(Color.GREEN);  // 포만감 바의 색상
        add(ch2Bar4);
        ch2Bar5 = new JProgressBar();
        ch2Bar5.setBounds(550, 450, 200, 20);
        ch2Bar5.setStringPainted(true);
        ch2Bar5.setForeground(Color.CYAN);  // 수분 바의 색상
        add(ch2Bar5);
        JLabel ch2Label1 = new JLabel("HP");
        ch2Label1.setBounds(490, 370, 100, 20);
        ch2Label1.setForeground(Color.WHITE);
        add(ch2Label1);
        JLabel ch2Label2 = new JLabel("ATK");
        ch2Label2.setBounds(490, 390, 100, 20);
        ch2Label2.setForeground(Color.WHITE);
        add(ch2Label2);
        JLabel ch2Label3 = new JLabel("DEFENSE");
        ch2Label3.setBounds(490, 410, 100, 20);
        ch2Label3.setForeground(Color.WHITE);
        add(ch2Label3);
        JLabel ch2Label4 = new JLabel("FULLness");
        ch2Label4.setBounds(490, 430, 100, 20);
        ch2Label4.setForeground(Color.WHITE);
        add(ch2Label4);
        JLabel ch2Label5 = new JLabel("WATER");
        ch2Label5.setBounds(490, 450, 100, 20);
        ch2Label5.setForeground(Color.WHITE);
        add(ch2Label5);

        //최초 그래프 설정
        updateProgressBar(ch1Bar1,80); //체력
        updateProgressBar(ch1Bar2, 20); //공격력
        updateProgressBar(ch1Bar3, 60); //방어력
        updateProgressBar(ch1Bar4, 40); //포만감
        updateProgressBar(ch1Bar5, 70); //수분

        updateProgressBar(ch2Bar1, 70);  //체력
        updateProgressBar(ch2Bar2, 60);  //공격력
        updateProgressBar(ch2Bar3, 30);  //방어력
        updateProgressBar(ch2Bar4, 70);  //포만감
        updateProgressBar(ch2Bar5, 50);  //수분

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 40, 900, 420);
        layeredPane.setBackground(Color.BLACK);  // 배경색 변경
        add(layeredPane);

        ImageIcon icon1 = new ImageIcon("src/resources/images/character1.png");
        JButton character1Button = new JButton(icon1);
        character1Button.setBackground(Color.BLACK);  // 버튼 배경색 변경
        character1Button.setForeground(Color.BLACK);  // 글씨 색 변경


        character1Button.setBounds(150, 30, icon1.getIconWidth(), icon1.getIconHeight());
        character1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        layeredPane.add(character1Button, Integer.valueOf(2));

        ImageIcon icon2 = new ImageIcon("src/resources/images/character2.png");
        JButton character2Button = new JButton(icon2);
        character2Button.setBounds(550, 30, icon2.getIconWidth(), icon2.getIconHeight());
        character2Button.setBackground(Color.BLACK);  // 버튼 배경색 변경
        character2Button.setForeground(Color.WHITE);  // 글씨 색 변경

        character2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        layeredPane.add(character2Button, Integer.valueOf(1));
        layeredPane.setLayer(layeredPane, 0);
        //능력치 그래프 옆에 있는 버튼들
        JButton ch1HpButton = createIncreaseButton1(ch1Bar1, character1, "+", availablePoints, availablePointsLabel);
        ch1HpButton.setBounds(360, 370, 40, 20);
        ch1HpButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch1HpButton);

        // "ATK +1" 버튼
        JButton ch1AtkButton = createIncreaseButton1(ch1Bar2, character1, "+", availablePoints, availablePointsLabel);
        ch1AtkButton.setBounds(360, 390, 40, 20);
        ch1AtkButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch1AtkButton);
        JButton ch1DefenseButton = createIncreaseButton1(ch1Bar3, character1, "+", availablePoints, availablePointsLabel);
        ch1DefenseButton.setBounds(360, 410, 40, 20);
        ch1DefenseButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch1DefenseButton);
        // "FULLness +1" 버튼
        JButton ch1FullnessButton = createIncreaseButton1(ch1Bar4, character1, "+", availablePoints, availablePointsLabel);
        ch1FullnessButton.setBounds(360, 430, 40, 20);
        ch1FullnessButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch1FullnessButton);

        // "WATER +1" 버튼
        JButton ch1WaterButton = createIncreaseButton1(ch1Bar5, character1, "+", availablePoints, availablePointsLabel);
        ch1WaterButton.setBounds(360, 450, 40, 20);
        ch1WaterButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch1WaterButton);

        // 오른쪽 캐릭터에 대한 버튼 생성
        JButton ch2HpButton = createIncreaseButton2(ch2Bar1, character2, "+", availablePoints2, availablePointsLabel2);
        ch2HpButton.setBounds(760, 370, 40, 20);
        ch2HpButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch2HpButton);

        JButton ch2AtkButton = createIncreaseButton2(ch2Bar2, character2, "+", availablePoints2, availablePointsLabel2);
        ch2AtkButton.setBounds(760, 390, 40, 20);
        ch2AtkButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch2AtkButton);
        JButton ch2DefenseButton = createIncreaseButton2(ch2Bar3, character2, "+", availablePoints2, availablePointsLabel2);
        ch2DefenseButton.setBounds(760, 410, 40, 20);
        ch2DefenseButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch2DefenseButton);
        JButton ch2FullnessButton = createIncreaseButton2(ch2Bar4, character2, "+", availablePoints2, availablePointsLabel2);
        ch2FullnessButton.setBounds(760, 430, 40, 20);
        ch2FullnessButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch2FullnessButton);
        JButton ch2WaterButton = createIncreaseButton2(ch2Bar5, character2, "+", availablePoints2, availablePointsLabel2);
        ch2WaterButton.setBounds(760, 450, 40, 20);
        ch2WaterButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        add(ch2WaterButton);

        // 하단에 남은 포인트 표시
        availablePointsLabel = new JLabel("남은 포인트: " + availablePoints.get());
        availablePointsLabel.setBounds(200, 480, 150, 20);
        availablePointsLabel.setForeground(Color.WHITE);
        add(availablePointsLabel);

        // 오른쪽 캐릭터의 포인트 표시
        availablePointsLabel2 = new JLabel("남은 포인트: " + availablePoints2.get());
        availablePointsLabel2.setBounds(610, 480, 150, 20);
        availablePointsLabel2.setForeground(Color.WHITE);
        add(availablePointsLabel2);
        //그래프 옆 버튼 폰트 설정
        ch1HpButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch1AtkButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch1DefenseButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch1FullnessButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch1WaterButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch2HpButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch2AtkButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch2DefenseButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch2FullnessButton.setFont(new Font("Arial", Font.BOLD, 10));
        ch2WaterButton.setFont(new Font("Arial", Font.BOLD, 10));

        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void Ch1setvalue(Character character1) {  //캐릭터 1
        // 캐릭터 초기값 설정
        character1.setHp(80);
        character1.setAttack(20);
        character1.setDefense(60);
        character1.increaseFullness(40);
        character1.increaseWater(70);
    }

    private void Ch2setvalue(Character character2) {  //캐릭터 2
        // 캐릭터 초기값 설정
        character2.setHp(70);
        character2.setAttack(60);
        character2.setDefense(30);
        character2.increaseFullness(70);
        character2.setWater(50);
    }

    private void updateProgressBar(JProgressBar progressBar, int value) {
        progressBar.setValue(value);
        progressBar.setString(String.valueOf(value));
    }

    private JButton createIncreaseButton1(JProgressBar progressBar, Character character1, String property, AtomicInteger availablePoints, JLabel availablePointsLabel) {
        JButton button = new JButton(property);
        button.addActionListener(e -> {
            int currentPoints = this.availablePoints.get();
            if (currentPoints > 0) {
                int value = progressBar.getValue() + 1;
                progressBar.setValue(value);
                progressBar.setString(String.valueOf(value));

                switch (property) {
                    case "HP":
                        character1.increaseHp(1);
                        break;
                    case "ATK":
                        character1.increaseAttack(1);
                        break;
                    case "DEFENSE":
                        character1.increaseDefense(1);
                        break;
                    case "FULLness":
                        character1.increaseFullness(1);
                        break;
                    case "WATER":
                        character1.increaseWater(1);
                        break;
                }

                this.availablePoints.decrementAndGet();
                this.availablePointsLabel.setText("남은 포인트: " + this.availablePoints.get());
            }
        });
        return button;
    }

    private JButton createIncreaseButton2(JProgressBar progressBar, Character character2, String property, AtomicInteger availablePoints, JLabel availablePointsLabel) {
        JButton button = new JButton(property);
        button.addActionListener(e -> {
            int currentPoints2 = availablePoints2.get();
            if (currentPoints2 > 0) {
                int value = progressBar.getValue() + 1;
                progressBar.setValue(value);
                progressBar.setString(String.valueOf(value));

                switch (property) {
                    case "HP":
                        character2.increaseHp(1);
                        break;
                    case "ATK":
                        character2.increaseAttack(1);
                        break;
                    case "DEFENSE":
                        character2.increaseDefense(1);
                        break;
                    case "FULLness":
                        character2.increaseFullness(1);
                        break;
                    case "WATER":
                        character2.increaseWater(1);
                        break;
                }
                availablePoints2.decrementAndGet();
                availablePointsLabel2.setText("남은 포인트: " + availablePoints2.get());
            }
        });
        return button;
    }
    private void setVolume() {
        int volume = SettingPanel.getVolume();
        SettingPanel.updateVolume(); // 볼륨이 업데이트되었는지 확인
        // 다른 구성 요소에 볼륨을 설정, 예: 배경 음악
    }

    public static void main(String[] args) {
        new ChooseCharacterFrame();
    }
}
