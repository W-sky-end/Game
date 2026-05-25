public class Potion {
    private String name;
    private int hp;
    private int mp;
    private int damage;

    public Potion(String name, int hp, int mp, int damage) {
        this.hp = hp;
        this.name = name;
        this.mp = mp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Potion{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                ", damage=" + damage +
                '}';
    }

    public void heal(Player player) {

        int newHealth = player.getHealth() + this.hp;

        if (newHealth > player.getFullHP()) {

            player.setHealth(player.getFullHP());

        } else {

            player.setHealth(newHealth);
        }

        System.out.println(
                "Player "
                        + player.getName()
                        + " heals "
                        + this.hp
                        + " HP | Current HP: "
                        + player.getHealth()
        );
    }
}