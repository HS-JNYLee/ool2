package src.main.gui.Panels;// panel switching
import src.main.character.Character;
import src.main.character.Monster;
import src.main.character.Win;
import src.main.gui.Panels.CharacterInfo.*;
import src.main.gui.Panels.TimeSettings.TimeSettingsPanel;
import src.main.app.common.CommonPanelFunction;
import src.main.inventory.Inventory;
import src.main.inventory.Weapon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        // 디버깅용 나중에 지울 것
        Inventory i = new Inventory();
        i.addWeapon(new Weapon("불의 검", 1, 999));
        i.addWeapon(new Weapon("물의 검", 2, 777));
        i.addWeapon(new Weapon("흙의 검", 3, 888));
        i.addWeapon(new Weapon("풀의 검", 4, 666));
        i.addWeapon(new Weapon("빛의 검", 4, 666));
        i.setEquipedWeapon(i.getWeapons().get(0));

        Character c = new Character();
        c.setFullness(100);
        c.increaseWater(100);
        c.setAttack(20);

        Monster m = new Monster(10, "오우거");
        // 디버깅용 나중에 지울 것

        timeSettingsPanel = new TimeSettingsPanel( width, (int) (height * 0.1));
        timeSettingsPanel.setPreferredSize(new Dimension(width, (int) (height * 0.1)));
        timeSettingsPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(timeSettingsPanel, BorderLayout.NORTH);

        StatusPanel status = new StatusPanel();
        status.setBackground(CommonPanelFunction.hexToRgb("303030"));

        PlayerCharacterPanel playerCharacter = new PlayerCharacterPanel();
        playerCharacter.setBackground(CommonPanelFunction.hexToRgb("303030"));

        final EventLogPanel[] eventLog = {new EventLogPanel(m)};
        eventLog[0].setBackground(CommonPanelFunction.hexToRgb("303030"));

        characterInfoPanel = new CharacterInfoPanel(status, playerCharacter, eventLog[0]);
        characterInfoPanel.setPreferredSize(new Dimension(width, (int) (height * 0.5)));
        characterInfoPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(characterInfoPanel, BorderLayout.CENTER);


        JPanel equipedWeaponPanel = new JPanel();
        JLayeredPane ownedWeaponPanel = new JLayeredPane();
        JPanel exitPanel = new JPanel();
        equipedWeaponPanel.addMouseListener(new MouseAdapter() { // '싸운다'를 클릭했을 때
            @Override
            public void mouseClicked(MouseEvent e) {
                characterInfoPanel.remove(eventLog[0]);
                if(c.getAttack() > m.getAttack()) {
                    Win w = new Win(i);
                    eventLog[0] = new EventLogPanel(w.reward());
                    characterInfoPanel.add(eventLog[0]);
                    eventLog[0].setMouseEvent();
                }else {
                    eventLog[0] = new EventLogPanel("패배...");
                    characterInfoPanel.add(eventLog[0]);
                }
                characterInfoPanel.revalidate();
            }
        });
        MouseAdapter exitEvent = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                characterInfoPanel.remove(eventLog[0]);
                eventLog[0] = new EventLogPanel("무사히 도망쳤습니다.");
                characterInfoPanel.add(eventLog[0]);
                characterInfoPanel.revalidate();
            }
        };

        if(c.getFullness() == 100 && c.getWater() == 100) {
            exitPanel.addMouseListener(exitEvent);
        }else {
            exitPanel.removeMouseListener(exitEvent);
        }
        inventoryPanel = new InventoryPanel(i, equipedWeaponPanel, ownedWeaponPanel, exitPanel);
        inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
        inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(inventoryPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }

}
