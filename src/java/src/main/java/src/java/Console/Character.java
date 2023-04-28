package src.java.Console;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

public abstract class Character { // 18/03/23  // 19/03/23  // 20/03/23
    private String name;
    private float health;
    private float healthMax;
    private static boolean isTrollExecuted = false;
    private static boolean isBasiliskExecuted = false;
    private static boolean hasFang = false;
    private static boolean isPetterDead = false;
    private static int fireworksAppearExecutedCount = 0;


    public Character(String name, float health, float healthMax) {
        this.name = name;
        this.health = health;
        this.healthMax = healthMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public void setHealthMax(float healthMax) {
        this.healthMax = healthMax;
    }


    public static void attack(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0) {
            int randMiss = (int) (Math.random() * 100) + 0;
            if (randMiss < (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellAccuracy() * wizard.getHouse().getBuffAccuracy())) {
                wizardTurn(wizard, abstractEnemy);
                if (abstractEnemy.getName() == "Troll") {
                    conditionTroll(wizard, abstractEnemy);
                }
                if (abstractEnemy.getName() == "Basilisk") {
                    conditionBasilisk(wizard, abstractEnemy);
                }
                if (abstractEnemy.getName() == "Pettigrow" || abstractEnemy.getName() == "Voldemort") {
                    conditionPetterVoldemort(wizard, abstractEnemy);
                    if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0) {
                        bossTurn(wizard, abstractEnemy);
                    }
                }
                if (abstractEnemy.getName() == "Ombrage") {
                    conditionDolores(wizard, abstractEnemy);
                    if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0) {
                        bossTurn(wizard, abstractEnemy);
                    }
                }
                if (abstractEnemy.getName() == "Death Eater") {
                    conditionDeathEaters(wizard);
                }

                if (abstractEnemy.getName() == "Belatrix" || abstractEnemy.getName() == "Voldemort2") {
                    if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0) {
                        bossTurn(wizard, abstractEnemy);
                    }
                }

                if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0 && abstractEnemy.getName() != "Pettigrow" && abstractEnemy.getName() != "Voldemort" && abstractEnemy.getName() != "Dolores Ombrage" && abstractEnemy.getName() != "Belatrix" && abstractEnemy.getName() != "Voldemort2") {
                    enemyTurn(wizard, abstractEnemy);
                }
            } else {
                System.out.println("\u001B[34mYou miss your attack against " + abstractEnemy.getName() + "!\u001B[0m");
                if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0 && abstractEnemy.getName() != "Pettigrow" && abstractEnemy.getName() != "Voldemort" && abstractEnemy.getName() != "Ombrage" && abstractEnemy.getName() != "Belatrix" && abstractEnemy.getName() != "Voldemort2") {
                    enemyTurn(wizard, abstractEnemy);
                }
                if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0 && abstractEnemy.getName() == "Pettigrow" || abstractEnemy.getName() == "Voldemort" || abstractEnemy.getName() == "Ombrage" || abstractEnemy.getName() == "Belatrix" || abstractEnemy.getName() == "Voldemort2") {
                    bossTurn(wizard, abstractEnemy);
                }
            }
        }
    }

    public static void attackPotion(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0 && abstractEnemy.getName() != "Pettigrow" && abstractEnemy.getName() != "Voldemort" && abstractEnemy.getName() != "Ombrage" && abstractEnemy.getName() != "Belatrix" && abstractEnemy.getName() != "Voldemort2") {
            enemyTurn(wizard, abstractEnemy);
        }
        if (abstractEnemy.getHealth() > 0 && wizard.getHealth() > 0 && abstractEnemy.getName() == "Pettigrow" || abstractEnemy.getName() == "Voldemort" || abstractEnemy.getName() == "Ombrage" || abstractEnemy.getName() == "Belatrix" || abstractEnemy.getName() == "Voldemort2") {
            bossTurn(wizard, abstractEnemy);
        }
    }


    public static String superEffective() {
        String superEffective = "\u001B[31m" + "super effective" + "\u001B[0m";
        return superEffective;
    }

    public static void youDeal(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (abstractEnemy.getName() == "Voldemort2") {
            System.out.println("You deal \u001B[35m" + wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower() * wizard.getHouse().getBuffDamage() + "\u001B[0m damage ! || \u001B[31m \u001B[40m " + "Voldemort : " + abstractEnemy.getHealth() + " / " + abstractEnemy.getHealthMax() + " HP \u001B[0m");
            Jeu.promptEnterKey();
        } else {
            System.out.println("You deal \u001B[35m" + wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower() * wizard.getHouse().getBuffDamage() + "\u001B[0m damage ! || \u001B[31m \u001B[40m " + abstractEnemy.getName() + " : " + abstractEnemy.getHealth() + " / " + abstractEnemy.getHealthMax() + " HP \u001B[0m");
            Jeu.promptEnterKey();
        }
    }

    public static void enemyDeal(Wizard wizard, AbstractEnemy abstractEnemy) {
        System.out.println("The\u001B[31m \u001B[40m " + abstractEnemy.getName() + " \u001B[0m inflicts you \u001B[31m" + abstractEnemy.getOpponentPower() * wizard.getHouse().getReduceDamage() + "\u001B[0m damage ! ||\u001B[32m \u001B[40m " + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m");
    }

    public static void enemyTurn(Wizard wizard, AbstractEnemy abstractEnemy) {
        wizard.setHealth(wizard.getHealth() - abstractEnemy.getOpponentPower() * wizard.getHouse().getReduceDamage());
        if (wizard.getHealth() < 0) {
            wizard.setHealth(0);
        }
        enemyDeal(wizard, abstractEnemy);

        if (wizard.getHouse().getReduceDamage() == 0.5F) {
            System.out.println("You are better able to withstand attacks thanks to the power of Gryffindor !");
        }
        Jeu.promptEnterKey();
    }

    public static void bossTurn(Wizard wizard, AbstractEnemy abstractEnemy) {
        Utilitaires defendYourselfIn10Sec = new Utilitaires();
        int randForbiddenSpell = (int) (Math.random() * 5) + 0;
        int randMissBoss = (int) (Math.random() * 100) + 0;
        if (randForbiddenSpell == 4) {
            if (abstractEnemy.getName() == "Voldemort2" || abstractEnemy.getName() == "Belatrix") {
                if (abstractEnemy.getName() == "Voldemort2") {
                    System.out.println("Voldemort prepare a devastating attack ! Quick, Expelliarmus !");
                } else {
                    System.out.println(abstractEnemy.getName() + " prepare a devastating attack ! Quick, Expelliarmus !");
                }
                Jeu.promptEnterKey();
                defendYourselfIn10Sec.defendYourselfIn10Sec(wizard);
            } else {
                System.out.println(abstractEnemy.getName() + " try to use the ultimate prohibited technique but fail ! (nice)");
            }
        } else {
            if (randMissBoss < (Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellAccuracy())) {
                wizard.setHealth(wizard.getHealth() - abstractEnemy.getOpponentPower() * Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellPower() * wizard.getHouse().getReduceDamage());
                if (wizard.getHealth() < 0) {
                    wizard.setHealth(0);
                }
                if (abstractEnemy.getName() == "Voldemort2") {
                    System.out.println("\u001B[31m\u001B[40m" + "Voldemort\u001B[0m inflicts you \u001B[31m" + abstractEnemy.getOpponentPower() * Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellPower() * wizard.getHouse().getReduceDamage() + "\u001B[0m damage with " + Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellName() + " ||\u001B[32m \u001B[40m " + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m");
                } else {
                    System.out.println("\u001B[31m\u001B[40m" + abstractEnemy.getName() + " \u001B[0m inflicts you \u001B[31m" + abstractEnemy.getOpponentPower() * Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellPower() * wizard.getHouse().getReduceDamage() + "\u001B[0m damage with " + Jeu.forbiddenSpells.get(randForbiddenSpell).getSpellName() + " ||\u001B[32m \u001B[40m " + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m");
                }

                if (wizard.getHouse().getReduceDamage() == 0.5F) {
                    System.out.println("You are better able to withstand attacks thanks to the power of Gryffindor !");
                }
                Jeu.promptEnterKey();
            } else {
                if (abstractEnemy.getName() == "Voldemort2") {
                    System.out.println("Voldemort miss his attack !");
                } else {
                    System.out.println(abstractEnemy.getName() + " miss his attack !");
                }
            }
        }
    }


    public static void wizardTurn(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (abstractEnemy.getHealth() > 0) {
            if (abstractEnemy.getName() == "Voldemort2") {
                System.out.println("You attack Voldemort with " + wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() + ".");
            } else {
                System.out.println("You attack " + abstractEnemy.getName() + " with " + wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() + ".");
            }

            if (wizard.getHouse().getBuffDamage() == 1.5F && wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower() > 0) {
                System.out.println("You deal much more damage thanks to the power of Slytherin !");
            }
            Jeu.promptEnterKey();
            abstractEnemy.setHealth(abstractEnemy.getHealth() - wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower() * wizard.getHouse().getBuffDamage());

            if (abstractEnemy.getHealth() < 0) {
                abstractEnemy.setHealth(0);
            }
            if (hasFang == true && abstractEnemy.getName() == "Basilisk") {
                System.out.println("You stick the Basilisk's fang int the middle of its eye ! It's " + superEffective());
            }
            youDeal(wizard, abstractEnemy);
        }
    }


    public static void conditionTroll(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (!isTrollExecuted) {
            if (abstractEnemy.getName() == "Troll") {
                if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() == "Wingardium Leviosa") {
                    System.out.println("You've levitate the toilet sink, and you throw it at the Troll !");
                    Jeu.promptEnterKey();
                    System.out.println("It was " + superEffective() + " ! \nThe troll is sensitive to Wingardium Leviosa ! You've broken his defense ! ");
                    wizard.getWizardKnownSpells().get(0).setSpellPower(200);
                    String nomSpell0 = wizard.getWizardKnownSpells().get(0).getSpellName();
                    nomSpell0 = nomSpell0.replaceFirst("Wingardium Leviosa", "Wingardium Leviosa : " + superEffective());
                    wizard.getWizardKnownSpells().get(0).setSpellName(nomSpell0);
                }
            }
            isTrollExecuted = true;
        }
    }

    public static void conditionBasilisk(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (!isBasiliskExecuted) {
            //Condition Basilic
            if (abstractEnemy.getName() == "Basilisk") {
                if (wizard.getHouse().getName() == "Slytherin" || wizard.getHouse().getName() == "Hufflepuff" || wizard.getHouse().getName() == "Ravenclaw") {
                    if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() == "Accio") {
                        System.out.println("It's " + superEffective() + "! Thanks to the power of accio's attraction, you tear a fang from the mouth of the Basilisk!");
                        Jeu.promptEnterKey();
                        System.out.println("Find a way to puch the fang directly into the Tom Jedusor's diary... \n" + "... and you will be able to end the life of the creature !");
                        wizard.getWizardKnownSpells().get(2).setSpellPower(abstractEnemy.getHealthMax());
                        hasFang = true;
                        Jeu.promptEnterKey();
                    }
                } else {
                    if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellPower() >= 0) {
                        System.out.println("Meh, apparently " + wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() + " is not very effective on the Basilisk");
                        if (Levels.lastChoiceLvl2 == true) {
                            System.out.println("The Basilisk rush on you, you will die !");
                            Jeu.promptEnterKey();
                            System.out.println("But you manage to turn around and in one switf move, strike a blow with the sword of Gryfindor on the Basilisk !");
                            Jeu.promptEnterKey();
                            System.out.println("It's " + superEffective() + " ! The Basilisk let out a vile groan, and fell dead to the ground...");
                            abstractEnemy.setHealth(0);
                            Jeu.promptEnterKey();
                        }
                    }
                }

            }
            if (Levels.lastChoiceLvl2 == true || wizard.getWizardKnownSpells().get(2).getSpellPower() == abstractEnemy.getHealthMax()) {
                isBasiliskExecuted = true;
            }
        }
    }


    public static void conditionPetterVoldemort(Wizard wizard, AbstractEnemy abstractEnemy) {
        if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() == "Accio") {
            System.out.println("Good job ! With the power of Accio, you are able to reach the Portkey !");
            Jeu.promptEnterKey();
            System.out.println("You run away !");
            abstractEnemy.setHealth(0);
            isPetterDead = true;
        }
    }

    public static boolean getIsPetterDead() {
        return isPetterDead;
    }

    public static void conditionDolores(Wizard wizard, AbstractEnemy abstractEnemy) {
        Spell spellFireworks = new Spell("Fireworks", 0, 100, false, "Let the party begin !");

        if (abstractEnemy.getHealth() <= 4000 && fireworksAppearExecutedCount == 0) {
            wizard.getWizardKnownSpells().add(spellFireworks);
            fireworksAppearExecutedCount++;
        }
        if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() == "Fireworks") {
            System.out.println("You light the fireworks !");
            Jeu.promptEnterKey();
            System.out.println("You scare Dolores Ombrage, who runs away, scared of the death... !");
            abstractEnemy.setHealth(0);
        }
    }

    public static void conditionDeathEaters(Wizard wizard) {
        if (wizard.getWizardKnownSpells().get(Levels.spellUsed).getSpellName() == "Sectumsempra") {
            wizard.getWizardKnownSpells().get(6).setSpellName("Sectumsempra " + superEffective());
            wizard.getWizardKnownSpells().get(6).setSpellPower(240);
            System.out.println("Wow, it sems to be super effective ! Try to use Sectumsempra again !");
        }
    }

}








