package src.java.Console;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> wizardKnownSpells;
    private List<Potion> potions;

    public Wizard(String name, Pet pet, Wand wand, House house, Spell spell, Potion potion) {
        super(name, 1000, 1000);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.wizardKnownSpells = new ArrayList<Spell>();
        this.potions = new ArrayList<Potion>();
        potions.add(potion);
        wizardKnownSpells.add(spell);
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public void addSpell(Spell spell) {
        wizardKnownSpells.add(spell);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getWizardKnownSpells() {
        return wizardKnownSpells;
    }

    public void setWizardKnownSpells(List<Spell> WizardKnownSpells) {
        this.wizardKnownSpells = WizardKnownSpells;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }


    public static void defend(Wizard wizard, Boss boss) {
        System.out.println("You will prepare to defend yourself !");
        int randForbiddenSpell = (int) (Math.random() * 4) + 0;
        int randMissBoss = (int) (Math.random() * 100) + 0;
        if (boss.getHealth() > 0 && wizard.getHealth() > 0) {
            if (randMissBoss < (Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellAccuracy())) {
                if (wizard.getHealth() < 0) {
                    wizard.setHealth(0);
                }
                System.out.println("\u001B[31m\u001B[40m" + boss.getName() + " \u001B[0m inflicts you \u001B[31m" + (boss.getOpponentPower() * Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellPower() * wizard.getHouse().getReduceDamage()) * 0 + "\u001B[0m damage with " + Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellName() + " ||\u001B[32m \u001B[40m " + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m");
                System.out.println("You protect yourself !");
                Jeu.promptEnterKey();
            } else {
                System.out.println(boss.getName() + " miss his attack !");
            }
        }
    }
}