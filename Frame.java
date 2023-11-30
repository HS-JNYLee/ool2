import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    private Character character;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;

    public Frame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 배경화면을 검은색으로 설정
        getContentPane().setBackground(Color.BLACK);

        JLabel label = new JLabel("");
        label.setBounds(100, 100, 100, 30);
        label.setForeground(Color.WHITE);  // 글씨 색 변경
        add(label);

        JButton settingButton = new JButton("설정");
        settingButton.setBounds(1, 1, 60, 30);
        settingButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        settingButton.setForeground(Color.BLACK);  // 글씨 색 변경
        add(settingButton);

        JButton button1 = new JButton("식량");
        button1.setBounds(10, 470, 200, 70);
        button1.setBackground(Color.WHITE);  // 버튼 배경색 변경
        button1.setForeground(Color.BLACK);  // 글씨 색 변경
        add(button1);

        // 캐릭터 1의 막대 그래프
        progressBar1 = new JProgressBar();
        progressBar1.setBounds(150, 410, 200, 20);
        progressBar1.setStringPainted(true);
        add(progressBar1);

        JButton button2 = new JButton("물");
        button2.setBounds(350, 470, 200, 70);
        button2.setBackground(Color.WHITE);  // 버튼 배경색 변경
        button2.setForeground(Color.BLACK);  // 글씨 색 변경
        add(button2);

        // 캐릭터 2의 막대 그래프
        progressBar2 = new JProgressBar();
        progressBar2.setBounds(550, 410, 200, 20);
        progressBar2.setStringPainted(true);
        add(progressBar2);

        JButton button3 = new JButton("무기");
        button3.setBounds(680, 470, 200, 70);
        button3.setBackground(Color.WHITE);  // 버튼 배경색 변경
        button3.setForeground(Color.BLACK);  // 글씨 색 변경
        add(button3);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 40, 900, 420);
        layeredPane.setBackground(Color.BLACK);  // 배경색 변경
        add(layeredPane);

        ImageIcon icon1 = new ImageIcon("src/resources/images/character1.png");
        JButton character1Button = new JButton(icon1);
        character1Button.setBackground(Color.BLACK);  // 버튼 배경색 변경
        character1Button.setForeground(Color.WHITE);  // 글씨 색 변경
        updateProgressBar(progressBar1, 40);
        updateProgressBar(progressBar2, 40);

        character1Button.setBounds(150, 30, icon1.getIconWidth(), icon1.getIconHeight());
        character1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character = new Character();
                Ch1setvalue(character);
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
                character = new Character();
                Ch2setvalue(character);

            }
        });
        layeredPane.add(character2Button, Integer.valueOf(1));

        layeredPane.setLayer(layeredPane, 0);

        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void Ch1setvalue(Character character) {  //캐릭터 1
        // 캐릭터 초기값 설정
        character.SetFullness(50);
        character.SetWater(50);
        character.setAtk(10);
    }

    private void Ch2setvalue(Character character) {  //캐릭터 2
        // 캐릭터 초기값 설정
        character.SetFullness(60);
        character.SetWater(50);
        character.setAtk(10);
        updateProgressBar(progressBar2, 60);
    }

    private void updateProgressBar(JProgressBar progressBar, int value) {
        progressBar.setValue(value);
        progressBar.setString(String.valueOf(value));
    }

    public static void main(String[] args) {
        new Frame();
    }
}
