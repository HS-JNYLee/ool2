package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class CharacterInfoPanel extends JPanel {
    StatusPanel status; // 캐릭터의 능력치를 확인하는 패널
    PlayerCharacterPanel playerCharacter; // 캐릭터의 위치

    EventLogPanel eventLog; // 이벤트 정보가 나오는 창

    public CharacterInfoPanel() {
        setLayout(new GridLayout(1, 3));
        status = new StatusPanel();
        status.setBackground(CommonPanelFunction.hexToRgb("303030"));

        playerCharacter = new PlayerCharacterPanel();
        playerCharacter.setBackground(CommonPanelFunction.hexToRgb("303030"));

        eventLog = new EventLogPanel();
        eventLog.setBackground(CommonPanelFunction.hexToRgb("303030"));

        add(status);
        add(playerCharacter);
        add(eventLog);
    }
} // 중앙 패널
