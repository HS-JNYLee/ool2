package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;
import src.main.inventory.Inventory;
import src.main.inventory.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class InventoryPanel extends JPanel {
    JPanel equipedWeaponPanel;
    JPanel ownedWeaponPanel;
    JPanel exitPanel;

    public InventoryPanel(Inventory i) {

        Font f = new Font("NanumGothic", Font.BOLD, 20);
        setLayout(new GridLayout(1, 3, 5, 0));

        equipedWeaponPanel = new JPanel(); // 소지한 무기의 패널
        equipedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));
        equipedWeaponPanel.setLayout(new BoxLayout(equipedWeaponPanel, BoxLayout.Y_AXIS));

        JLabel equipedWeapon = new JLabel(i.getEquipedWeapon().getName());
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

        ownedWeaponPanel = new JPanel(); // 소지한 무기의 패널
        ownedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));
        ownedWeaponPanel.setLayout(new BoxLayout(ownedWeaponPanel, BoxLayout.X_AXIS));
        JLayeredPane layeredPane = new JLayeredPane();
        for (int idx = 0; idx < i.getWeapons().size(); idx++) {
            JLabel weaponLabel = new JLabel(i.getWeapons().get(idx).getName());
            JLabel hoverLabel = new JLabel();
            weaponLabel.setFont(f);
            weaponLabel.setOpaque(true);
            weaponLabel.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
            weaponLabel.setForeground(Color.WHITE);
            weaponLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            weaponLabel.addMouseListener(new MouseHoverListener(i.getWeapons().get(idx), hoverLabel, equipedWeapon));
            ownedWeaponPanel.add(weaponLabel);
            ownedWeaponPanel.add(hoverLabel);
            ownedWeaponPanel.add(Box.createRigidArea(new Dimension(5, 0)));
            int x = idx * 75 + 10; // x 좌표 설정
            int y = 0; // 높이에 따른 y 좌표 설정

            weaponLabel.setBounds(x, y, 70, 30);
            hoverLabel.setBounds(x, y, 70, 30);

            layeredPane.add(weaponLabel, idx);
            layeredPane.add(hoverLabel, idx);
        }

        JPanel ownedWeaponPanelWrapper = new JPanel();
        ownedWeaponPanelWrapper.setLayout(new BoxLayout(ownedWeaponPanelWrapper, BoxLayout.Y_AXIS));
        ownedWeaponPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        ownedWeaponPanelWrapper.add(Box.createVerticalGlue());
        ownedWeaponPanelWrapper.add(layeredPane);
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

    class MouseHoverListener extends MouseAdapter {
        Weapon weapon;
        JLabel hoverLabel;
        JLabel equipedLabel;

        public MouseHoverListener(Weapon weapon, JLabel hoverLabel, JLabel equipedLabel) {
            this.weapon = weapon;
            this.hoverLabel = hoverLabel;
            this.equipedLabel = equipedLabel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            hoverLabel.setBounds(e.getComponent().getX() + 20, e.getComponent().getY() + 20, 70, 40);
            hoverLabel.setText("<html>공격력: " + weapon.getAttackStatus() + " <br>" + weapon.getRemainNumber() + "회 남음</html>");
            hoverLabel.setOpaque(true);
            hoverLabel.setBackground(Color.WHITE);
            hoverLabel.setVisible(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            hoverLabel.setVisible(false);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            equipedLabel.setText(weapon.getName());
        }
    }
}
