import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int damage;
    private List<String> inventory;
    private int level;
    private int xp;
    private int gold;
    Random rand = new Random();

    // я думаю надо делать пока без инвентаря либо делать еще один конструктор без него
    public Player(String name, int health, int damage, int level, int xp, int gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
//        this.inventory = inventory;
        this.level = level;
        this.xp = xp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage + rand.nextInt(5);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

//    public List<String> getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(List<String> inventory) {
//        this.inventory = inventory;
//    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void attack(Monster monster) {

        int finalDamage = getDamage();

        monster.setHealth(
                monster.getHealth() - finalDamage
        );
    }
}