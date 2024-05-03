package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int cooefficient = RPG_Game.random.nextInt(5) + 2; //2,3,4,5,6
        boss.setHealth(boss.getHealth() - this.getDamage() * cooefficient);
        System.out.println("Warrior " + this.getName() + " hit boss with critical damage "
                + this.getDamage() * cooefficient);
    }
}
