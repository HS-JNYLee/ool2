package src.main.gui.Panels.SettingPanel;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EmptyBorder;

public class SettingPanel extends JPanel {
    private Clip clip;
    private JSlider volumeSlider;

    public SettingPanel(Clip clip) {
        this.clip = clip;
        setBorder(new EmptyBorder(50, 50, 50, 50));
        JLabel label = new JLabel("배경 음악");
        add(label);

        // 슬라이더 생성
        volumeSlider = new JSlider(0, 100, 50); // 초기 값 50
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
