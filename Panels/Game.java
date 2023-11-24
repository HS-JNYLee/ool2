package Panels;// panel switching
import java.awt.*;

import javax.swing.*;

import static Panels.CommonFunction.hextoRgb;

class CommonFunction {
    static public Color hextoRgb(String hexCode) {
        Color c = new Color(
                Integer.valueOf( hexCode.substring( 0, 2 ), 16 ),
                Integer.valueOf( hexCode.substring( 2, 4 ), 16 ),
                Integer.valueOf( hexCode.substring( 4, 6 ), 16 )
        );
        return c;
    }
}

class TopPanel extends JPanel {
    JButton setting; // 설정 버튼
    TimestampPanel timeStamp; // 시간 정보를 담은 패널
    TopPanel(int width, int height) {
        setLayout(new BorderLayout());
        setting = new JButton("설정");
        setting.setPreferredSize(new Dimension((int) (width * 0.1), (int) (height * 0.5)));
        add(setting, BorderLayout.WEST);

        timeStamp = new TimestampPanel((int) (width * 0.7), height);
        timeStamp.setBackground(hextoRgb("303030"));
        timeStamp.setPreferredSize(new Dimension ((int) (width * 0.7), height));
        add(timeStamp, BorderLayout.EAST);
    }
}

class TimestampPanel extends JPanel {
    TimestampLabel region;
    TimestampLabel day;
    TimestampLabel realtime;
    int width;
    int height;
    TimestampPanel(int width, int height) {
        this.width = width;
        this.height = height;

        region = new TimestampLabel("서울");
        region.setForeground(hextoRgb("856b54"));
        day = new TimestampLabel("Day 02");
        realtime = new TimestampLabel("21:00");
        realtime.setForeground(hextoRgb("D0D0D0"));

        add(region);
        add(day);
        add(realtime);
    }

    class TimestampLabel extends JLabel {
        TimestampLabel(String name) {
            Font f = new Font("NanumGothic", Font.ITALIC, (int) (height * 0.5));

            setFont(f);
            setText(name);
            setPreferredSize(new Dimension((int) (width * 0.3), height));
            setOpaque(true);
            setForeground(hextoRgb("bbb7b3"));
            setBackground(hextoRgb("252525"));
            setHorizontalAlignment(JLabel.CENTER);
        }
    }
}

class CenterPanel extends JPanel {
    StatusPanel status; // 캐릭터의 능력치를 확인하는 패널
    CharacterPanel character; // 캐릭터의 위치

    EventLogPanel eventLog; // 이벤트 정보가 나오는 창

    CenterPanel() {
        setLayout(new GridLayout(1, 3));
        status = new StatusPanel();
        status.setBackground(hextoRgb("303030"));

        character = new CharacterPanel();
        character.setBackground(hextoRgb("303030"));

        eventLog = new EventLogPanel();
        eventLog.setBackground(hextoRgb("303030"));

        add(status);
        add(character);
        add(eventLog);
    }
} // 중앙 패널

class StatusPanel extends JPanel {
    BodyStatusPanel bodyStatus; // 캐릭터 몸상태를 알려주는 패널
    FightStatusPanel fightStatus; // 캐릭터의 전투 능력치를 알려주는 패널

    StatusPanel() {
        setLayout(new GridLayout(2, 1, 0, 5));

        bodyStatus = new BodyStatusPanel();
        bodyStatus.setBackground(hextoRgb("303030"));

        fightStatus = new FightStatusPanel();
        fightStatus.setBackground(hextoRgb("201A07"));

        add(bodyStatus);
        add(fightStatus);
    }
} // 캐릭터의 종합적인 수치를 보여주는 패널

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
        healthText.setBackground(hextoRgb("FF3535"));
        healthText.setOpaque(true);
        healthText.setForeground(hextoRgb("303030"));
        healthText.setFont(f);
        add(healthText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 80; // 80%
        healthPanel = new JPanel();
        healthPanel.setLayout(new BorderLayout());
        healthPanel.add(new ProgressBar(20, hextoRgb("FF3535"), hextoRgb("FFB5B5")));
        add(healthPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 20; // 20%
        fullnessText = new JLabel("포만감");
        fullnessText.setBackground(hextoRgb("57FF72"));
        fullnessText.setOpaque(true);
        fullnessText.setForeground(hextoRgb("303030"));
        fullnessText.setFont(f);
        add(fullnessText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 80; // 80%
        fullnessPanel = new JPanel();
        fullnessPanel.setLayout(new BorderLayout());
        fullnessPanel.add(new ProgressBar(40, hextoRgb("57FF72"), hextoRgb("DEFFCF")));
        add(fullnessPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 20; // 20%
        waterText = new JLabel("수분");
        waterText.setBackground(hextoRgb("44BCFF"));
        waterText.setOpaque(true);
        waterText.setForeground(hextoRgb("303030"));
        waterText.setFont(f);
        add(waterText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 80; // 80%
        waterPanel = new JPanel();
        waterPanel.setLayout(new BorderLayout());
        waterPanel.add(new ProgressBar(60, hextoRgb("44BCFF"), hextoRgb("CFF6FF")));
        add(waterPanel, gbc);
    }
    class ProgressBar extends JPanel {
        JPanel completePanel;
        JPanel remainPanel;
        ProgressBar(int completePortion, Color completeColor, Color remainColor) {
            setLayout(new GridBagLayout());
            setBackground(hextoRgb("303030"));

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

    class FightStatusPanel extends JPanel {
    JLabel attackLabel;
    JLabel defenseLabel;

    FightStatusPanel() {
        setLayout(new GridLayout(2, 1));
        Font f = new Font("함초롱바탕", Font.BOLD, 30);
        String attackStatus = "150";
        attackLabel = new JLabel("공격력 : " + attackStatus);
        attackLabel.setFont(f);
        attackLabel.setForeground(hextoRgb("A89157"));
        add(attackLabel);

        String defenseStatus = "090";
        defenseLabel = new JLabel("방어력 : " + defenseStatus);
        defenseLabel.setFont(f);
        defenseLabel.setForeground(hextoRgb("A89157"));
        add(defenseLabel);
    }
} // 공격력, 방어력 스테이터스를 보여주는 패널

class CharacterPanel extends JPanel { // 캐릭터를 보여주는 화면
    JLabel characterImageLabel;
    CharacterPanel() {
        String characterImageLink = "character1.png";
        ImageIcon characterImageIcon = new ImageIcon(characterImageLink);
        characterImageLabel = new JLabel(characterImageIcon);
        characterImageLabel.setBounds(150, 30, characterImageIcon.getIconWidth(), characterImageIcon.getIconHeight());
        characterImageLabel.setBackground(hextoRgb("303030"));
        add(characterImageLabel);
    }
}

class EventLogPanel extends JPanel {
    JPanel monsterEventPanel;
    EventLogPanel() {
        setLayout(new BorderLayout());

        monsterEventPanel = new JPanel();
        monsterEventPanel.setLayout(new GridBagLayout());
        monsterEventPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        String monsterImageLink = "seoulMonster.png";
        ImageIcon monsterImageIcon = new ImageIcon(monsterImageLink);

        Image beforeImage = monsterImageIcon.getImage();
        Image resizeImage = beforeImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        monsterImageIcon = new ImageIcon(resizeImage);

        JLabel monsterImageLabel;
        monsterImageLabel = new JLabel(monsterImageIcon);
        monsterImageLabel.setBounds(150, 30, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.9;
        monsterEventPanel.add(monsterImageLabel, gbc);

        String mosterAttack = "100";
        JLabel monsterStatus = new JLabel("공격력 : " + mosterAttack);
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        monsterStatus.setFont(f);
        monsterStatus.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        monsterEventPanel.add(monsterStatus, gbc);

        add(monsterEventPanel, BorderLayout.CENTER);
    }
}

class InventoryPanel extends JPanel {
    JPanel equipedWeaponPanel;
    JPanel ownedWeaponPanel;
    JPanel exitPanel;

    InventoryPanel() {
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        setLayout(new GridLayout(1, 3, 5, 0));

        equipedWeaponPanel = new JPanel();
        equipedWeaponPanel.setBackground(hextoRgb("252525"));
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
        ownedWeaponPanel.setBackground(hextoRgb("252525"));
        ownedWeaponPanel.setLayout(new BoxLayout(ownedWeaponPanel, BoxLayout.X_AXIS));

        JLabel A = new JLabel("무기A");
        A.setFont(f);
        A.setOpaque(true);
        A.setBackground(hextoRgb("D0D0D0"));
        A.setForeground(Color.WHITE);
        A.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel B = new JLabel("무기B");
        B.setFont(f);
        B.setOpaque(true);
        B.setBackground(hextoRgb("D0D0D0"));
        B.setForeground(Color.WHITE);
        B.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel C = new JLabel("무기C");
        C.setFont(f);
        C.setOpaque(true);
        C.setBackground(hextoRgb("D0D0D0"));
        C.setForeground(Color.WHITE);
        C.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel D = new JLabel("무기D");
        D.setFont(f);
        D.setOpaque(true);
        D.setBackground(hextoRgb("D0D0D0"));
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
        ownedWeaponPanelWrapper.setBackground(hextoRgb("252525"));

        ownedWeaponPanelWrapper.add(Box.createVerticalGlue());
        ownedWeaponPanelWrapper.add(ownedWeaponPanel);
        ownedWeaponPanelWrapper.add(Box.createVerticalGlue());

        add(ownedWeaponPanelWrapper);

        exitPanel = new JPanel();
        exitPanel.setBackground(hextoRgb("252525"));

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


public class Game extends JFrame {

    private TopPanel topPanel; // 시간
    private CenterPanel centerPanel; // 캐릭터
    private InventoryPanel inventoryPanel; // 장비

    private final int width = 900;

    private final int height = 600;

    public Game() {
        this.setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(hextoRgb("303030"));

        BorderLayout b = new BorderLayout();
        b.setVgap(10);
        setLayout(b);

        topPanel = new TopPanel( width, (int) (height * 0.1));
        topPanel.setPreferredSize(new Dimension(width, (int) (height * 0.1)));
        topPanel.setBackground(hextoRgb("303030"));
        add(topPanel, BorderLayout.NORTH);

        centerPanel = new CenterPanel();
        centerPanel.setPreferredSize(new Dimension(width, (int) (height * 0.5)));
        centerPanel.setBackground(hextoRgb("303030"));
        add(centerPanel, BorderLayout.CENTER);

        inventoryPanel = new InventoryPanel();
        inventoryPanel.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
        inventoryPanel.setBackground(hextoRgb("303030"));
        add(inventoryPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }

    /*public void change(String panelName) {
        if(panelName.equals("sPanel")) {
            System.out.println(panelName);
            getContentPane().removeAll();
            getContentPane().add(sPanel);
        }else {
            getContentPane().removeAll();
            getContentPane().add(gPanel);
        }
        revalidate();
        repaint();
    }*/

    public static void main(String[] args) {
        new Game();
    }

}
