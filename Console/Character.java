package Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public abstract class Character {
    private String name;
    private float health;
    private float healthMax;

    public Character(String name, float health, float healthMax){
        this.name=name;
        this.health=health;
        this.healthMax=healthMax;
    }

    public String getName(){
        return name;
    }
    public void getName(String name){
        this.name = name;
    }

    public float getHealth(){
        return health;
    }
    public void getHealth(float health){
        this.health = health;
    }

    public float getHealthMax(){
        return healthMax;
    }
    public void getHealthMax(float healthMax){
        this.healthMax = healthMax;
    }


    public static void attack(Wizard wizard, AbstractEnemy abstractEnemy){  //le sorcier attaque l'ennemi
        System.out.println("Vous attaquez le" + Levels.opponentName + "avec" + wizard.getWizardKnownSpells().get(Levels));
        Main.promptEnterKey();
        abstractEnemy.setHealth(abstractEnemy.getHealth() - wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower);
        System.out.print("");



        //l'ennemi attaque le sorcier

    }
}





