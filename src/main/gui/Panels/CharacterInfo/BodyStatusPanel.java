package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class BodyStatusPanel extends JPanel {
    JLabel healthText;
    JLabel fullnessText;
    JLabel waterText;

    JPanel healthPanel;
    JPanel fullnessPanel;
    JPanel waterPanel;

    int healthPercentage =0;
    int fullnessPercentage = 0;
    int waterPercentage= 0;

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
    public BodyStatusPanel(int healthPercentage, int fullnessPercentage, int waterPercentage) {
        this.healthPercentage =healthPercentage;
        this.fullnessPercentage = fullnessPercentage;
        this.waterPercentage = waterPercentage;
        Font f = new Font("함초롱바탕", Font.BOLD, 20);
        setLayout(gbl);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 20; // 20%
        gbc.weighty = 50; // 50%
        healthText = new JLabel("체력");
        healthText.setBackground(CommonPanelFunction.hexToRgb("FF3535"));
        healthText.setOpaque(true);
        healthText.setForeground(CommonPanelFunction.hexToRgb("303030"));
        healthText.setFont(f);
        add(healthText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 80; // 80%
        healthPanel = new JPanel();
        healthPanel.setLayout(new BorderLayout());
        healthPanel.add(new ProgressBar(this.healthPercentage, CommonPanelFunction.hexToRgb("FF3535"), CommonPanelFunction.hexToRgb("FFB5B5")));
        add(healthPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 20; // 20%
        fullnessText = new JLabel("포만감");
        fullnessText.setBackground(CommonPanelFunction.hexToRgb("57FF72"));
        fullnessText.setOpaque(true);
        fullnessText.setForeground(CommonPanelFunction.hexToRgb("303030"));
        fullnessText.setFont(f);
        add(fullnessText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 80; // 80%
        fullnessPanel = new JPanel();
        fullnessPanel.setLayout(new BorderLayout());
        fullnessPanel.add(new ProgressBar(this.fullnessPercentage, CommonPanelFunction.hexToRgb("57FF72"), CommonPanelFunction.hexToRgb("DEFFCF")));
        add(fullnessPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 20; // 20%
        waterText = new JLabel("수분");
        waterText.setBackground(CommonPanelFunction.hexToRgb("44BCFF"));
        waterText.setOpaque(true);
        waterText.setForeground(CommonPanelFunction.hexToRgb("303030"));
        waterText.setFont(f);
        add(waterText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 80; // 80%
        waterPanel = new JPanel();
        waterPanel.setLayout(new BorderLayout());
        waterPanel.add(new ProgressBar(this.waterPercentage, CommonPanelFunction.hexToRgb("44BCFF"), CommonPanelFunction.hexToRgb("CFF6FF")));
        add(waterPanel, gbc);
    }
    class ProgressBar extends JPanel {
        JPanel completePanel;
        JPanel remainPanel;
        ProgressBar(int completePortion, Color completeColor, Color remainColor) {
            setLayout(new GridBagLayout());
            setBackground(CommonPanelFunction.hexToRgb("303030"));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;

            gbc.weightx = completePortion;
            completePanel = new JPanel();
            completePanel.setBackground(completeColor);
            add(completePanel, gbc);

            gbc.weightx = 100-completePortion;
            remainPanel = new JPanel();
            remainPanel.setBackground(remainColor);
            add(remainPanel, gbc);
        }
    }

    public void setFullnessPanel(int percentage) {
        fullnessPercentage += percentage;
        fullnessPanel.removeAll();
        fullnessPanel.add(new ProgressBar(fullnessPercentage, CommonPanelFunction.hexToRgb("57FF72"), CommonPanelFunction.hexToRgb("DEFFCF")));
    }

    public void setHealthPanel(int percentage) {
        healthPercentage = percentage;
        healthPanel.removeAll();
        healthPanel.add(new ProgressBar(healthPercentage, CommonPanelFunction.hexToRgb("FF3535"), CommonPanelFunction.hexToRgb("FFB5B5")));
    }

    public void setWaterPanel(int percentage) {
        waterPercentage += percentage;
        waterPanel.removeAll();
        waterPanel.add(new ProgressBar(waterPercentage, CommonPanelFunction.hexToRgb("44BCFF"), CommonPanelFunction.hexToRgb("CFF6FF")));
    }
} // 체력, 포만감, 수분을 보여주는 패널