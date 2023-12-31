package src.main.character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitlePanel extends JFrame {

    public TitlePanel() {
        super("게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


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
                //src.main.character.ChooseCharacterFrame 이동
                ChooseCharacterFrame chooseCharacterFrame = new ChooseCharacterFrame();
                chooseCharacterFrame.setVisible(true);
                TitlePanel.this.setVisible(false);
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
