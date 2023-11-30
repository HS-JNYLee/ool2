package src.main.app.common;

import java.awt.*;

public class CommonPanelFunction {
    static public Color hexToRgb(String hexCode) {
        Color c = new Color(
                Integer.valueOf( hexCode.substring( 0, 2 ), 16 ),
                Integer.valueOf( hexCode.substring( 2, 4 ), 16 ),
                Integer.valueOf( hexCode.substring( 4, 6 ), 16 )
        );
        return c;
    }
}