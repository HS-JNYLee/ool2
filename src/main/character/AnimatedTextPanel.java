package src.main.character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedTextPanel extends JPanel {
    private String firstLine = "";
    private String secondLine = "";
    private String thirdLine = "";
    private int currentIndex1 = 0;
    private int currentIndex2 = 0;
    private int currentIndex3 = 0;
    private Timer timer;
    private String fullText1 = "환경 오염으로 인해 북쪽에서부터 한랭 전선이 내려오고 있습니다.";

    private String fullText2 = "기후 이상으로 생긴 몬스터들에게서 성공적으로 살아남길 빕니다.\n";

    private String fullText3 = "안전지대인 최종 도착지 제주도로 성공적으로 도착하세요.";
    public AnimatedTextPanel() {

            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            updateText();
                            return null;
                        }

                        @Override
                        protected void done() {
                            repaint();
                        }
                    };

                    worker.execute();
                }
            });
            timer.start();
        }

        private void updateText () {
            // Text update logic here
            // ...

            if (currentIndex1 < fullText1.length()) {
                firstLine += fullText1.charAt(currentIndex1);
                currentIndex1++;
            } else if (currentIndex2 < fullText2.length()) {
                secondLine += fullText2.charAt(currentIndex2);
                currentIndex2++;
            } else if (currentIndex3 < fullText3.length()) {
                thirdLine += fullText3.charAt(currentIndex3);
                currentIndex3++;
            } else {
                // 텍스트가 모두 나왔을 때 ChooseCharacterFrame으로 전환
                timer.stop(); // 타이머 중지

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AnimatedTextPanel.this);
                        frame.getContentPane().removeAll(); // 기존 컴포넌트 삭제

                        ChooseCharacterFrame chooseCharacterFrame = new ChooseCharacterFrame();
                        frame.add(chooseCharacterFrame);
                        frame.revalidate();
                        frame.repaint();
                    }
                });
            }

        }

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);  // 텍스트 색상을 흰색으로 설정

            Font textFont = new Font("SansSerif", Font.BOLD, 23);
            g.setFont(textFont);

            // 첫 번째 텍스트를 화면 상단에 위치시킴
            FontMetrics metrics1 = g.getFontMetrics(textFont);
            int x1 = (getWidth() - metrics1.stringWidth(firstLine)) / 2;
            int y1 = ((getHeight() - metrics1.getHeight()) / 2) - metrics1.getAscent();
            g.drawString(firstLine, x1, y1);

            // 두 번째 텍스트를 화면 정 가운데에 위치시킴
            FontMetrics metrics2 = g.getFontMetrics(textFont);
            int x2 = (getWidth() - metrics2.stringWidth(secondLine)) / 2;
            int y2 = ((getHeight() - metrics2.getHeight()) / 2) + metrics2.getAscent();
            g.drawString(secondLine, x2, y2);

            // 세 번째 텍스트를 화면 하단에 위치시킴
            FontMetrics metrics3 = g.getFontMetrics(textFont);
            int x3 = (getWidth() - metrics3.stringWidth(thirdLine)) / 2;
            int y3 = ((getHeight() - metrics3.getHeight()) / 2) + metrics3.getAscent() + metrics3.getHeight();
            g.drawString(thirdLine, x3, y3);
        }

        private void closeFrame () {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose(); // 창을 닫음
        }

        public static void main (String[]args){
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("텍스트 애니메이션");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 600);
                frame.setLocationRelativeTo(null);

                AnimatedTextPanel animatedTextPanel = new AnimatedTextPanel();
                frame.add(animatedTextPanel);

                frame.setVisible(true);
            });
        }


}
