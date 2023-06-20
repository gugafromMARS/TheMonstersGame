import Monsters.Monster;
import Monsters.Mummy;
import Monsters.Vampire;
import Monsters.Werewolf;

import java.util.Random;

public class Player {

    private String name;
    private Monster[] monsters;
    private Game game;
    private int numMonsters;

    public Player(String name) {
        this.name = name;
        game = null;
    }

    public void enterGame(Game game, int numberOfMonsters) {
        this.game = game;
        game.addPlayer(this);
        monsters = new Monster[numberOfMonsters];
        this.numMonsters = numberOfMonsters;
        chooseMonsters();
    }

    public String getName() {
        return name;
    }

    public void chooseMonsters() {
        if(game == null) {
            System.out.println("U must enter a game first");
            return;
        }
            for (int i = 0; i < numMonsters; i++) {
                int chooseMonster = new Random().nextInt(1, 4);
                switch (chooseMonster) {
                    default:
                        monsters[i] = new Werewolf();
                        break;
                    case 2:
                        monsters[i] = new Vampire();
                        break;
                    case 3:
                        monsters[i] = new Mummy();
                        break;
                };
            }

    }


    public int attack() {
        Monster monster = chooseMonsterToPlay();
        if(monster == null) {
            return 0;
        }
        System.out.println("Player " + name + " is attacking with " + monster.getMonsterType());
        return monster.attack();
    }

    public void defend(int attack) {
        Monster monster = chooseMonsterToPlay();
        if(monster == null) {
            return;
        }
        System.out.println("Player "+ name + " is defending with monster " + monster.getMonsterType());
        monster.defend(attack);
        if(monster.isDead()) {
            removeMonster(monster);
        }
    }

    private void removeMonster(Monster monster) {
        for(int i = 0; i < monsters.length; i++) {  //{m1,m2,"m3",m4}   {m1,m2, }
            if(monsters[i] == monster) {
                System.out.println("Monster " + monster.getMonsterType() + " is dead");
                for(int j = i + 1; j < numMonsters; j++) {
                    monsters[j - 1] = monsters[j];
                }
                monsters[numMonsters - 1] = null;
                numMonsters--;
                return;
            }
        }

    }


    public Monster chooseMonsterToPlay() {
        if(canPlay()) {
            int r = new Random().nextInt(0, numMonsters);
            Monster monster = monsters[r];
            if(monster == null) {
                return chooseMonsterToPlay();
            }
            return monster;
        }
        return null;
    }

    public boolean canPlay() {
        return numMonsters > 0;
    }

}
