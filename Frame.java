import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Frame extends JFrame {

    public Frame() {
        super("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Character");
        getContentPane().add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        // 버튼 추가
        JButton button1 = new JButton("식량");
        JButton button2 = new JButton("물");
        JButton button3 = new JButton("무기");

        Dimension buttonSize = new Dimension(160, 80);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        buttonPanel.add(button1, BorderLayout.WEST);
        buttonPanel.add(button2, BorderLayout.CENTER);
        buttonPanel.add(button3, BorderLayout.EAST);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // 창 크기 설정
        setSize(500, 500);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        Frame Frame = new Frame();
    }
}
