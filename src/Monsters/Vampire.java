package Monsters;

import Supernaturals.SupernaturalType;

import java.util.Random;

public class Vampire extends Monster {

    public Vampire() {
        super(SupernaturalType.VAMPIRE,25, 50);
    }

    public void healing(int bit) {
        restoreHp(bit);
    }

    @Override
    public int attack() {
        int bit = new Random().nextInt(0, 100);
        if(bit > 20) {
            healing(20);
        }
        return super.attack();
    }

}
