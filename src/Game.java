import Supernaturals.Fairy;
import Supernaturals.Supernatural;
import Supernaturals.SupernaturalType;
import Supernaturals.Witch;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private int rounds;

    public Game() {
        this.player1 = null;
        this.player2 = null;
        System.out.println("Game started!");
    }

    public int config() {
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        System.out.println("How many monsters you want to play?");
        input = scanner.nextInt();
        if(input > 0 && input <= 10) {
            return input;
        }

        System.out.println("You cant play with that number of monsters, try between 1 and 10!");
        return config();
    }

    public void addPlayer(Player player) {
        if(player1 == null) {
            player1 = player;
            return;
        }
        if(player2 == null) {
            player2 = player;
            return;
        }
        System.out.println("We don't have slot for another player!");
    }



    private boolean round() {
        System.out.println("Round " + (++rounds) + " started!");
        if(isObstacle()){
            System.out.println("PLAYERS AGAINST OBSTACLE!");
            Supernatural obstacle = chooseObstacle();


            if(obstacle.getType() == SupernaturalType.FAIRY) {
                System.out.println(player1.getName() + " is defending against " + obstacle.getType());
                player1.defend(obstacle.attack());
                if(isDead(player1)) {
                    System.out.println(player1.getName() + " lost!");
                    return true;
                }
                System.out.println(player2.getName() + " is defending against " + obstacle.getType());
                player2.defend(obstacle.attack());
                if(isDead(player2)) {
                    System.out.println(player2.getName() + " lost!");
                    return true;
                }
                return false;
            }

            if(obstacle.getType() == SupernaturalType.WITCH) {

                System.out.println(player1.getName() + " is defending against " + obstacle.getType());
                player1.defend(obstacle.attack());
                if(isDead(player1)) {
                    System.out.println(player1.getName() + " lost!");
                    return true;
                }
                if(obstacle instanceof Witch) {
                    System.out.println(obstacle.getType() + " is defending against " + player1.getName());
                    ((Witch) obstacle).defend(player1.attack());
                }
                if(isObstacleDead(obstacle)) {
                    System.out.println(player1.getName() + " killed " + obstacle.getType() + "!");
                    return false;
                }

                System.out.println(player2.getName() + " is defending against " + obstacle.getType());
                player2.defend(obstacle.attack());
                if(isDead(player2)) {
                    System.out.println(player2.getName() + " lost!");
                    return true;
                }
                if(obstacle instanceof Witch) {
                    System.out.println(obstacle.getType() + " is defending against " + player2.getName());
                    ((Witch) obstacle).defend(player2.attack());
                }
                if(isObstacleDead(obstacle)) {
                    System.out.println(player2.getName() + " killed " + obstacle.getType() + "!");
                    return false;
                }
            }
            return false;
        }
        if(!isObstacle()) {
            player1.defend(player2.attack());
            if (isDead(player1)) {
                System.out.println(player1.getName() + " lost!");
                return true;
            }
            player2.defend(player1.attack());
            if (isDead(player2)) {
                System.out.println(player2.getName() + " lost!");
                return true;
            }
        }
        return false;
    }


    private boolean isObstacle() {
        int probability = new Random().nextInt(0, 100);
        return probability >= 50;
    }

    private Supernatural chooseObstacle() {
        Supernatural obstacle;
        int r = new Random().nextInt(0, 2);
         switch (r) {
            default -> obstacle = new Fairy();
            case 1 -> obstacle = new Witch();
       };
        return obstacle;
    }

    private boolean isDead(Player player) {
        return !player.canPlay();
    }

    private boolean isObstacleDead(Supernatural obstacle) {
        return obstacle.getHealth() <= 0;
    }

    public void start() {
        boolean isEnded = false;
        while(!isEnded) {
            isEnded = round();
        }
    }


}
