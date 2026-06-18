package characters;

import java.util.Random;

public class Monster {
    private String name;
    private int health;
    private int damage;
    Random rand = new Random();
    private int goldReward;
    private int xpReward;


    public Monster(String name, int health, int damage, int goldReward, int xpReward) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.goldReward = goldReward;
        this.xpReward = xpReward;
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
        return damage + rand.nextInt(3);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getGoldReward() {
        return goldReward;
    }
    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }
    public int getXpReward() {
        return xpReward;
    }
    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }


    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }

    public void monsterAttack(Player player) {

        int finalDamage = getDamage();

        player.setHealth(
                player.getHealth() - finalDamage);
    }
}
