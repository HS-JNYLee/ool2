package src.main.gui.Panels.CharacterInfo;

import src.main.app.common.CommonPanelFunction;
import src.main.character.Monster;
import src.main.environment.RegionMap;
import src.main.gui.Panels.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
public class EventLogPanel extends JPanel {
    JPanel eventPanel;
    public EventLogPanel(Monster m) {
        setLayout(new BorderLayout());

        eventPanel = new JPanel();
        eventPanel.setLayout(new GridBagLayout());
        eventPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        String monsterImageLink = "src/resources/images/seoulMonster.png";
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
        eventPanel.add(monsterImageLabel, gbc);

        JLabel monsterStatus = new JLabel("["+m.getName()+"] "+"공격력 : " + m.getAttack());
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        monsterStatus.setFont(f);
        monsterStatus.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        eventPanel.add(monsterStatus, gbc);

        add(eventPanel, BorderLayout.CENTER);
    }

    public EventLogPanel(String event) {
        setLayout(new BorderLayout());

        eventPanel = new JPanel();
        eventPanel.setLayout(new GridBagLayout());
        eventPanel.setBackground(Color.BLACK);

        JLabel actionLog = new JLabel(event);
        Font f = new Font("NanumGothic", Font.BOLD, 20);
        actionLog.setFont(f);
        actionLog.setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        actionLog.setHorizontalAlignment(SwingConstants.CENTER);
        eventPanel.add(actionLog);

        add(eventPanel, BorderLayout.CENTER);
    }

    public void setMouseEvent(List<RegionMap.Node> neighbors) {
        eventPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel monsterStatus = new JLabel("다음 지역으로 이동합니다.");
                Font f = new Font("NanumGothic", Font.BOLD, 20);
                monsterStatus.setFont(f);
                monsterStatus.setForeground(Color.WHITE);
                monsterStatus.setHorizontalAlignment(SwingConstants.CENTER);
                monsterStatus.setAlignmentX(Component.CENTER_ALIGNMENT);

                JPanel centerPanel = new JPanel();
                centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
                centerPanel.setBackground(Color.BLACK);
                centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                centerPanel.add(Box.createVerticalGlue());
                centerPanel.add(monsterStatus);
                centerPanel.add(Box.createVerticalGlue());

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬
                buttonPanel.setBackground(Color.BLACK);

                for (RegionMap.Node n : neighbors) {
                    JButton j = new JButton(n.getValue());
                    j.setForeground(CommonPanelFunction.hexToRgb("D0D0D0"));
                    j.setBackground(CommonPanelFunction.hexToRgb("252525"));
                    j.setBorderPainted(false);
                    j.setOpaque(true);
                    j.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 버튼의 텍스트 값을 최상위 부모 패널로 전달
                            Component parent = getParent();
                            while (parent.getParent() != null) {
                                parent = parent.getParent(); // 부모 패널 계층 구조 따라가기
                            }
                            if (parent instanceof MainFrame) {
                                String buttonText = j.getText();
                                ((MainFrame) parent).handleButtonClick(buttonText);
                            }
                        }
                    });
                    buttonPanel.add(j);
                }

                JPanel eventPanel = new JPanel(new BorderLayout());
                eventPanel.setBackground(Color.BLACK);
                eventPanel.add(centerPanel, BorderLayout.CENTER);
                eventPanel.add(buttonPanel, BorderLayout.SOUTH);

                removeAll();
                add(eventPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });
    }

}
