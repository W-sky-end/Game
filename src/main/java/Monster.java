import java.util.Random;

public class Monster {
    private String name;
    private int health;
    private int damage;
    Random rand = new Random();


    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
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
