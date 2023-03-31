package src.java.Console;

public abstract class Character { // 18/03/23  // 19/03/23  // 20/03/23
    private String name;
    private float health;
    private float healthMax;

    public Character(String name, float health, float healthMax) {
        this.name = name;
        this.health = health;
        this.healthMax = healthMax;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getHealthMax() {
        return healthMax;
    }

    public void getHealthMax(float healthMax) {
        this.healthMax = healthMax;
    }


    public static void attack(Wizard wizard, AbstractEnemy abstractEnemy) {  //le sorcier attaque l'ennemi
        System.out.println("Vous attaquez le" + Levels.opponentName + "avec" + wizard.getWizardKnownSpells().get(Levels));
        Jeu.promptEnterKey();
        abstractEnemy.setHealth(abstractEnemy.getHealth() - wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower);
        System.out.print("");
        Jeu.promptEnterKey();


        //l'ennemi attaque le sorcier

    }
}





