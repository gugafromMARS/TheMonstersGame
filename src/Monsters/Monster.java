package Monsters;

import Supernaturals.Supernatural;
import Supernaturals.SupernaturalType;

public abstract class Monster extends Supernatural implements Strikeable {

    private int hp;

    public Monster(SupernaturalType monsterType, int attackPower, int hp) {
        super(attackPower, monsterType);
        this.hp = hp;
    }

    public void damageHp(int hp) {
        this.hp -= hp;
    }

    public SupernaturalType getMonsterType() {
        return super.getType();
    }

    public int attack() {
        return super.getAttackPower();
    }

    public void defend(int attackPower) {
        hp -= attackPower;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void restoreHp(int bit) {
        hp += bit;
    }
}
