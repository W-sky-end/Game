public class Weapon extends Item {
    private int damage;


    public Weapon(int damage, String name, int id, int price) {
        super(id, price, name);
        this.damage = damage;
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
                "Weapon{" +
                "damage=" + damage +
                '}';
    }
    @Override
    public String getDisplayName() {
        return getName() + " (" + damage + " DMG)";
    }
}
