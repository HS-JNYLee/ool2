import src.main.gui.Panels.SettingPanel.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class ChooseCharacterFrame extends JFrame {
    private Character character;
    private JProgressBar ch1Bar1;
    private JProgressBar ch1Bar2;
    private JProgressBar ch1Bar3;
    private JProgressBar ch1Bar4;

    private JProgressBar ch2Bar1;
    private JProgressBar ch2Bar2;
    private JProgressBar ch2Bar3;
    private JProgressBar ch2Bar4;
    private Clip clip;
    public ChooseCharacterFrame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 배경화면을 검은색으로 설정
        getContentPane().setBackground(Color.BLACK);

        JLabel label = new JLabel("");
        label.setBounds(100, 100, 100, 30);
        label.setForeground(Color.WHITE);  // 글씨 색 변경
        add(label);

        try {
            File bgmFile = new File("src.sounds.soundsample.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bgmFile);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // 무한 반복하도록 설정합니다.
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
        settingButton.setBackground(Color.WHITE);  // 버튼 배경색 변경
        settingButton.setForeground(Color.BLACK);  // 글씨 색 변경
        add(settingButton);

        JButton button1 = new JButton("식량");
        button1.setBounds(10, 470, 200, 70);
        button1.setBackground(Color.WHITE);  // 버튼 배경색 변경
        button1.setForeground(Color.BLACK);  // 글씨 색 변경
        add(button1);

        JButton button2 = new JButton("물");
        button2.setBounds(350, 470, 200, 70);
        button2.setBackground(Color.WHITE);  // 버튼 배경색 변경
        button2.setForeground(Color.BLACK);  // 글씨 색 변경
        add(button2);

        // 캐릭터 1의 막대 그래프
        ch1Bar1 = new JProgressBar();
        ch1Bar1.setBounds(150, 370, 200, 20);
        ch1Bar1.setStringPainted(true);
        add(ch1Bar1);
        ch1Bar2 = new JProgressBar();
        ch1Bar2.setBounds(150, 390, 200, 20);
        ch1Bar2.setStringPainted(true);
        add(ch1Bar2);
        ch1Bar3 = new JProgressBar();
        ch1Bar3.setBounds(150, 410, 200, 20);
        ch1Bar3.setStringPainted(true);
        add(ch1Bar3);
        ch1Bar4 = new JProgressBar();
        ch1Bar4.setBounds(150, 430, 200, 20);
        ch1Bar4.setStringPainted(true);
        add(ch1Bar4);
        JLabel ch1Label1 = new JLabel("HP");
        ch1Label1.setBounds(90, 370, 100, 20);
        ch1Label1.setForeground(Color.WHITE);
        add(ch1Label1);
        JLabel ch1Label2 = new JLabel("ATK");
        ch1Label2.setBounds(90, 390, 100, 20);
        ch1Label2.setForeground(Color.WHITE);
        add(ch1Label2);
        JLabel ch1Label3 = new JLabel("FULLness");
        ch1Label3.setBounds(90, 410, 100, 20);
        ch1Label3.setForeground(Color.WHITE);
        add(ch1Label3);
        JLabel ch1Label4 = new JLabel("WATER");
        ch1Label4.setBounds(90, 430, 100, 20);
        ch1Label4.setForeground(Color.WHITE);
        add(ch1Label4);



        // 캐릭터 2의 막대 그래프
        ch2Bar1 = new JProgressBar();
        ch2Bar1.setBounds(550, 370, 200, 20);
        ch2Bar1.setStringPainted(true);
        add(ch2Bar1);
        ch2Bar2 = new JProgressBar();
        ch2Bar2.setBounds(550, 390, 200, 20);
        ch2Bar2.setStringPainted(true);
        add(ch2Bar2);
        ch2Bar3 = new JProgressBar();
        ch2Bar3.setBounds(550, 410, 200, 20);
        ch2Bar3.setStringPainted(true);
        add(ch2Bar3);
        ch2Bar4 = new JProgressBar();
        ch2Bar4.setBounds(550, 430, 200, 20);
        ch2Bar4.setStringPainted(true);
        add(ch2Bar4);
        JLabel ch2Label1 = new JLabel("HP");
        ch2Label1.setBounds(490, 370, 100, 20);
        ch2Label1.setForeground(Color.WHITE);
        add(ch2Label1);
        JLabel ch2Label2 = new JLabel("ATK");
        ch2Label2.setBounds(490, 390, 100, 20);
        ch2Label2.setForeground(Color.WHITE);
        add(ch2Label2);
        JLabel ch2Label3 = new JLabel("FULLness");
        ch2Label3.setBounds(490, 410, 100, 20);
        ch2Label3.setForeground(Color.WHITE);
        add(ch2Label3);
        JLabel ch2Label4 = new JLabel("WATER");
        ch2Label4.setBounds(490, 430, 100, 20);
        ch2Label4.setForeground(Color.WHITE);
        add(ch2Label4);





        updateProgressBar(ch1Bar1, 100);
        updateProgressBar(ch1Bar2, 10);
        updateProgressBar(ch1Bar3, 50);
        updateProgressBar(ch1Bar4, 50);

        updateProgressBar(ch2Bar1, 100);
        updateProgressBar(ch2Bar2, 10);
        updateProgressBar(ch2Bar3, 50);
        updateProgressBar(ch2Bar4, 60);



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
        character.setAtk(10);
        character.SetFullness(50);
        character.SetWater(50);
    }

    private void Ch2setvalue(Character character) {  //캐릭터 2
        // 캐릭터 초기값 설정
        character.setAtk(10);
        character.SetFullness(60);
        character.SetWater(50);
    }

    private void updateProgressBar(JProgressBar progressBar, int value) {
        progressBar.setValue(value);
        progressBar.setString(String.valueOf(value));
    }

    public static void main(String[] args) {
        new ChooseCharacterFrame();
    }
}
