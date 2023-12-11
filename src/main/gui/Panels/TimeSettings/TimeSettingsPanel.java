package src.main.gui.Panels.TimeSettings;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class TimeSettingsPanel extends JPanel {
    JButton setting; // 설정 버튼
    TimestampPanel timeStamp; // 시간 정보를 담은 패널
    public TimeSettingsPanel(int width, int height) {
        setLayout(new BorderLayout());
        setting = new JButton("설정");
        setting.setPreferredSize(new Dimension((int) (width * 0.1), (int) (height * 0.5)));
        add(setting, BorderLayout.WEST);

        timeStamp = new TimestampPanel((int) (width * 0.7), height);
        timeStamp.setBackground(CommonPanelFunction.hexToRgb("303030"));
        timeStamp.setPreferredSize(new Dimension ((int) (width * 0.7), height));
        add(timeStamp, BorderLayout.EAST);
    }

    public TimestampPanel getTimeStamp() {
        return timeStamp;
    }
}

