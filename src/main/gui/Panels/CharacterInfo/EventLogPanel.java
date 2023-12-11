package src.main.gui.Panels.CharacterInfo;

import src.main.character.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventLogPanel extends JPanel {
    JPanel monsterEventPanel;
    public EventLogPanel(Monster m) {
        setLayout(new BorderLayout());

        monsterEventPanel = new JPanel();
        monsterEventPanel.setLayout(new GridBagLayout());
        monsterEventPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        String monsterImageLink = "src/resources/images/seoulMonster.png";
        ImageIcon monsterImageIcon = new ImageIcon(monsterImageLink);

        Image beforeImage = monsterImageIcon.getImage();
        Image resizeImage = beforeImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        monsterImageIcon = new ImageIcon(resizeImage);

        JLabel monsterImageLabel;
        monsterImageLabel = new JLabel(monsterImageIcon);
        monsterImageLabel.setBounds(150, 30, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.9;
        monsterEventPanel.add(monsterImageLabel, gbc);

        JLabel monsterStatus = new JLabel("["+m.getName()+"] "+"공격력 : " + m.getAttack());
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        monsterStatus.setFont(f);
        monsterStatus.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        monsterEventPanel.add(monsterStatus, gbc);

        add(monsterEventPanel, BorderLayout.CENTER);
    }

    public EventLogPanel(String event) {
        setLayout(new BorderLayout());

        monsterEventPanel = new JPanel();
        monsterEventPanel.setLayout(new GridBagLayout());
        monsterEventPanel.setBackground(Color.BLACK);

        JLabel monsterStatus = new JLabel(event);
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        monsterStatus.setFont(f);
        monsterStatus.setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        monsterStatus.setHorizontalAlignment(SwingConstants.CENTER);
        monsterEventPanel.add(monsterStatus);

        add(monsterEventPanel, BorderLayout.CENTER);
    }

    public void setMouseEvent() {
        monsterEventPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel monsterStatus = new JLabel("다음 지역으로 이동합니다.");
                Font f = new Font("NanumGothic", Font.BOLD, 20);
                monsterStatus.setFont(f);
                monsterStatus.setForeground(Color.WHITE);
                setBackground(Color.BLACK);
                monsterStatus.setHorizontalAlignment(SwingConstants.CENTER);
                monsterEventPanel = new JPanel();
                monsterEventPanel.setLayout(new GridBagLayout());
                monsterEventPanel.setBackground(Color.BLACK);
                monsterEventPanel.add(monsterStatus);
                removeAll();
                add(monsterEventPanel, BorderLayout.CENTER);
            }
        });
    }

}
