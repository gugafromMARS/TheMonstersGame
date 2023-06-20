package Supernaturals;

public abstract class Supernatural {

    private int attackPower;
    private int health;
    private SupernaturalType type;

    public Supernatural(int attackPower, SupernaturalType type) {
        this.attackPower = attackPower;
        this.type = type;
        this.health = 100;
    }

    public int attack() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public SupernaturalType getType() {
        return type;
    }
}
