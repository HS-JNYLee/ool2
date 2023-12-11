package src.main.gui.Panels.TimeSettings;

import src.main.app.common.CommonPanelFunction;
import src.main.environment.TimestampThread;

import javax.swing.*;
import java.awt.*;

public class TimestampPanel extends JPanel {
    TimestampLabel region;
    TimestampLabel day;
    TimestampLabel realtime;
    int width;
    int height;
    TimestampPanel(int width, int height) {
        this.width = width;
        this.height = height;

        region = new TimestampLabel("서울"); // 시작 지역
        region.setForeground(CommonPanelFunction.hexToRgb("856b54"));
        day = new TimestampLabel("Day 01"); // 시작 날짜
        realtime = new TimestampLabel("");
        realtime.setForeground(CommonPanelFunction.hexToRgb("D0D0D0"));
        TimestampThread tt = new TimestampThread(realtime, day); // 날짜, 시간 갱신
        tt.start(); // 시간 스레드 시작

        add(region);
        add(day);
        add(realtime);
    }

    public class TimestampLabel extends JLabel {
        TimestampLabel(String name) {
            Font f = new Font("NanumGothic", Font.ITALIC, (int) (height * 0.5));

            setFont(f);
            setText(name);
            setPreferredSize(new Dimension((int) (width * 0.3), height));
            setOpaque(true);
            setForeground(CommonPanelFunction.hexToRgb("bbb7b3"));
            setBackground(CommonPanelFunction.hexToRgb("252525"));
            setHorizontalAlignment(JLabel.CENTER);
        }
    }
}
