package src.main.gui.Panels.TimeSettings;

import src.main.app.common.CommonPanelFunction;
import src.main.gui.Panels.SettingPanel.SettingPanel;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimeSettingsPanel extends JPanel {
    JButton setting; // 설정 버튼
    JButton pause; // 일시정지 버튼 (발표용)
    TimestampPanel timeStamp; // 시간 정보를 담은 패널
    public TimeSettingsPanel(int width, int height) {
        setLayout(new BorderLayout());
        setting = new JButton("설정");
        setting.setPreferredSize(new Dimension((int) (width * 0.1), (int) (height * 0.5)));
        add(setting, BorderLayout.WEST);

        pause = new JButton("발표용");
        pause.setPreferredSize(new Dimension((int) (width * 0.1), (int) (height * 0.5)));
        add(pause, BorderLayout.CENTER);


        timeStamp = new TimestampPanel((int) (width * 0.7), height);
        timeStamp.setBackground(CommonPanelFunction.hexToRgb("303030"));
        timeStamp.setPreferredSize(new Dimension ((int) (width * 0.7), height));
        add(timeStamp, BorderLayout.EAST);

        pause.addMouseListener(new MouseAdapter() {
            Boolean isPause = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!isPause) {
                    getTimeStamp().getTt().stopThread();
                    isPause = true;
                }else {
                    getTimeStamp().getTt().startThread();
                    isPause =false;
                }
            }
        });
    }

    public TimestampPanel getTimeStamp() {
        return timeStamp;
    }

    public void setSettingEventListener(Clip clip) {
        ActionListener[] listeners = setting.getActionListeners();

        for (ActionListener listener : listeners) {
            setting.removeActionListener(listener);
        }
        setting.addActionListener(new ActionListener() {  //음량 조절
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingPanel settingPanel = new SettingPanel(clip);  //음악 재생 clip
                JOptionPane.showMessageDialog(TimeSettingsPanel.this, settingPanel, "설정", JOptionPane.PLAIN_MESSAGE);
            }
        });
        setting.revalidate();
    }
}

