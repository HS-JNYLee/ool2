package src.main.app.common;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.List;
public class CommonPanelFunction {
    static public Color hexToRgb(String hexCode) {
        Color c = new Color(
                Integer.valueOf( hexCode.substring( 0, 2 ), 16 ),
                Integer.valueOf( hexCode.substring( 2, 4 ), 16 ),
                Integer.valueOf( hexCode.substring( 4, 6 ), 16 )
        );
        return c;
    }
    public static boolean getRandomBoolean(double probability) {
        Random random = new Random();
        return random.nextDouble() < probability;
    }

    // 랜덤 UUID 생성 하는 코드 : 아이템 식별용
    public static String getRandomId() {
        return  UUID.randomUUID().toString();
    }

    public static String getRandomPNGFileName(String directoryPath) {
        File dir = new File(directoryPath);
        List<String> pngFiles = new ArrayList<>();

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            // 디렉토리 내 모든 파일 검사
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {
                    pngFiles.add(file.getName());
                }
            }

            if (!pngFiles.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(pngFiles.size());
                System.out.println(directoryPath +"/"+ pngFiles.get(randomIndex));
                return directoryPath +"/"+ pngFiles.get(randomIndex);
            } else {
                System.out.println("해당 경로에 .png 파일이 없습니다.");
            }
        } else {
            System.out.println("유효하지 않은 디렉토리 경로입니다.");
        }

        return null;
    }

    public static ImageIcon resizeImage(String filePath) {
            ImageIcon originImage = new ImageIcon(filePath);
            Image image = originImage.getImage();
            Image resizeImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);

            return new ImageIcon(resizeImage);
    }

    public static ImageIcon resizeImage(String filePath, int width, int height) {
            ImageIcon originImage = new ImageIcon(filePath);
            Image image = originImage.getImage();
            Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            return new ImageIcon(resizeImage);
    }

    // 랜덤한 정수 리턴
    public static int getRandomInt(int start, int end) {
        Random random = new Random();
        return random.nextInt((end - start) + 1) + start;
    }
}