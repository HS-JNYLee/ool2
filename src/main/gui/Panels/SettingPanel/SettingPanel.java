package src.main.gui.Panels.SettingPanel;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;

public class SettingPanel extends JPanel {
    private Clip clip;
    private JSlider volumeSlider;
    private int volume; // 볼륨 설정을 저장하기 위해 추가

    public SettingPanel(Clip clip) {
        this.clip = clip;
        setBorder(new EmptyBorder(100, 100, 100, 100));  // 여백을 크게 설정
        setBackground(Color.BLACK);  // 배경색을 검은색으로 변경
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // 세로로 정렬된 레이아웃으로 변경

        JLabel label = new JLabel("소리 설정");
        label.setForeground(Color.WHITE);  // 글자색을 흰색으로 변경
        label.setFont(new Font("NanumGothic", Font.TRUETYPE_FONT, 20));  // 글자 크기 및 스타일 조절
        add(label);

        // 슬라이더 생성
        volumeSlider = new JSlider(0, 100, loadVolume());
        volumeSlider.setPreferredSize(new Dimension(300, 50));  // 슬라이더 크기를 조절
        volumeSlider.setBackground(Color.BLACK);  // 배경색을 검은색으로 변경
        volumeSlider.setForeground(Color.WHITE);  // 슬라이더 글자색을 흰색으로 변경
        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateVolume();
            }
        });
        add(volumeSlider);

        JButton applyButton = new JButton("적용");
        applyButton.addActionListener(e -> saveVolume(volumeSlider.getValue()));
        applyButton.setForeground(Color.WHITE); // 글자색을 흰색으로 설정
        applyButton.setBackground(Color.BLACK); // 글자색을 흰색으로 설정

        add(applyButton);
    }



    private int loadVolume() {
        try (BufferedReader reader = new BufferedReader(new FileReader("volume.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 50; // 기본 값
    }
    public int getVolume() {
        return volumeSlider.getValue();
    }
    public void updateVolume() {
        if (clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range * volumeSlider.getValue() / 100) + gainControl.getMinimum();
            gain = Math.max(gain, gainControl.getMinimum());
            gain = Math.min(gain, gainControl.getMaximum());
            gainControl.setValue(gain);
        }
    }
    public void saveVolume(int volume) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("volume.txt"))) {
            writer.write(Integer.toString(volume));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
