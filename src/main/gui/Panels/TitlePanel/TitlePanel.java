package src.main.gui.Panels.TitlePanel;

import src.main.gui.Panels.ExplainPanel.ExplainPanel;
import src.main.gui.Panels.SettingPanel.SettingPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import src.main.character.ChooseCharacterFrame;

public class TitlePanel extends JFrame {
    private Clip clip;

    public TitlePanel() {
        super("게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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
                JOptionPane.showMessageDialog(TitlePanel.this, settingPanel, "설정", JOptionPane.PLAIN_MESSAGE);
            }
        });
        settingButton.setBounds(1, 1, 60, 30);
        add(settingButton, BorderLayout.WEST);
        settingButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        settingButton.setForeground(Color.BLACK);  // 글씨 색 변경
        add(settingButton);
        // 전체 패널
        // 전체 패널
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);  // 전체 패널의 배경색을 검은색으로 변경
        add(mainPanel);
// 중앙 이미지
        ImageIcon titleImageIcon = new ImageIcon("src/resources/images/title.png");
        JLabel titleImageLabel = new JLabel(titleImageIcon);
        mainPanel.add(titleImageLabel, BorderLayout.CENTER);
        titleImageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);  //


        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout( 5, 1, 1, 1));
        buttonPanel.setBackground(Color.BLACK);  // 버튼 패널의 배경색을 검은색으로 변경

        // 버튼 가로 길이 조절
        int buttonWidth = 250;  // 버튼 가로 길이를 150으로 설정
        int buttonHeight = 40;  // 버튼 세로 길이를 40으로 설정
        // 게임 시작 버튼
        JPanel startButtonPanel = new JPanel();  // JPanel 객체를 생성
        startButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // 레이아웃을 FlowLayout으로 설정
        startButtonPanel.setBackground(Color.BLACK);  // 패널의 배경색을 검은색으로 설정
        JButton startButton = new JButton("게임 시작");  // JButton 객체를 생성
        startButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        startButton.setBackground(Color.WHITE);  // 버튼 배경색을 하얀색으로 변경

        startButton.setForeground(Color.BLACK);  // 글씨 색을 검은색으로 변경
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //ChooseCharacterFrame 이동
                new ChooseCharacterFrame();
                dispose();

            }
        });
        startButtonPanel.add(startButton);  // 버튼을 패널에 추가
        buttonPanel.add(startButtonPanel);  // 패널을 버튼 패널에 추가
        // 게임 설명 버튼
        JPanel infoButtonPanel = new JPanel();  // JPanel 객체를 생성
        infoButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // 레이아웃을 FlowLayout으로 설정
        infoButtonPanel.setBackground(Color.BLACK);  // 패널의 배경색을 검은색으로 설정
        JButton  infoButton = new JButton("설명서");  // JButton 객체를 생성
        infoButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        infoButton.setBackground(Color.WHITE);  // 버튼 배경색을 하얀색으로 변경
        infoButton.setForeground(Color.BLACK);  // 글씨 색을 검은색으로 변경
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame explainFrame = new JFrame("게임 설명서");
                explainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                explainFrame.setSize(900, 600);
                explainFrame.setLocationRelativeTo(null);

                ExplainPanel explainPanel = new ExplainPanel();
                explainFrame.add(explainPanel);

                // 게임 설명서를 표시하고 현재 프레임의 배경음악을 정지
                explainFrame.setVisible(true);
                clip.stop();
                //  JOptionPane.showMessageDialog(ChooseCharacterFrame.this, settingPanel, "설정", JOptionPane.PLAIN_MESSAGE);
            }
        });
        infoButtonPanel.add(infoButton);  // 버튼을 패널에 추가
        buttonPanel.add(infoButtonPanel);  // 패널을 버튼 패널에 추가
        // 게임 종료 버튼
        JPanel exitButtonPanel = new JPanel();  // JPanel 객체를 생성
        exitButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // 레이아웃을 FlowLayout으로 설정
        exitButtonPanel.setBackground(Color.BLACK);  // 패널의 배경색을 검은색으로 설정
        JButton  exitButton = new JButton("게임 종료");  // JButton 객체를 생성
        exitButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        exitButton.setBackground(Color.WHITE);  // 버튼 배경색을 하얀색으로 변경
        exitButton.setForeground(Color.BLACK);  // 글씨 색을 검은색으로 변경

        infoButtonPanel.add(infoButton);  // 버튼을 패널에 추가
        buttonPanel.add(infoButtonPanel);  // 패널을 버튼 패널에 추가
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitButtonPanel.add(exitButton);  // 버튼을 패널에 추가
        buttonPanel.add(exitButtonPanel);  // 패널을 버튼 패널에 추가

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        // 창 크기 설정
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TitlePanel();
            }
        });
    }
}
