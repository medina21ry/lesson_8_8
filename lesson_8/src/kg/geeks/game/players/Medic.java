package kg.geeks.game.players;

import static kg.geeks.game.players.SuperAbility.HEAL;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, String name, int healPoints) {
        super(health, damage, SuperAbility.HEAL, name);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() < 100 && this != heroes[i]) {
                heroes[i].setHealth(heroes[i].getHealth() + this.healPoints);
            }
        }
    }
}
