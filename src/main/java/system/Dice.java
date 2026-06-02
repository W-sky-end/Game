package system;

import java.util.Random;


public class Dice {


    Random rand = new Random();

    public RollResult roll() {
        int roll = rand.nextInt(6) + 1;
        switch (roll) {
            case 1:
                return RollResult.EXCELLENT;
            case 2:
                return RollResult.GOOD;
            case 3:
                return RollResult.SATISFACTORY;
            case 4:
                return RollResult.MEDIOCRE;
            case 5:
                return RollResult.POOR;
            case 6:
                return RollResult.UNSATISFACTORY;
            default:
                return RollResult.UNSATISFACTORY;
        }



    }
}

