import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Food> food;

    private List<Water> water;
    private List<Weapon> weapon;

    public Inventory() {
        this.food = new ArrayList<>();
        this.water = new ArrayList<>();
        this.weapon = new ArrayList<>();
    }

    // getters and setters
    public List<Food> getFood() {
        return food;
    }

    public List<Water> getWater() {
        return water;
    }

    public List<Weapon> getWeapon() {
        return weapon;
    }
}
