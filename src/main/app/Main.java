package src.main.app;

import src.main.character.Character;
import src.main.gui.Panels.MainFrame;

public class Main {
    public static void main(String[] args) {
        Character c = new Character();
        c.setFullness(100);
        c.increaseWater(100);
        c.setAttack(20);
        c.setDefense(40);
        new MainFrame(c);
    }
}
