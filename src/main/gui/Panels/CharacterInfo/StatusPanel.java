package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    BodyStatusPanel bodyStatus; // 캐릭터 몸상태를 알려주는 패널
    FightStatusPanel fightStatus; // 캐릭터의 전투 능력치를 알려주는 패널

    StatusPanel() {
        setLayout(new GridLayout(2, 1, 0, 5));

        bodyStatus = new BodyStatusPanel();
        bodyStatus.setBackground(CommonPanelFunction.hexToRgb("303030"));

        fightStatus = new FightStatusPanel();
        fightStatus.setBackground(CommonPanelFunction.hexToRgb("201A07"));

        add(bodyStatus);
        add(fightStatus);
    }
} // 캐릭터의 종합적인 수치를 보여주는 패널
