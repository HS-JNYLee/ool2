import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    private Character character;

    public Frame() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("");
        label.setBounds(100, 100, 100, 30);
        add(label);

        JButton settingButton = new JButton("설정");
        settingButton.setBounds(1, 1, 60, 30);
        add(settingButton);

        JButton button1 = new JButton("식량");
        button1.setBounds(10, 470, 200, 70);
        add(button1);

        JButton button2 = new JButton("물");
        button2.setBounds(350, 470, 200, 70);
        add(button2);

        JButton button3 = new JButton("무기");
        button3.setBounds(680, 470, 200, 70);
        add(button3);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 40, 900, 420);
        layeredPane.setBackground(Color.GRAY);
        add(layeredPane);

        ImageIcon icon1 = new ImageIcon("character1.png");
        JButton character1Button = new JButton(icon1);
        character1Button.setBounds(150, 30, icon1.getIconWidth(), icon1.getIconHeight());
        character1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character = new Character();
                Ch1setvalue(character);
            }
        });
        layeredPane.add(character1Button, Integer.valueOf(2));

        ImageIcon icon2 = new ImageIcon("character2.png");
        JButton character2Button = new JButton(icon2);
        character2Button.setBounds(550, 30, icon2.getIconWidth(), icon2.getIconHeight());
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
    }
    public static void main(String[] args) {
        new Frame();
    }
}
