package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class FightStatusPanel extends JPanel {
    JLabel attackLabel;
    JLabel defenseLabel;

    FightStatusPanel() {
        setLayout(new GridLayout(2, 1));
        Font f = new Font("함초롱바탕", Font.BOLD, 30);
        String attackStatus = "150";
        attackLabel = new JLabel("공격력 : " + attackStatus);
        attackLabel.setFont(f);
        attackLabel.setForeground(CommonPanelFunction.hexToRgb("A89157"));
        add(attackLabel);

        String defenseStatus = "090";
        defenseLabel = new JLabel("방어력 : " + defenseStatus);
        defenseLabel.setFont(f);
        defenseLabel.setForeground(CommonPanelFunction.hexToRgb("A89157"));
        add(defenseLabel);
    }
} // 공격력, 방어력 스테이터스를 보여주는 패널