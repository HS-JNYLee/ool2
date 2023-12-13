package src.main.app.common;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.List;

public class CommonPanelFunction {
    static public Color hexToRgb(String hexCode) {
        Color c = new Color(
                Integer.valueOf(hexCode.substring(0, 2), 16),
                Integer.valueOf(hexCode.substring(2, 4), 16),
                Integer.valueOf(hexCode.substring(4, 6), 16)
        );
        return c;
    }

    public static boolean getRandomBoolean(double probability) {
        Random random = new Random();
        return random.nextDouble() < probability;
    }

    // 랜덤 UUID 생성 하는 코드 : 아이템 식별용
    public static String getRandomId() {
        return UUID.randomUUID().toString();
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
                System.out.println(directoryPath + "/" + pngFiles.get(randomIndex));
                return directoryPath + "/" + pngFiles.get(randomIndex);
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

    // 효과음 재생 메서드
    public static void playClickSound(String filename) {
        try {
            // 효과음 파일 경로 설정
            File soundFile = new File("src/resources/sounds/" + filename); // 여기에 실제 효과음 파일 경로를 넣어주세요

            // 오디오 입력 스트림 생성
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // 오디오 포맷 가져오기
            AudioFormat audioFormat = audioInputStream.getFormat();

            // 데이터를 읽기 위한 SourceDataLine 열기
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

            // 효과음 재생 준비
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // 효과음 데이터를 버퍼에 쓰고 재생
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                sourceDataLine.write(buffer, 0, bytesRead);
            }

            // 재생이 끝나면 리소스 해제
            sourceDataLine.drain();
            sourceDataLine.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 효과음 재생 메서드
    public static void playBgmSound(String filename) {
        try {
            // 효과음 파일 경로 설정
            File soundFile = new File("src/resources/sounds/" + filename); // 여기에 실제 효과음 파일 경로를 넣어주세요

            // 오디오 입력 스트림 생성
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // 오디오 포맷 가져오기
            AudioFormat audioFormat = audioInputStream.getFormat();

            // 데이터를 읽기 위한 SourceDataLine 열기
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

            // 효과음 재생 준비
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // 효과음 데이터를 버퍼에 쓰고 재생
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while (true) {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                    sourceDataLine.write(buffer, 0, bytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// 효과음 재생 메서드

    public static Clip playBgmSoundByClip(String filename) {
        Clip clip = null;
        try {
            File bgmFile = new File("src/resources/sounds/" + filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bgmFile);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // 무한 반복하도록 설정합니다.
            clip.stop();
            // 클립을 처음으로 되감습니다.
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // 배경음악을 재생합니다.
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
        return clip;
    }

    // 자식 컴포넌트의 테두리 제거하기
    public static void removeBordersRecursively(Component comp) {
        if (comp instanceof Container) {
            Component[] components = ((Container) comp).getComponents();
            for (Component component : components) {
                if (component instanceof JLabel) {
                    ((JLabel) component).setBorder(null); // 테두리 제거
                }
                removeBordersRecursively(component); // 재귀적으로 자식 컴포넌트 탐색
            }
        }
    }
}