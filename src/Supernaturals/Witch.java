package Supernaturals;

import Monsters.Strikeable;

public class Witch extends Supernatural implements Strikeable {

    public Witch() {
        super(25, SupernaturalType.WITCH);
    }

    @Override
    public void defend(int attackPower) {
        super.setHealth(super.getHealth() - attackPower/2);
    }
}
