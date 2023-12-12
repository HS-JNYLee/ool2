package src.main.app.common;

import java.awt.*;
import java.util.Random;

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
}