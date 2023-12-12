package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class CharacterInfoPanel extends JPanel {
    StatusPanel status; // 캐릭터의 능력치를 확인하는 패널
    PlayerCharacterPanel playerCharacter; // 캐릭터의 위치

    EventLogPanel eventLog; // 이벤트 정보가 나오는 창

    public CharacterInfoPanel(StatusPanel status, PlayerCharacterPanel playerCharacter, EventLogPanel eventLog) {
        setLayout(new GridLayout(1, 3));
        this.status = status;
        this.playerCharacter = playerCharacter;
        this.eventLog = eventLog;

        add(this.status);
        add(this.playerCharacter);
        add(this.eventLog);
    }
    public CharacterInfoPanel(StatusPanel status, PlayerCharacterPanel playerCharacter) {
        setLayout(new GridLayout(1, 2));
        this.status = status;
        this.playerCharacter = playerCharacter;

        add(this.status);
        add(this.playerCharacter);
    }

    public void setEventLogPanelVisible(Boolean b) {
        SwingUtilities.invokeLater(() -> {
            eventLog.setVisible(b); // 이벤트 로그 패널의 가시성 설정
            revalidate(); // 레이아웃 재배치
            repaint(); // 다시 그리기
        });
    }
} // 중앙 패널
