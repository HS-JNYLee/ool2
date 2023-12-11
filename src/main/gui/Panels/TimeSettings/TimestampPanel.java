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
    TimestampThread tt;
    public TimestampPanel(int width, int height) {
        this.width = width;
        this.height = height;

        day = new TimestampLabel("Day 01"); // 시작 날짜
        realtime = new TimestampLabel("");
        realtime.setForeground(CommonPanelFunction.hexToRgb("D0D0D0"));
        tt = new TimestampThread(realtime, day); // 날짜, 시간 갱신
        region = new TimestampLabel(tt.getRegion()); // 시작 지역
        region.setForeground(CommonPanelFunction.hexToRgb("856b54"));
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

    public TimestampThread getTt() {
        return tt;
    }

    public void setTtRegion(String region) {
        tt.setRegion(region);
        this.region.setText(region);
        revalidate();
        repaint();
    }

    public void setRegion(TimestampLabel region) {
        this.region = region;
    }
}
