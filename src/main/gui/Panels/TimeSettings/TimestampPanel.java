package src.main.gui.Panels.TimeSettings;

import src.main.app.common.CommonPanelFunction;

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

        region = new TimestampLabel("서울");
        region.setForeground(CommonPanelFunction.hexToRgb("856b54"));
        day = new TimestampLabel("Day 02");
        realtime = new TimestampLabel("21:00");
        realtime.setForeground(CommonPanelFunction.hexToRgb("D0D0D0"));

        add(region);
        add(day);
        add(realtime);
    }

    class TimestampLabel extends JLabel {
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
