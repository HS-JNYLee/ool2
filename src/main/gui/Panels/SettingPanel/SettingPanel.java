package src.main.gui.Panels.SettingPanel;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

public class SettingPanel extends JPanel {
    private Clip clip;
    private JSlider volumeSlider;

    public SettingPanel(Clip clip) {
        this.clip = clip;
        setBorder(new EmptyBorder(100, 100, 100, 100));  // 여백을 크게 설정
        setBackground(Color.BLACK);  // 배경색을 검은색으로 변경
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // 세로로 정렬된 레이아웃으로 변경

        JLabel label = new JLabel("배경 음악");
        label.setForeground(Color.WHITE);  // 글자색을 흰색으로 변경
        add(label);

        // 슬라이더 생성
        volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setPreferredSize(new Dimension(300, 50));  // 슬라이더 크기를 조절
        volumeSlider.setBackground(Color.BLACK);  // 배경색을 검은색으로 변경
        volumeSlider.setForeground(Color.WHITE);  // 슬라이더 글자색을 흰색으로 변경
        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float range = gainControl.getMaximum() - gainControl.getMinimum();
                    float gain = (range * volumeSlider.getValue() / 100) + gainControl.getMinimum();
                    gain = Math.max(gain, gainControl.getMinimum());
                    gain = Math.min(gain, gainControl.getMaximum());
                    gainControl.setValue(gain);
                }
            }
        });
        add(volumeSlider);

    }
}
