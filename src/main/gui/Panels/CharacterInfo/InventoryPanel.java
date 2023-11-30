package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    JPanel equipedWeaponPanel;
    JPanel ownedWeaponPanel;
    JPanel exitPanel;

    public InventoryPanel() {
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        setLayout(new GridLayout(1, 3, 5, 0));

        equipedWeaponPanel = new JPanel();
        equipedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));
        equipedWeaponPanel.setLayout(new BoxLayout(equipedWeaponPanel, BoxLayout.Y_AXIS));

        JLabel equipedWeapon = new JLabel("무기A");
        JLabel fightText = new JLabel("(싸운다)");

        equipedWeapon.setFont(f);
        equipedWeapon.setForeground(Color.WHITE);
        equipedWeapon.setAlignmentY(Component.CENTER_ALIGNMENT);
        equipedWeapon.setAlignmentX(Component.CENTER_ALIGNMENT);

        fightText.setFont(f);
        fightText.setForeground(Color.WHITE);
        fightText.setAlignmentY(Component.CENTER_ALIGNMENT);
        fightText.setAlignmentX(Component.CENTER_ALIGNMENT);

        equipedWeaponPanel.add(Box.createVerticalGlue());
        equipedWeaponPanel.add(equipedWeapon);
        equipedWeaponPanel.add(fightText);
        equipedWeaponPanel.add(Box.createVerticalGlue());

        add(equipedWeaponPanel);

        ownedWeaponPanel = new JPanel();
        ownedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));
        ownedWeaponPanel.setLayout(new BoxLayout(ownedWeaponPanel, BoxLayout.X_AXIS));

        JLabel A = new JLabel("무기A");
        A.setFont(f);
        A.setOpaque(true);
        A.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
        A.setForeground(Color.WHITE);
        A.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel B = new JLabel("무기B");
        B.setFont(f);
        B.setOpaque(true);
        B.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
        B.setForeground(Color.WHITE);
        B.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel C = new JLabel("무기C");
        C.setFont(f);
        C.setOpaque(true);
        C.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
        C.setForeground(Color.WHITE);
        C.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel D = new JLabel("무기D");
        D.setFont(f);
        D.setOpaque(true);
        D.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
        D.setForeground(Color.WHITE);
        D.setAlignmentX(Component.CENTER_ALIGNMENT);

        ownedWeaponPanel.add(A);
        ownedWeaponPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        ownedWeaponPanel.add(B);
        ownedWeaponPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        ownedWeaponPanel.add(C);
        ownedWeaponPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        ownedWeaponPanel.add(D);

        JPanel ownedWeaponPanelWrapper = new JPanel();
        ownedWeaponPanelWrapper.setLayout(new BoxLayout(ownedWeaponPanelWrapper, BoxLayout.Y_AXIS));
        // ownedWeaponPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ownedWeaponPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        ownedWeaponPanelWrapper.add(Box.createVerticalGlue());
        ownedWeaponPanelWrapper.add(ownedWeaponPanel);
        ownedWeaponPanelWrapper.add(Box.createVerticalGlue());

        add(ownedWeaponPanelWrapper);

        exitPanel = new JPanel();
        exitPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.Y_AXIS));

        JLabel exitLabel = new JLabel("도망친다");
        exitLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        exitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitLabel.setFont(f);
        exitLabel.setForeground(Color.WHITE);

        exitPanel.add(Box.createVerticalGlue());
        exitPanel.add(exitLabel);
        exitPanel.add(Box.createVerticalGlue());

        add(exitPanel);
    }
}
