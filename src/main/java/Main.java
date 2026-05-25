public class Main {
    public static void main(String[] args) {


        Player player = new Player("Wsky",100,5,1,1,0);
        Monster monster = new Monster("Weak Zombie",15,1);
        Potion hp = new Potion("HP Potion",20,0,0);


        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            player.attack(monster);
            System.out.println("Player " + player.getName() +" HP|" + player.getHealth() + " attacked and take "
                    + player.getDamage() + " damages for " + monster.getName());
            if(monster.getHealth() <= 0){
                break;
            }
            monster.monsterAttack(player);
            System.out.println(monster.getName() + " HP|" + monster.getHealth() + " attacked and take "
                    + monster.getDamage() + " damages for " + player.getName());
            if(player.getHealth() <= 0){
                break;
            }
        } if (monster.getHealth() <= 0) {
            System.out.println("Monster is dead");
        }  else if (player.getHealth() <= 0) {
            System.out.println("Player is dead");
        }  else System.out.println("Something went wrong");


        hp.heal(player);



    }
}
