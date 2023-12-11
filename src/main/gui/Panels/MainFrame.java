package src.main.gui.Panels;// panel switching
import src.main.gui.Panels.CharacterInfo.CharacterInfoPanel;
import src.main.gui.Panels.CharacterInfo.InventoryPanel;
import src.main.gui.Panels.TimeSettings.TimeSettingsPanel;
import src.main.app.common.CommonPanelFunction;
import src.main.inventory.Inventory;
import src.main.inventory.Weapon;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {

    private TimeSettingsPanel timeSettingsPanel; // 시간
    private CharacterInfoPanel characterInfoPanel; // 캐릭터
    private InventoryPanel inventoryPanel; // 장비

    private final int width = 900;

    private final int height = 600;

    public MainFrame() {
        this.setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(CommonPanelFunction.hexToRgb("303030"));

        BorderLayout b = new BorderLayout();
        b.setVgap(10);
        setLayout(b);

        timeSettingsPanel = new TimeSettingsPanel( width, (int) (height * 0.1));
        timeSettingsPanel.setPreferredSize(new Dimension(width, (int) (height * 0.1)));
        timeSettingsPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(timeSettingsPanel, BorderLayout.NORTH);

        characterInfoPanel = new CharacterInfoPanel();
        characterInfoPanel.setPreferredSize(new Dimension(width, (int) (height * 0.5)));
        characterInfoPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(characterInfoPanel, BorderLayout.CENTER);

        // 디버깅용 나중에 지울 것
        Inventory i = new Inventory();
        i.addWeapon(new Weapon("불의 검", 1, 999));
        i.addWeapon(new Weapon("물의 검", 2, 777));
        i.addWeapon(new Weapon("흙의 검", 3, 888));
        // 디버깅용 나중에 지울 것
        inventoryPanel = new InventoryPanel(i);
        inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
        inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(inventoryPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }

}
