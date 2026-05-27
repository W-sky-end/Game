import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //объекты
        Player player = new Player("Wsky", 100, 5, 1, 1, 0);
        Monster monster = new Monster("Weak Zombie", 15, 1);
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
            System.out.println("3.Exit");

            System.out.println("\nPlease enter your choice : ");

            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    while (player.getHealth() > 0 && monster.getHealth() > 0) {
                        player.attack(monster);
                        System.out.println("Player " + player.getName() + " HP|" + player.getHealth() + " attacked and take "
                                + player.getDamage() + " damages for " + monster.getName());
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
                    } else if (player.getHealth() <= 0) {
                        System.out.println("Player is dead");
                    } else System.out.println("Something went wrong");
                    break;
                case 2:
                    System.out.println("\nInventory");
                    for (Item item : player.getInventory()) {
                        System.out.println(item.getDisplayName());
                    }
                    System.out.println("\nAny choice ?");
                    System.out.println("1.Equipped sword");
                    System.out.println("2.Drink potion");
                    System.out.println("3.Delete something");
                    System.out.println("4.Exit");

                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            player.equipWeapon(sword); // мне пока не нравится так как мы не даем выбор какой меч одеть или даже броню
                            System.out.println("Sword equipped!");
                            break;
                        case 2:
                            hp.heal(player);
                            break;
                        case 3:
                            player.getInventory().remove(sword); // опять же пока что как костыль
                            break;
                        case 4:
                            System.out.println("Back to main menu");
                            break;
                    }
                    continue;
                case 3:
                    System.out.println("Goodbye");
                    gameRunning = false;
                    sc.close();
                    break;
            }
        }


    }
}
