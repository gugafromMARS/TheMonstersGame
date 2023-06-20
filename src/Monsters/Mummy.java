package Monsters;

import Supernaturals.SupernaturalType;

public class Mummy extends Monster {

    private int consecutiveAttacks;

    public Mummy() {
        super(SupernaturalType.MUMMY, 15, 75);
    }

    @Override
    public int attack() {
        consecutiveAttacks++;
        if(consecutiveAttacks > 2) {
            System.out.println("I'm unfolding and lost ");
            consecutiveAttacks = 0;
            damageHp(5);
            return 0;
        }
        return super.attack();
    }

    @Override
    public void defend(int attackPower) {
        consecutiveAttacks = 0;
        super.defend(attackPower);
    }
}
