package factory;

import characters.Monster;

import java.util.Random;

public class MonsterFactory {

    private static final Random rand = new Random();

    public static Monster createMonster() {
        int newMonster = rand.nextInt(5);
        return switch (newMonster) {
            case 0 -> new Monster("Weak Zombie", 30, 5);
            case 1 -> new Monster("Skeleton", 20, 6);
            case 2 -> new Monster("Goblin", 35, 7);
            case 3 -> new Monster("Bandit", 50, 5);
            default -> new Monster("Rat", 10, 1);
        };
    }
}
