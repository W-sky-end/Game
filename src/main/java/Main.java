import characters.Monster;
import characters.Player;
import system.Dice;
import factory.MonsterFactory;
import items.Item;
import items.Potion;
import items.Weapon;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //объекты
        Dice dice = new Dice();
        Player player = new Player("Wsky", 100, 5, 1, 1, 0,1,1,1);
        Monster monster = MonsterFactory.createMonster();
        Potion hp = new Potion("HP Potion", 20, 0, 0, 1, 1);
        Weapon sword = new Weapon(3, "Sword", 21, 1);


        //test
        player.getInventory().add(sword);
        player.getInventory().add(hp);
        //меню
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("  \nMenu  ");

            System.out.println("\n1.Battle");
            System.out.println("2.Inventory");
            System.out.println("3.INFO");
            System.out.println("4.Exit");

            System.out.println("\nPlease enter your choice : ");

            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    while (player.getHealth() > 0 && monster.getHealth() > 0) {
                        player.attack(monster);
                        if (monster.getHealth() <= 0) {
                            break;
                        }
                        monster.monsterAttack(player);
                        System.out.println(monster.getName() + " HP|" + monster.getHealth() + " attacked and take "
                                + monster.getDamage() + " damages for " + player.getName());
                        if (player.getHealth() <= 0) {
                            break;
                        }
                    }
                    if (monster.getHealth() <= 0) {
                        System.out.println("Monster is dead");

                        player.setXp(player.getXp() + monster.getXpReward());
                        player.setGold(player.getGold() + monster.getGoldReward());
                        player.checkingLevel();

                        monster = MonsterFactory.createMonster();
                    } else if (player.getHealth() <= 0) {
                        System.out.println("Player is dead");
                    } else System.out.println("Something went wrong");
                    break;
                case 2:
                    System.out.println("\nInventory");
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        System.out.println(i + "." + player.getInventory().get(i).getDisplayName());
                    }
                    System.out.println("Gold :" + player.getGold());

                    System.out.println("\nAny choice ?");
                    System.out.println("1.Equipped something");
                    System.out.println("2.Delete something");
                    System.out.println("3.Exit");

                    int choice2 = sc.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.println("Choose an equipment number (Exe: 0.Sword(3 DMG) peck 0) ");
                            int inventoryChoice = sc.nextInt();

                            if (inventoryChoice < 0 ||
                                    inventoryChoice >= player.getInventory().size()) {
                                System.out.println("Invalid inventory choice");
                                break;
                            }
                            Item selectedItem = player.getInventory().get(inventoryChoice);

                            if (selectedItem instanceof Weapon weapon) {
                                player.equipWeapon(weapon);
                                System.out.println(weapon.getName() + " equipped");
                            }
                            if (selectedItem instanceof Potion potion) {
                                potion.heal(player);
                                player.getInventory().remove(potion);
                                System.out.println(potion.getName() + " healed");
                            }
                            break;
                        case 2:
                            System.out.println("What do ypu want to delete?Choose number.(Exe: 0.Sword(3 DMG) peck 0)");
                            int inventoryChoice2 = sc.nextInt();
                            if (inventoryChoice2 < 0 ||
                                    inventoryChoice2 >= player.getInventory().size()) {
                                System.out.println("Invalid inventory choice");
                                break;
                            }

                            Item itemToRemove =
                                    player.getInventory().get(inventoryChoice2);

                            player.getInventory().remove(itemToRemove);

                            System.out.println(
                                    itemToRemove.getDisplayName() +
                                            " removed"
                            );

                            break;
                        case 3:
                            System.out.println("Back to main menu");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + choice2);
                    }
                    continue;
                case 3:
                    System.out.println("INFO");
                    System.out.println("LVL: " + player.getLevel() + "\nExp: " + player.getXp() + "\nSTR: " + player.getStrength()
                                    + "\nAGI: " + player.getAgility() + "\nVIT: " + player.getVitality() + "\n\nStat Points: " + player.getStatPoints()
                            + "\n"

                            );
                    break;
                case 4:
                    System.out.println("Goodbye");
                    gameRunning = false;
                    sc.close();
                    break;
            }
        }
    }
}
