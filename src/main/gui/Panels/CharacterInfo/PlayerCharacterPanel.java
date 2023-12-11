package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;

public class PlayerCharacterPanel extends JPanel { // 캐릭터를 보여주는 화면
    JLabel characterImageLabel;
    public PlayerCharacterPanel() {
        String characterImageLink = "src/resources/images/character1.png";
        ImageIcon characterImageIcon = new ImageIcon(characterImageLink);
        characterImageLabel = new JLabel(characterImageIcon);
        characterImageLabel.setBounds(150, 30, characterImageIcon.getIconWidth(), characterImageIcon.getIconHeight());
        characterImageLabel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(characterImageLabel);
    }
}
