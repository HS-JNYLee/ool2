package src.main.gui.Panels.ExplainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplainPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ExplainPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 각 페이지를 나타내는 패널들을 생성
        JPanel page1 = createPage("", "src/resources/images/explain1.png");
        JPanel page2 = createPage("", "src/resources/images/explain.png");
        JPanel page3 = createPage("", "src/resources/images/explain3.png");

        // 각 페이지를 cardPanel에 추가
        cardPanel.add(page1, "Page 1");
        cardPanel.add(page2, "Page 2");
        cardPanel.add(page3, "Page 3");

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // 다음 페이지로 전환하는 버튼을 추가
        JButton nextButton = new JButton("다음 페이지");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        // 버튼을 포함한 하단 패널을 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);  // 검은색 배경으로 설정
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createPage(String content, String imagePath) {
        JPanel pagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);  // 검은색 배경으로 설정
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        JLabel label = new JLabel(content);

        // 이미지 크기를 조절하여 ImageIcon 생성
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // ImageIcon을 이용하여 JLabel에 이미지 추가
        label.setIcon(resizedIcon);

        pagePanel.add(label);
        return pagePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("게임 설명서");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 600);
                frame.setLocationRelativeTo(null);

                ExplainPanel explainPanel = new ExplainPanel();
                frame.add(explainPanel);

                frame.setVisible(true);
            }
        });
    }
}
