package src.main.gui.Panels.CharacterInfo;

import javax.swing.*;
import java.awt.*;

class EventLogPanel extends JPanel {
    JPanel monsterEventPanel;
    EventLogPanel() {
        setLayout(new BorderLayout());

        monsterEventPanel = new JPanel();
        monsterEventPanel.setLayout(new GridBagLayout());
        monsterEventPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        String monsterImageLink = "src/resources/seoulMonster.png";
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

        String mosterAttack = "100";
        JLabel monsterStatus = new JLabel("공격력 : " + mosterAttack);
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        monsterStatus.setFont(f);
        monsterStatus.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        monsterEventPanel.add(monsterStatus, gbc);

        add(monsterEventPanel, BorderLayout.CENTER);
    }
}
