package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

class BodyStatusPanel extends JPanel {
    JLabel healthText;
    JLabel fullnessText;
    JLabel waterText;

    JPanel healthPanel;
    JPanel fullnessPanel;
    JPanel waterPanel;

    BodyStatusPanel() {
        Font f = new Font("함초롱바탕", Font.BOLD, 20);
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
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
        healthPanel.add(new ProgressBar(20, CommonPanelFunction.hexToRgb("FF3535"), CommonPanelFunction.hexToRgb("FFB5B5")));
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
        fullnessPanel.add(new ProgressBar(40, CommonPanelFunction.hexToRgb("57FF72"), CommonPanelFunction.hexToRgb("DEFFCF")));
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
        waterPanel.add(new ProgressBar(60, CommonPanelFunction.hexToRgb("44BCFF"), CommonPanelFunction.hexToRgb("CFF6FF")));
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
} // 체력, 포만감, 수분을 보여주는 패널