package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import system.Dice;
import system.RollResult;
import items.Item;
import items.Weapon;

public class Player {
    private String name;
    private int health;
    private List<Item> inventory;
    private int level;
    private int xp;
    private int gold;
    private int fullHP;
    private int strength;
    private int agility;
    private int vitality;
    private int statPoints;

    private Weapon equippedWeapon;
    private Dice dice = new Dice();

    Random rand = new Random();


    public Player(String name, int health, int level, int xp, int gold,int strength, int agility, int vitality, int statPoints) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
        this.level = level;
        this.xp = xp;
        this.gold = gold;
        this.fullHP = health;
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
        this.statPoints = statPoints;
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

    public int getFullHP() {
        return fullHP;
    }

    public void setFullHP(int fullHP) {
        this.fullHP = fullHP;
    }

    public int getStrength() {return strength;}

    public int getAgility() {return agility;}

    public int getVitality() {return vitality;}

    public int getStatPoints() {return statPoints;}

    //атака
    public int getDamage() {
        int damageWithWeapon = 0;
        if (equippedWeapon != null) {
            damageWithWeapon = equippedWeapon.getDamage();
        }
        return strength + rand.nextInt(5) + damageWithWeapon;
    }

    public void attack(Monster monster) {
        RollResult rollResult = dice.roll();

        int finalDamage = getDamage();

        switch (rollResult) {
            case EXCELLENT -> finalDamage *= 2;
            case GOOD -> finalDamage += 3;
            case SATISFACTORY -> finalDamage += 2;
            case MEDIOCRE -> finalDamage += 0;
            case POOR -> finalDamage = Math.max(1, finalDamage / 2);
            case UNSATISFACTORY -> finalDamage = 0;
        }

        monster.setHealth(
                monster.getHealth() - finalDamage);

        System.out.println(monster.getName() + " attacked " + getName());
        System.out.println(
                "[" + rollResult + "] " +
                        "Player " + this.name + " HP|" + this.health + " attacked and take "
                        + finalDamage + " damages for " + monster.getName()
        );

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", inventory=" + inventory +
                ", level=" + level +
                ", xp=" + xp +
                ", gold=" + gold +
                ", fullHP=" + fullHP +
                ", strength=" + strength +
                ", agility=" + agility +
                ", vitality=" + vitality +
                ", equippedWeapon=" + equippedWeapon +
                ", dice=" + dice +
                ", rand=" + rand +
                '}';

}

    //оружие
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    //уровни
    public void lvlUp (){
        level++;
    }
    public void checkingLevel(){
        if(xp >= 100){
            level++;
            xp = -100;
            fullHP += 10;
            statPoints += 3;

            System.out.println("LevelUP : " + level + " | Stat Points : " + statPoints);
        }
    }
}
