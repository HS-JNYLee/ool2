package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;
import src.main.character.Character;
import src.main.inventory.Food;
import src.main.inventory.Inventory;
import src.main.inventory.Water;
import src.main.inventory.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InventoryPanel extends JPanel {
    JPanel equippedWeaponPanel;
    JLayeredPane ownedWeaponPanel;
    JLayeredPane foodPanel;
    JLayeredPane waterPanel;
    JPanel exitPanel;

    StatusPanel statusPanel;
    CharacterInfoPanel characterInfoPanel;
    JPanel waterPanelWrapper;
    JPanel foodPanelWrapper;
Character character;
    public InventoryPanel(Inventory i, JPanel equippedWeaponPanel, JLayeredPane ownedWeaponPanel, JPanel exitPanel, StatusPanel statusPanel, CharacterInfoPanel characterInfoPanel, Character character) {
        this.equippedWeaponPanel = equippedWeaponPanel;
        this.ownedWeaponPanel = ownedWeaponPanel;
        this.exitPanel = exitPanel;
        this.equippedWeaponPanel.removeAll();
        this.ownedWeaponPanel.removeAll();
        this.exitPanel.removeAll();
        this.statusPanel = statusPanel;
        this.characterInfoPanel = characterInfoPanel;
        this.character = character;
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        setLayout(new GridLayout(1, 3, 5, 0));

        this.equippedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));
        this.equippedWeaponPanel.setLayout(new BoxLayout(this.equippedWeaponPanel, BoxLayout.Y_AXIS));

        JLabel equippedWeapon = new JLabel(character.getEquippedWeapon().getName());
        JLabel fightText = new JLabel("(싸운다)");

        equippedWeapon.setFont(f);
        equippedWeapon.setForeground(Color.WHITE);
        equippedWeapon.setAlignmentY(Component.CENTER_ALIGNMENT);
        equippedWeapon.setAlignmentX(Component.CENTER_ALIGNMENT);

        fightText.setFont(f);
        fightText.setForeground(Color.WHITE);
        fightText.setAlignmentY(Component.CENTER_ALIGNMENT);
        fightText.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.equippedWeaponPanel.add(Box.createVerticalGlue());
        this.equippedWeaponPanel.add(equippedWeapon);
        this.equippedWeaponPanel.add(fightText);
        this.equippedWeaponPanel.add(Box.createVerticalGlue());

        add(this.equippedWeaponPanel);

        this.ownedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        for (int idx = 0; idx < i.getWeapons().size(); idx++) {
            JLabel weaponLabel = new JLabel(i.getWeapons().get(idx).getName());
            JLabel hoverLabel = new JLabel();
            weaponLabel.setFont(f);
            weaponLabel.setOpaque(true);
            weaponLabel.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
            weaponLabel.setForeground(Color.WHITE);
            weaponLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            weaponLabel.addMouseListener(new OwnedItemMouseListener(i.getWeapons().get(idx), hoverLabel, equippedWeapon));
            int x = idx % 3 * 85 + 20; // x 좌표 설정
            int y = idx / 3 * 40 + 60; // 높이에 따른 y 좌표 설정

            weaponLabel.setBounds(x, y, 70, 30);
            hoverLabel.setBounds(x, y, 70, 30);

            this.ownedWeaponPanel.add(weaponLabel, idx);
            this.ownedWeaponPanel.add(hoverLabel, idx);
        }

        JPanel ownedWeaponPanelWrapper = new JPanel();
        ownedWeaponPanelWrapper.setLayout(new BoxLayout(ownedWeaponPanelWrapper, BoxLayout.Y_AXIS));
        ownedWeaponPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        ownedWeaponPanelWrapper.add(this.ownedWeaponPanel);

        add(ownedWeaponPanelWrapper);

        this.exitPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        this.exitPanel.setLayout(new BoxLayout(this.exitPanel, BoxLayout.Y_AXIS));

        JLabel exitLabel = new JLabel("도망친다");
        exitLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        exitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitLabel.setFont(f);
        exitLabel.setForeground(Color.WHITE);

        this.exitPanel.add(Box.createVerticalGlue());
        this.exitPanel.add(exitLabel);
        this.exitPanel.add(Box.createVerticalGlue());

        add(this.exitPanel);
    }

    public InventoryPanel(Inventory i, JLayeredPane foodPanel, JLayeredPane waterPanel, JLayeredPane ownedWeaponPanel,StatusPanel statusPanel, CharacterInfoPanel characterInfoPanel, Character character) {
        this.foodPanel = foodPanel;
        this.waterPanel = waterPanel;
        this.ownedWeaponPanel = ownedWeaponPanel;
        this.statusPanel = statusPanel;
        this.characterInfoPanel = characterInfoPanel;
        this.character = character;
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        setLayout(new GridLayout(1, 3, 5, 0));
        //
        foodPanel.removeAll();
        foodPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        for (int idx = 0; idx < i.getFoods().size(); idx++) {
            JLabel foodLabel = new JLabel("음식"+ idx+1);
            JLabel hoverLabel = new JLabel();
            foodLabel.setFont(f);
            foodLabel.setOpaque(true);
            foodLabel.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
            foodLabel.setForeground(Color.WHITE);
            foodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            foodLabel.addMouseListener(new OwnedItemMouseListener(i, i.getFoods().get(idx), hoverLabel, new JLabel()));
            int x = idx % 3 * 85 + 20; // x 좌표 설정
            int y = idx / 3 * 40 + 60; // 높이에 따른 y 좌표 설정

            foodLabel.setBounds(x, y, 70, 30);
            hoverLabel.setBounds(x, y, 70, 30);

            foodPanel.add(foodLabel, idx);
            foodPanel.add(hoverLabel, idx);
        }

        foodPanelWrapper = new JPanel();
        foodPanelWrapper.setLayout(new BoxLayout(foodPanelWrapper, BoxLayout.Y_AXIS));
        foodPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        foodPanelWrapper.add(foodPanel);

        add(foodPanelWrapper);

        //

        waterPanel.removeAll();
        waterPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        for (int idx = 0; idx < i.getWaters().size(); idx++) {
            JLabel waterLabel = new JLabel("물"+idx+1);
            JLabel hoverLabel = new JLabel();
            waterLabel.setFont(f);
            waterLabel.setOpaque(true);
            waterLabel.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
            waterLabel.setForeground(Color.WHITE);
            waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            waterLabel.addMouseListener(new OwnedItemMouseListener(i, i.getWaters().get(idx), hoverLabel, new JLabel()));
            int x = idx % 3 * 85 + 20; // x 좌표 설정
            int y = idx / 3 * 40 + 60; // 높이에 따른 y 좌표 설정

            waterLabel.setBounds(x, y, 70, 30);
            hoverLabel.setBounds(x, y, 70, 30);

            waterPanel.add(waterLabel, idx);
            waterPanel.add(hoverLabel, idx);
        }

        waterPanelWrapper = new JPanel();
        waterPanelWrapper.setLayout(new BoxLayout(waterPanelWrapper, BoxLayout.Y_AXIS));
        waterPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        waterPanelWrapper.add(waterPanel);

        add(waterPanelWrapper);

        //
        ownedWeaponPanel.setBackground(CommonPanelFunction.hexToRgb("252525"));

        for (int idx = 0; idx < i.getWeapons().size(); idx++) {
            JLabel weaponLabel = new JLabel(i.getWeapons().get(idx).getName());
            JLabel hoverLabel = new JLabel();
            weaponLabel.setFont(f);
            weaponLabel.setOpaque(true);
            weaponLabel.setBackground(CommonPanelFunction.hexToRgb("D0D0D0"));
            weaponLabel.setForeground(Color.WHITE);
            weaponLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            weaponLabel.addMouseListener(new OwnedItemMouseListener(i.getWeapons().get(idx), hoverLabel, new JLabel()));
            int x = idx % 3 * 85 + 20; // x 좌표 설정
            int y = idx / 3 * 40 + 60; // 높이에 따른 y 좌표 설정

            weaponLabel.setBounds(x, y, 70, 30);
            hoverLabel.setBounds(x, y, 70, 30);

            ownedWeaponPanel.add(weaponLabel, idx);
            ownedWeaponPanel.add(hoverLabel, idx);
        }

        JPanel ownedWeaponPanelWrapper = new JPanel();
        ownedWeaponPanelWrapper.setLayout(new BoxLayout(ownedWeaponPanelWrapper, BoxLayout.Y_AXIS));
        ownedWeaponPanelWrapper.setBackground(CommonPanelFunction.hexToRgb("252525"));

        ownedWeaponPanelWrapper.add(ownedWeaponPanel);

        add(ownedWeaponPanelWrapper);
        //
    }

    class equippedItemMouseListener extends MouseAdapter {
        Weapon weapon;
        JLabel equippedLabel;

        public equippedItemMouseListener(Weapon weapon, JLabel equippedLabel) {
            this.weapon = weapon;
            this.equippedLabel = equippedLabel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            equippedLabel.setText(weapon.getName());
            weapon.subtractNumber(); // 1회 사용 횟수 차감

        }
    }

    public class OwnedItemMouseListener extends MouseAdapter {
        Weapon weapon;
        Water water;
        Food food;
        JLabel hoverLabel;
        JLabel activeLabel; // 상호작용이 나타날 라벨

        String itemRouter;
        Inventory inventory;

        public OwnedItemMouseListener(Weapon weapon, JLabel hoverLabel, JLabel equippedLabel) {
            this.weapon = weapon;
            this.hoverLabel = hoverLabel;
            this.activeLabel = equippedLabel;
            this.itemRouter = "weapon";
        }

        public OwnedItemMouseListener(Inventory i, Water water, JLabel hoverLabel, JLabel activeLabel) {
            this.water = water;
            this.hoverLabel = hoverLabel;
            this.activeLabel = activeLabel;
            this.itemRouter = "water";
            this.inventory = i;
        }

        public OwnedItemMouseListener(Inventory i, Food food, JLabel hoverLabel, JLabel activeLabel) {
            this.food = food;
            this.hoverLabel = hoverLabel;
            this.activeLabel = activeLabel;
            this.itemRouter = "food";
            this.inventory = i;
        }


        @Override
        public void mouseEntered(MouseEvent e) {
            if (itemRouter.equals("weapon")) {
                hoverLabel.setText("<html>공격력: " + weapon.getAttackStatus() + " <br>" + weapon.getRemainNumber() + "회 남음</html>");
            } else if (itemRouter.equals("water")) {
                hoverLabel.setText("<html>"+water.getRemainDays() + "일 남음</html>");
            }else if(itemRouter.equals("food")) {
                hoverLabel.setText("<html>"+food.getRemainDays() + "일 남음</html>");

            }
            hoverLabel.setBounds(e.getComponent().getX() + 20, e.getComponent().getY() + 20, 70, 40);
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
            if (itemRouter.equals("weapon")) {
                activeLabel.setText(weapon.getName());
                characterInfoPanel.remove(statusPanel);
                statusPanel.getFightStatus().setAttackLabel(weapon.getAttackStatus());
                characterInfoPanel.add(statusPanel, 0);
                characterInfoPanel.revalidate();
                characterInfoPanel.repaint();
                character.setAttack(weapon.getAttackStatus());
                character.setEquippedWeapon(weapon); // 작용 장비 교체
                hoverLabel.setVisible(false);
            } else if (itemRouter.equals("water")) { // 물을 먹었을 때
                // 인벤토리에서 해당 아이템 삭제
                inventory.deleteWater(water);

                characterInfoPanel.remove(statusPanel);
                statusPanel.getBodyStatus().setWaterPanel(water.getAddWater());
                characterInfoPanel.add(statusPanel, 0);
                waterPanel.remove((JLabel) e.getSource());
                characterInfoPanel.revalidate();
                characterInfoPanel.repaint();
                character.increaseWater(water.getAddWater());
                waterPanel.revalidate();
                waterPanel.repaint();
                hoverLabel.setVisible(false);
            } else if (itemRouter.equals("food")) { // 음식을 먹었을 떄
                // 인벤토리에서 해당 아이템 삭제
                inventory.deleteFood(food);

                characterInfoPanel.remove(statusPanel);
                statusPanel.getBodyStatus().setFullnessPanel(food.getAddSatiety());
                characterInfoPanel.add(statusPanel, 0);
                characterInfoPanel.revalidate();
                characterInfoPanel.repaint();
                character.increaseFullness(food.getAddSatiety());
                foodPanel.remove((JLabel) e.getSource());
                foodPanel.revalidate();
                foodPanel.repaint();
                hoverLabel.setVisible(false);
            }
        }
    }
}
