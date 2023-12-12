package src.main.gui.Panels;// panel switching
import src.main.character.Character;
import src.main.character.Monster;
import src.main.character.Win;
import src.main.environment.RegionMap;
import src.main.gui.Panels.CharacterInfo.*;
import src.main.gui.Panels.EndingPanel.GameOverPanel;
import src.main.gui.Panels.TimeSettings.TimeSettingsPanel;
import src.main.app.common.CommonPanelFunction;
import src.main.inventory.Food;
import src.main.inventory.Inventory;
import src.main.inventory.Water;
import src.main.inventory.Weapon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

public class MainFrame extends JFrame {

    private TimeSettingsPanel timeSettingsPanel; // 시간
    private CharacterInfoPanel characterInfoPanel; // 캐릭터
    private InventoryPanel inventoryPanel; // 장비

    private final int width = 900;

    private final int height = 600;

    private final EventLogPanel[] eventLog = {new EventLogPanel("")};
    Character c;
    Inventory i;
    Monster m;
    RegionMap rm;
    StatusPanel status;
    PlayerCharacterPanel playerCharacter;
    JLayeredPane foodPanel;
    JLayeredPane waterPanel;
    JLayeredPane ownedWeaponPanel;
    JPanel equippedWeaponPanel;
    JPanel exitPanel;
    MouseAdapter exitEvent;
    MainFrame mf;
    Container cp;
    public MainFrame(Character character) {
        mf = this;
        this.c = character;
        this.setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(CommonPanelFunction.hexToRgb("303030"));
        cp = getContentPane();
        BorderLayout b = new BorderLayout();
        b.setVgap(10);
        setLayout(b);

        // 디버깅용 나중에 지울 것
        i = new Inventory();

        i.addFood(new Food(1, 20));
        i.addFood(new Food(2, 22));
        i.addFood(new Food(3, 12));
        i.addFood(new Food(4, 33));
        i.addWater(new Water(1, 20));
        i.addWater(new Water(45, 11));
        i.addWater(new Water(2, 2));
        i.addWater(new Water(12, 21));

        i.addWeapon(new Weapon("불의 검", 1, 111));
        i.addWeapon(new Weapon("물의 검", 2, 21));
        i.addWeapon(new Weapon("흙의 검", 3, 45));
        i.addWeapon(new Weapon("풀의 검", 4, 67));
        i.addWeapon(new Weapon("빛의 검", 4, 78));
        c.setEquippedWeapon(i.getWeapons().get(0)); // 기본 첫 번째 무기 장착

        // 디버깅용 나중에 지울 것
        rm = new RegionMap();

        timeSettingsPanel = new TimeSettingsPanel(width, (int) (height * 0.1));
        timeSettingsPanel.getTimeStamp().setTtRegion(rm.getNodes().get(0).getValue()); // 초기 지역 설정
        timeSettingsPanel.setPreferredSize(new Dimension(width, (int) (height * 0.1)));
        timeSettingsPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(timeSettingsPanel, BorderLayout.NORTH);

        m = rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getMonster();
        eventLog[0] = new EventLogPanel(m);

        status = new StatusPanel(c);
        status.getFightStatus().setDefenseLabel(c.getDefense());
        status.getFightStatus().setAttackLabel(c.getAttack());
        status.setBackground(CommonPanelFunction.hexToRgb("303030"));

        playerCharacter = new PlayerCharacterPanel(c);
        playerCharacter.setBackground(CommonPanelFunction.hexToRgb("303030"));

        eventLog[0].setBackground(CommonPanelFunction.hexToRgb("303030"));

        characterInfoPanel = new CharacterInfoPanel(status, playerCharacter);
        characterInfoPanel.setPreferredSize(new Dimension(width, (int) (height * 0.5)));
        characterInfoPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));

        foodPanel = new JLayeredPane();
        waterPanel = new JLayeredPane();
        ownedWeaponPanel = new JLayeredPane();
        inventoryPanel = new InventoryPanel(i, foodPanel, waterPanel, ownedWeaponPanel, status, characterInfoPanel, c);
        add(characterInfoPanel, BorderLayout.CENTER);

        equippedWeaponPanel = new JPanel();
        exitPanel = new JPanel();
        equippedWeaponPanel.addMouseListener(new MouseAdapter() { // '싸운다'를 클릭했을 때
            @Override
            public void mouseClicked(MouseEvent e) {
                characterInfoPanel.remove(eventLog[0]);

                if (c.getAttack() > m.getAttack()) { // 싸워서 이겼으면
                    Win w = new Win(i);
                    eventLog[0] = new EventLogPanel(w.reward());
                    characterInfoPanel.add(eventLog[0]);
                    eventLog[0].setMouseEvent(rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getNeighbors(), c, i, characterInfoPanel, mf); // 다음 지역 이동 이벤트
                } else { // 싸워서 졌으면
                    eventLog[0] = new EventLogPanel("패배...");
                    character.decreaseHp(m.getAttack() - c.getDefense());

                    characterInfoPanel.add(eventLog[0]);
                    characterInfoPanel.remove(status);
                    status.getBodyStatus().setHealthPanel(c.getHp());
                    characterInfoPanel.add(status, 0);
                    if (character.getHp() <= 0) { // 캐릭터의 체력이 0이 되면
                        // 게임 종료 (엔딩으로 가기)
                        dispose();
                        new GameOverPanel();
                    }
                    // 제력이 0이 아니면 체력만 깎고 다음 스테이지 진행
                    else
                        eventLog[0].setMouseEvent(rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getNeighbors(), c, i, characterInfoPanel, mf); // 다음 지역 이동 이벤트
                }
                i.useWeapon(c, character.getEquippedWeapon()); // 장착 무기 사용
                // 무기가 횟수가 다 되서 무기가 변경됐을 떄 사용자의 공격력도 변경함
                characterInfoPanel.remove(status);
                status.getFightStatus().setAttackLabel(c.getAttack());
                characterInfoPanel.add(status, 0);
                //
                cp.remove(inventoryPanel);
                inventoryPanel = new InventoryPanel(i, equippedWeaponPanel, ownedWeaponPanel, exitPanel, status, characterInfoPanel, c);
                inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
                inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
                add(inventoryPanel, BorderLayout.SOUTH);
                cp.revalidate();
                cp.repaint();
                characterInfoPanel.revalidate();
            }
        });
        setExit();
        setNight();

        inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
        inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
        add(inventoryPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }


    public void handleButtonClick(String buttonText) {
        timeSettingsPanel.getTimeStamp().setTtRegion(buttonText); // 초기 지역 설정
        int hour = timeSettingsPanel.getTimeStamp().getTt().getTime().getHour();
        if (hour > 9)
            timeSettingsPanel.getTimeStamp().setTtDay(timeSettingsPanel.getTimeStamp().getTt().getDay() + 1); // 초기 지역 설정
        timeSettingsPanel.getTimeStamp().getTt().resetThread(); // 시간 초기화
        timeSettingsPanel.getTimeStamp().getTt().startThread(); // 시간 시작
        characterInfoPanel.remove(eventLog[0]);
        SwingUtilities.invokeLater(() -> {
            remove(inventoryPanel);
            inventoryPanel = new InventoryPanel(i, foodPanel, waterPanel, ownedWeaponPanel, status, characterInfoPanel, c);
            inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
            inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
            add(inventoryPanel, BorderLayout.SOUTH);
            revalidate();
            repaint();
        });
    }
    public void setExit() {
        if (exitEvent != null) {
            exitPanel.removeMouseListener(exitEvent); // 이전 exitEvent가 존재하면 제거합니다.
        }
        exitEvent = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                characterInfoPanel.remove(eventLog[0]);
                eventLog[0] = new EventLogPanel("무사히 도망쳤습니다.");
                characterInfoPanel.add(eventLog[0]);
                eventLog[0].setMouseEvent(rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getNeighbors(), c, i, characterInfoPanel, mf); // 다음 지역 이동 이벤트
                characterInfoPanel.revalidate();
            }
        };

        if (c.getFullness() == 100 && c.getWater() == 100) {
            exitPanel.addMouseListener(exitEvent);
        }
    }
    public void setNight() {
        final AtomicInteger watchedValue = new AtomicInteger(0);
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        final boolean[] isNight = {false};
        final boolean[] isMonster = {false};
        final boolean[] isMorning = {false};
        final boolean[] isPass = {false};

        // 시간 감지용
        executor.scheduleAtFixedRate(() -> {
            int currentValue = timeSettingsPanel.getTimeStamp().getTt().getTime().getHour();
            watchedValue.set(currentValue);
            double showMonster = 0.2;
            boolean hasMonster = false;
            if(watchedValue.get() < 6 || 21 <= watchedValue.get() && !isMonster[0]) { // 밤이 되었을 떄 몬스터 출현 가능성
                hasMonster = CommonPanelFunction.getRandomBoolean(showMonster);
            }
            if(watchedValue.get() == 5 && !isPass[0]) {
                isPass[0] = true; // 밤 종료 루프 중지
                isMorning[0] = false; // 몬스터 루프 시작
                characterInfoPanel.remove(eventLog[0]);
                timeSettingsPanel.getTimeStamp().getTt().stopThread();
                eventLog[0] = new EventLogPanel("아무일도 일어나지 않았습니다...");
                characterInfoPanel.add(eventLog[0]);
                eventLog[0].setMouseEvent(rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getNeighbors(), c, i, characterInfoPanel, this); // 다음 지역 이동 이벤트
                characterInfoPanel.revalidate();
                repaint();
            }
            // 몬스터 출몰시
            else if (hasMonster && !isMonster[0]) {
                isMonster[0] = true; // 몬스터 루프 중지
                isNight[0] = true; // 밤 루프 중지
                isMorning[0] = false; // 낮 루프 시작
                setExit();
                timeSettingsPanel.getTimeStamp().getTt().stopThread();

                SwingUtilities.invokeLater(() -> {
                    remove(inventoryPanel);
                    characterInfoPanel.remove(eventLog[0]);
                    m = rm.getNode(timeSettingsPanel.getTimeStamp().getTt().getRegion()).getMonster();
                    eventLog[0] = new EventLogPanel(m);
                    characterInfoPanel.add(eventLog[0]);
                    characterInfoPanel.revalidate();
                    inventoryPanel = new InventoryPanel(i, equippedWeaponPanel, ownedWeaponPanel, exitPanel, status, characterInfoPanel, c);
                    inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
                    inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
                    add(inventoryPanel, BorderLayout.SOUTH);
                    revalidate();
                    repaint();
                });
            } else if ((watchedValue.get() < 6 || 21 <= watchedValue.get()) && !isNight[0]) {
                isNight[0] = true; // 밤 루프 중지
                isMorning[0] = false; // 낮 루프 시작
                SwingUtilities.invokeLater(() -> {
                    remove(inventoryPanel);
                    characterInfoPanel.remove(eventLog[0]);
                    eventLog[0] = new EventLogPanel("밤이 되었습니다.");
                    characterInfoPanel.add(eventLog[0]);
                    characterInfoPanel.revalidate();
                    inventoryPanel = new InventoryPanel(i, equippedWeaponPanel, ownedWeaponPanel, exitPanel, status, characterInfoPanel, c);
                    inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
                    inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
                    add(inventoryPanel, BorderLayout.SOUTH);
                    revalidate();
                    repaint();
                });
            } else if (6 <= watchedValue.get() && watchedValue.get() < 21 && !isMorning[0]) { // 아침 아이템 확인 및 사용
                isMorning[0] = true; // 낮 루프 중지
                isNight[0] = false; // 밤 루프 시작
                isMonster[0] = false; // 몬스터 루프 시작
                isPass[0] = false; // 밤 종료 이벤트 루프 시작
                SwingUtilities.invokeLater(() -> {
                    remove(inventoryPanel);
                    inventoryPanel = new InventoryPanel(i, foodPanel, waterPanel, ownedWeaponPanel, status, characterInfoPanel, c);
                    inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
                    inventoryPanel.setBackground(CommonPanelFunction.hexToRgb("303030"));
                    add(inventoryPanel, BorderLayout.SOUTH);
                    revalidate();
                    repaint();
                });
            }
        }, 0, 100, TimeUnit.MILLISECONDS); // 0.5초마다 실행
    }
}
