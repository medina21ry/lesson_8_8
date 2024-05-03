package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void chooseDefence() {
        SuperAbility[] values = SuperAbility.values();
        int randIndex = RPG_Game.random.nextInt(values.length);
        this.defence = values[randIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0) {
                continue;
            }
            if (heroes[i] instanceof Berserk &&
                    this.getDefence() != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                int coefficient = RPG_Game.random.nextInt(2) + 1; // 1, 2
                ((Berserk) heroes[i]).setBlockedDamage(coefficient * 5);
                heroes[i].setHealth(heroes[i].getHealth() -
                        (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " defence: " + defence;
    }
}
