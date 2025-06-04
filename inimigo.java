package rpg.model;

public class Inimigo extends Character {
    private int experienceReward;
    private int goldReward;

    public Inimigo (String name, int health, int attack, int defense, int speed,
                 int expReward, int goldReward) {
        super(name, health, attack, defense, speed);
        this.experienceReward = expReward;
        this.goldReward = goldReward;
    }

    @Override
    public String getCharacterClass() {
        return "Inimigo";
    }

    public int attack(Character target) {
        int damage = Math.max(1, attack - target.getDefense() / 2);
        target.takeDamage(damage);
        return damage;
    }

    // Getters
    public int getExperienceReward() { return experienceReward; }
    public int getGoldReward() { return goldReward; }
}