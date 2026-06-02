package items;

import characters.Player;

public class Potion extends Item {
    private int hp;
    private int mp;
    private int damage;

    public Potion(String name, int hp, int mp, int damage, int id ,int price) {
        super(id,price,name);
        this.hp = hp;
        this.mp = mp;
        this.damage = damage;

    }



    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Potion{" +
                "hp=" + hp +
                ", mp=" + mp +
                ", damage=" + damage +
                '}';
    }

    public void heal(Player player) {

        int newHealth = player.getHealth() + this.hp;

        player.setHealth(Math.min(newHealth, player.getFullHP()));

        System.out.println(
                "Player "
                        + player.getName()
                        + " heals "
                        + this.hp
                        + " HP | Current HP: "
                        + player.getHealth()
        );
    }
    @Override
    public String getDisplayName() {
        return "Potion :" + getName();
    }
}