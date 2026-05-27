import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int damage;
    private List<Item> inventory;
    private int level;
    private int xp;
    private int gold;
    private int fullHP;

    private Weapon equippedWeapon;

    Random rand = new Random();


    public Player(String name, int health, int damage, int level, int xp, int gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.inventory = new ArrayList<>();
        this.level = level;
        this.xp = xp;
        this.gold = gold;
        this.fullHP = health;
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
        int damageWithWeapon = 0;
        if(equippedWeapon !=null) {
            damageWithWeapon = equippedWeapon.getDamage();
        }
        return damage + rand.nextInt(5) + damageWithWeapon;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

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

    public int getFullHP() {return fullHP;}

    public void setFullHP(int fullHP) {this.fullHP = fullHP;}
    //атака
    public void attack(Monster monster) {

        int finalDamage = getDamage();

        monster.setHealth(
                monster.getHealth() - finalDamage
        );
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", inventory=" + inventory +
                ", level=" + level +
                ", xp=" + xp +
                ", gold=" + gold +
                ", rand=" + rand +
                ", fullHP=" + fullHP +
                '}';
    }
    //оружие
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
    public void equipWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }
}