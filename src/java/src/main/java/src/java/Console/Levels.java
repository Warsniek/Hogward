package src.java.Console;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;


public class Levels {
    public static int spellUsed;
    public static int potionConsommee;
    public static boolean lastChoiceLvl2 = false;
    //public static float opponentPower;

    public void Level1(Wizard wizard, List<Enemy> enemies, List<Potion> potions) {
        //float opponentPower = enemies.get(0).getOpponentPower();

        System.out.println("Vous entrez dans les toilettes");
        Jeu.promptEnterKey();
        System.out.println("Soudain, un gros Troll des montagnes adultes apparaît en face de vous !! Il se met à vous attaquer");
        Jeu.promptEnterKey();
        wizard.getWizardKnownSpells().get(1).setSpellPower(0);

        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + enemies.get(0).getName() + " : " + enemies.get(0).getHealth() + " / " + enemies.get(0).getHealthMax() + " HP \u001B[0m\n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2 ou 3 ?");

            try {
                int menu = scanner.nextInt();
                if (menu == 3) {
                    System.out.println("Vous décidez d'abandonner le combat et de laisser le Troll ravager Poudlard...");
                    Jeu.promptEnterKey();
                    System.out.println("Êtes-vous vraiment sûr ? Y/N");
                    scanner = new Scanner(System.in);
                    String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("y")) {
                        System.out.println("you're dumb");
                        Jeu.promptEnterKey();
                        System.out.println("GAME OVER");
                        System.exit(0);
                    } else if (menu3.equalsIgnoreCase("n")) {
                        System.out.println("Vous êtes raisonnable...");
                    } else {
                        System.out.println("Veuillez écrire le bon caractère");
                    }
                } else if (menu == 2) {
                    if (wizard.getHealth() < 1000) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Quelle potion voulez-vous boire ?");
                            Jeu.potionInventory(wizard);
                            try {
                                int potionConsommee = scanner.nextInt();
                                if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                    System.out.println("Vous buvez une " + wizard.getPotions().get(potionConsommee).getPotionName());
                                    Jeu.promptEnterKey();
                                    System.out.println("Vous vous soignez de " + wizard.getPotions().get(potionConsommee).getPotionValue() + " points de vie !");
                                    if (wizard.getHouse().getBuffPotion() > 1) {
                                        System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                    }
                                    Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                    wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                    Jeu.promptEnterKey();
                                    System.out.println("Vous avez maintenant " + wizard.getHealth() + " / " + wizard.getHealthMax());
                                    Character.attackPotion(wizard, enemies.get(0));

                                } else {
                                    System.out.println("Veuillez sélectionner une valeur correcte");
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez sélectionner une valeur correcte");
                            }
                        } else {
                            System.out.println("Vous n'avez plus de potions !");
                        }
                    } else {
                        System.out.println("Votre santé est déjà pleine !!");
                    }
                } else if (menu == 1) {
                    System.out.println("Quel sort voulez-vous lancer ?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, enemies.get(0));
                            //Game.promptEnterKey();
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value2.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while (enemies.get(0).getHealth() > 0 && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        }

        if (enemies.get(0).getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated the troll!");
            Jeu.promptEnterKey();
            System.out.println("The Troll has drop a potion...");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }
    }

    public void Level2(Wizard wizard, List<Enemy> enemies, List<Potion> potions) {
        System.out.println("Vous vous rendez encore une fois au toilettes (décidement), cette fois-ci pour ***** le bucket KFC commandé par UberEat (code partenaire : HarryPotter2023)");
        Jeu.promptEnterKey();
        System.out.println("Soudain, un passage une trappe dérobée sur le sol s'ouvre ! Vous entrez dans ce passage secret...");
        Jeu.promptEnterKey();
        System.out.println("Vous arrivez dans une grande salle, humide... Deux grands bassins d'eau se trouvent de part en part de la salle.");
        Jeu.promptEnterKey();
        System.out.println("BRRRRRRRRRRRR BBBBBMMMMMH !!!!!");
        Jeu.promptEnterKey();
        System.out.println("Un bruit assourdissant se fait entendre");
        Jeu.promptEnterKey();
        System.out.println("A peine avez-vous eu le temps de réagir qu'une immense créature surgit du fin-fond des égouts !");
        Jeu.promptEnterKey();
        System.out.println("Vous le reconnaissez. C'est le Basilic ! Vous devez agir, sinon, c'est la mort qui vous attend.");
        Jeu.promptEnterKey();

        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + enemies.get(1).getName() + " : " + enemies.get(1).getHealth() + " / " + enemies.get(1).getHealthMax() + " HP \u001B[0m\n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2 ou 3 ?");

            try {
                int menu = scanner.nextInt();
                if (menu == 3) {
                    if (wizard.getHouse().getReduceDamage() == 1) {
                        System.out.println("Si vous abandonnez maintenant, une mort certaine vous attend...");
                        Jeu.promptEnterKey();
                        System.out.println("Êtes-vous vraiment sûr de vouloir abandonner ? Y/N");
                        scanner = new Scanner(System.in);
                        String menu3 = scanner.nextLine();
                        if (menu3.equalsIgnoreCase("y")) {
                            System.out.println("Vous êtes une grosse merde");
                            Jeu.promptEnterKey();
                            System.out.println("GAME OVER");
                            System.exit(0);
                        } else if (menu3.equalsIgnoreCase("n")) {
                            System.out.println("Vous décidez de prendre votre courage à deux mains");
                        } else {
                            System.out.println("Veuillez écrire le bon caractère");
                        }
                    } else {
                        System.out.println("Si vous abandonnez maintenant, une mort certaine vous attend...");
                        Jeu.promptEnterKey();
                        System.out.println("Êtes-vous vraiment sûr de vouloir abandonner ? Y/N/G");
                        scanner = new Scanner(System.in);
                        String menu3 = scanner.nextLine();
                        if (menu3.equalsIgnoreCase("y")) {
                            System.out.println("Vous êtes une grosse merde");
                            Jeu.promptEnterKey();
                            System.out.println("GAME OVER");
                            System.exit(0);
                        } else if (menu3.equalsIgnoreCase("n")) {
                            System.out.println("Vous décidez de prendre votre courage à deux mains");
                        } else if (menu3.equalsIgnoreCase("g")) {
                            lastChoiceLvl2 = true;
                            System.out.println("You were about to run away, but the Sorting Hat appeared and dropped a sword...");
                            System.out.println("It's the\u001B[34m sword of Grynfondor \u001B[0m!!");
                            Jeu.promptEnterKey();
                        } else {
                            System.out.println("Veuillez écrire le bon caractère");
                        }
                    }

                } else if (menu == 2) {
                    if (wizard.getHealth() < 1000) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Quelle potion voulez-vous boire ?");
                            Jeu.potionInventory(wizard);
                            try {
                                int potionConsommee = scanner.nextInt();
                                if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                    System.out.println("Vous buvez une " + wizard.getPotions().get(potionConsommee).getPotionName());
                                    Jeu.promptEnterKey();
                                    System.out.println("Vous vous soignez de " + wizard.getPotions().get(potionConsommee).getPotionValue() + " points de vie !");
                                    if (wizard.getHouse().getBuffPotion() > 1) {
                                        System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                    }
                                    Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                    wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                    Jeu.promptEnterKey();
                                    System.out.println("Vous avez maintenant " + wizard.getHealth() + " / " + wizard.getHealthMax());
                                    Character.attackPotion(wizard, enemies.get(1));

                                } else {
                                    System.out.println("Veuillez sélectionner une valeur correcte");
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez sélectionner une valeur correcte");
                            }
                        } else {
                            System.out.println("Vous n'avez plus de potions !");
                        }
                    } else {
                        System.out.println("Votre santé est déjà pleine !!");
                    }
                } else if (menu == 1) {
                    System.out.println("Quel sort voulez-vous lancer ?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, enemies.get(1));
                            //Game.promptEnterKey();
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while (enemies.get(1).getHealth() > 0 && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        }

        if (enemies.get(1).getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated the Basilisk !");
            Jeu.promptEnterKey();
            System.out.println("The Basilisk has drop a potion !");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Professor Dumbledore, then you go to bed.");
        }
    }

    public void Level3(Wizard wizard, List<Enemy> enemies, List<Potion> potions) {
        Utilitaires castExpectoPatronumIn10Sec = new Utilitaires();
        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + enemies.get(2).getName() + " : " + enemies.get(2).getHealth() + " / " + enemies.get(2).getHealthMax() + " HP \u001B[0m\n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2 ou 3 ?");

            try {
                int menu = scanner.nextInt();
                if (menu == 3) {
                    System.out.println("You decide to give up and let the Dementors suck in your soul...");
                    Jeu.promptEnterKey();
                    System.out.println("Are you really sure ? Y/N");
                    scanner = new Scanner(System.in);
                    String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("y")) {
                        System.out.println("You're dumb");
                        Jeu.promptEnterKey();
                        System.out.println("GAME OVER");
                        System.exit(0);
                    } else if (menu3.equalsIgnoreCase("n")) {
                        System.out.println("good idea...");
                    } else {
                        System.out.println("Please, try again");
                    }
                } else if (menu == 2) {
                    if (wizard.getHealth() < 1000) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Your blood is so cold that you can't even open your bag to get a potion !");
                        }
                    } else {
                        System.out.println("You're health is at max !!");
                    }
                } else if (menu == 1) {
                    System.out.println("Choose your spell ?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, enemies.get(2));
                            //Game.promptEnterKey();
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value2.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while (enemies.get(2).getHealth() > 0 && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("Before you die, you remember one last time about your father and your mother... ");
            Jeu.promptEnterKey();
            System.out.println("Suddenly, an image appear clearly in your head : it's a magnificent deer !");
            Jeu.promptEnterKey();
            System.out.println("Without thinking, you caster in an overpowering way the spell Expecto Patronus");
            Jeu.promptEnterKey();
            System.out.println("\033[3mCast \"Expecto Patronus\" in the 10 sec, or you will die !\033[0m");
            Jeu.promptEnterKey();
            castExpectoPatronumIn10Sec.castExpectoPatronumIn10Sec();
            //Utilitaires.castExpectoPatronumIn10Sec();
            System.out.println("Congratulation, you've defeated the Dementors!");
            Jeu.promptEnterKey();
            System.out.println("The Dementors has drop a potion...");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }

        if (enemies.get(2).getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated the Dementors!");
            Jeu.promptEnterKey();
            System.out.println("The Dementors has drop a potion...");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }
    }

    public void Level4(Wizard wizard, List<Potion> potions) {
        System.out.println("The events of the Goblet of Fire led you directly to a strange place... The atmosphere is unhealthy... ");
        Jeu.promptEnterKey();
        System.out.println("You soon realise that you have fallen into a trap, and Petter Pettigrow and Voldemor are there to greet you ! ");
        Jeu.promptEnterKey();

        Boss boss1 = new Boss("Peter Pettigrow", 2000, 2000, 1, null, null);
        for (int i = 0; i < 4; i++) {
            boss1.addForbiddenSpell(Jeu.forbiddenSpells.get(i));
        }
        Boss boss2 = new Boss("Voldemort", 3000, 3000, 1.2F, null, null);
        for (int i = 0; i < 4; i++) {
            boss2.addForbiddenSpell(Jeu.forbiddenSpells.get(i));
        }

        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + boss1.getName() + " : " + boss1.getHealth() + " / " + boss1.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + boss2.getName() + " : " + boss2.getHealth() + " / " + boss2.getHealthMax() + " HP \u001B[0m \n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche \n" + "[4] Defend yourself");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2, 3 ou 4 ?");

            try {
                int menu = scanner.nextInt();
                if (menu == 4) {
                    Wizard.defend(wizard, boss1);
                    Wizard.defend(wizard, boss2);
                } else if (menu == 3) {
                    System.out.println("Do you really want to give up the fight ?");
                    Jeu.promptEnterKey();
                    System.out.println("Are you sure ? Y/N");
                    scanner = new Scanner(System.in);
                    String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("y")) {
                        System.out.println("You're a piece of crap");
                        Jeu.promptEnterKey();
                        System.out.println("GAME OVER");
                        System.exit(0);
                    } else if (menu3.equalsIgnoreCase("n")) {
                        System.out.println("You are a reasonable person...");
                    } else {
                        System.out.println("Please write the correct character");
                    }
                } else if (menu == 2) {
                    if (wizard.getHealth() < wizard.getHealthMax()) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Which potion would you like to drink ?");
                            Jeu.potionInventory(wizard);
                            try {
                                int potionConsommee = scanner.nextInt();
                                if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                    System.out.println("You drink a " + wizard.getPotions().get(potionConsommee).getPotionName());
                                    Jeu.promptEnterKey();
                                    System.out.println("You heal yourself of " + wizard.getPotions().get(potionConsommee).getPotionValue() + " HP !");
                                    if (wizard.getHouse().getBuffPotion() > 1) {
                                        System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                    }
                                    Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                    wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                    Jeu.promptEnterKey();
                                    System.out.println("Now you have " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP");
                                    Character.attackPotion(wizard, boss1);
                                    Character.attackPotion(wizard, boss2);

                                } else {
                                    System.out.println("Please select a correct value.");
                                }
                            } catch (Exception e) {
                                System.out.println("Please select a correct value.");
                            }
                        } else {
                            System.out.println("You are out of potions!");
                        }
                    } else {
                        System.out.println("Your health is already full !");
                    }
                } else if (menu == 1) {
                    System.out.println("What spell do you want to cast?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, boss1);
                            boolean myVariableValue = Character.getIsPetterDead();
                            System.out.println(myVariableValue);
                            if (!Character.getIsPetterDead()) {
                                Character.attack(wizard, boss2);
                            }
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value2.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while (boss1.getHealth() > 0 && boss2.getHealth() > 0 && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        }

        if (boss1.getHealth() <= 0 || boss2.getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated Petter Pettigrow and Voldemort !");
            Jeu.promptEnterKey();
            System.out.println("You gain a legendary healing potion !");
            wizard.addPotion(potions.get(4));
            Jeu.potionInventory(wizard);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }
    }

    public void Level5(Wizard wizard, List<Potion> potions) {

        System.out.println("Now you face the terrible \"professor\" Dolores Ombrage ");
        Jeu.promptEnterKey();
        System.out.println("You must put an end to his actions within Hogwards");
        Jeu.promptEnterKey();
        Boss boss3 = new Boss("Dolores Ombrage", 5000, 5000, 1, null, null);
        for (int i = 0; i < 4; i++) {
            boss3.addForbiddenSpell(Jeu.forbiddenSpells.get(i));
        }
        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + boss3.getName() + " : " + boss3.getHealth() + " / " + boss3.getHealthMax() + " HP \u001B[0m \n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche \n" + "[4] Defend yourself");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2, 3 ou 4 ?");

            try {
                int menu = scanner.nextInt();
                if (menu == 4) {
                    Wizard.defend(wizard, boss3);
                } else if (menu == 3) {
                    System.out.println("Do you really want to give up the fight ?");
                    Jeu.promptEnterKey();
                    System.out.println("Are you sure ? Y/N");
                    scanner = new Scanner(System.in);
                    String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("y")) {
                        System.out.println("You're a piece of crap");
                        Jeu.promptEnterKey();
                        System.out.println("GAME OVER");
                        System.exit(0);
                    } else if (menu3.equalsIgnoreCase("n")) {
                        System.out.println("You are a reasonable person...");
                    } else {
                        System.out.println("Please write the correct character");
                    }
                } else if (menu == 2) {
                    if (wizard.getHealth() < 1000) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Which potion would you like to drink ?");
                            Jeu.potionInventory(wizard);
                            try {
                                int potionConsommee = scanner.nextInt();
                                if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                    System.out.println("You drink a " + wizard.getPotions().get(potionConsommee).getPotionName());
                                    Jeu.promptEnterKey();
                                    System.out.println("You heal yourself of " + wizard.getPotions().get(potionConsommee).getPotionValue() + " HP !");
                                    if (wizard.getHouse().getBuffPotion() > 1) {
                                        System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                    }
                                    Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                    wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                    Jeu.promptEnterKey();
                                    System.out.println("Now you have " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP");
                                    Character.attackPotion(wizard, boss3);

                                } else {
                                    System.out.println("Please select a correct value.");
                                }
                            } catch (Exception e) {
                                System.out.println("Please select a correct value.");
                            }
                        } else {
                            System.out.println("You are out of potions!");
                        }
                    } else {
                        System.out.println("Your health is already full !");
                    }
                } else if (menu == 1) {
                    System.out.println("What spell do you want to cast?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, boss3);
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value2.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while (boss3.getHealth() > 0 && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        }

        if (boss3.getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated Dolores Ombrage !");
            Jeu.promptEnterKey();
            System.out.println("In her flight, she dropped a potion !");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }
    }

    public void Level6(Wizard wizard, List<Potion> potions) {

        System.out.println("You must eliminate the Death Eaters who have tried to invade Hogwards ! ");
        Jeu.promptEnterKey();

        List<Enemy> deathEaters = new ArrayList<Enemy>();
        Enemy deathEater1 = new Enemy("Death Eater", 100, 100, 50);
        Enemy deathEater2 = new Enemy("Death Eater", 200, 200, 100);
        Enemy deathEater3 = new Enemy("Death Eater", 400, 400, 150);
        Enemy deathEater4 = new Enemy("Death Eater", 800, 800, 150);
        deathEaters.add(deathEater1);
        deathEaters.add(deathEater2);
        deathEaters.add(deathEater3);
        deathEaters.add(deathEater4);

        for (int i = 0; i < deathEaters.size(); i++) {
            Enemy currentDeathEater = deathEaters.get(i);
            do {
                if (wizard.getHouse().getName() != "Slytherin") {
                    System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + currentDeathEater.getName() + " : " + currentDeathEater.getHealth() + " / " + currentDeathEater.getHealthMax() + " HP \u001B[0m \n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche \n");
                    System.out.println("Que voulez-vous faire ? 1, 2 ou 3 ?");
                }
                if (wizard.getHouse().getName() == "Slytherin") {
                    System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + currentDeathEater.getName() + " : " + currentDeathEater.getHealth() + " / " + currentDeathEater.getHealthMax() + " HP \u001B[0m \n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche \n" + "[4] Ally yourself with the forces of evil\n");
                    System.out.println("Que voulez-vous faire ? 1, 2, 3 ou 4 ?");
                }

                try {
                    Scanner scanner = new Scanner(System.in);
                    int menu = scanner.nextInt();
                    if (menu == 4 && wizard.getHouse().getName() == "Slytherin") {
                        System.out.println("Do you really want to join the force of evil ? (This choice is irrevocable and will end your adventure) Y/N");
                        scanner = new Scanner(System.in);
                        String menu4 = scanner.nextLine();
                        if (menu4.equalsIgnoreCase("y")) {
                            System.out.println("You've chosen your side...");
                            Jeu.promptEnterKey();
                            System.out.println("GAME OVER");
                            System.exit(0);
                        } else if (menu4.equalsIgnoreCase("n")) {
                            System.out.println("You think of your loved ones first rather than yourself");
                        } else {
                            System.out.println("Please write the correct character");
                        }

                    }
                    if (menu == 3) {
                        System.out.println("Do you really want to give up the fight ?");
                        Jeu.promptEnterKey();
                        System.out.println("Are you sure ? Y/N");
                        scanner = new Scanner(System.in);
                        String menu3 = scanner.nextLine();
                        if (menu3.equalsIgnoreCase("y")) {
                            System.out.println("You're a piece of crap");
                            Jeu.promptEnterKey();
                            System.out.println("GAME OVER");
                            System.exit(0);
                        } else if (menu3.equalsIgnoreCase("n")) {
                            System.out.println("You are a reasonable person...");
                        } else {
                            System.out.println("Please write the correct character");
                        }
                    } else if (menu == 2) {
                        if (wizard.getHealth() < 1000) {
                            if (wizard.getPotions().size() > 0) {
                                System.out.println("Which potion would you like to drink ?");
                                Jeu.potionInventory(wizard);
                                try {
                                    int potionConsommee = scanner.nextInt();
                                    if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                        System.out.println("You drink a " + wizard.getPotions().get(potionConsommee).getPotionName());
                                        Jeu.promptEnterKey();
                                        System.out.println("You heal yourself of " + wizard.getPotions().get(potionConsommee).getPotionValue() + " HP !");
                                        if (wizard.getHouse().getBuffPotion() > 1) {
                                            System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                        }
                                        Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                        wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                        Jeu.promptEnterKey();
                                        System.out.println("Now you have " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP");
                                        Character.attackPotion(wizard, currentDeathEater);

                                    } else {
                                        System.out.println("Please select a correct value.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please select a correct value.");
                                }
                            } else {
                                System.out.println("You are out of potions!");
                            }
                        } else {
                            System.out.println("Your health is already full !");
                        }
                    } else if (menu == 1) {
                        System.out.println("What spell do you want to cast?");
                        Jeu.spellArsenal(wizard);
                        try {
                            spellUsed = scanner.nextInt();
                            if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                                Character.attack(wizard, currentDeathEater);
                            } else {
                                System.out.println("Please select a correct value.");
                            }
                        } catch (Exception e) {
                            System.out.println("Please select a correct value2.");
                        }
                    } else {
                        System.out.println("Please select a correct value.");
                    }
                } catch (Exception e) {
                    System.out.println("Please select a correct value.");
                }
                if (currentDeathEater.getHealth() <= 0) {
                    System.out.println("Congratulation, you've defeated a Death Eater !");
                    Jeu.promptEnterKey();
                }
            } while (currentDeathEater.getHealth() > 0 && wizard.getHealth() > 0);
            System.out.println("Remaing : " + (4 - (i + 1)) + "/4");
            Jeu.promptEnterKey();
        }


        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        } else {
            System.out.println("Congratulation, you've all defeated Death Eaters !");
            Jeu.promptEnterKey();
            System.out.println("You find a healing potion !");
            Jeu.randomPotion(wizard, potions);
            Jeu.promptEnterKey();
            System.out.println("You hurry to take the facts back to Albus, then you go to bed.");
        }
    }

    public void Level7(Wizard wizard, List<Potion> potions) {

        System.out.println("This is the time for the final battle.");
        Jeu.promptEnterKey();
        System.out.println("Voldemort is here to completly destroy Hogwards");
        Jeu.promptEnterKey();
        System.out.println("You need to stop him, otherwise it will be the end of Hogwards");
        Jeu.promptEnterKey();
        Boss boss4 = new Boss("Belatrix", 2500, 2500, 1, null, null);
        for (int i = 0; i < 5; i++) {
            boss4.addForbiddenSpell(Jeu.forbiddenSpells.get(i));
        }
        Wand wandVoldemort = new Wand(Core.PHOENIX_FEATHER, 35);
        Boss boss5 = new Boss("Voldemort2", 4000, 4000, 1, null, null);
        for (int i = 0; i < 5; i++) {
            boss5.addForbiddenSpell(Jeu.forbiddenSpells.get(i));
        }
        do {
            System.out.println("COMBAT \n\u001B[32m" + wizard.getName() + " : " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + boss4.getName() + " : " + boss4.getHealth() + " / " + boss4.getHealthMax() + " HP \u001B[0m \n\u001B[31m" + "Voldemort" + " : " + boss5.getHealth() + " / " + boss5.getHealthMax() + " HP \u001B[0m \n" + "[1] Lancer un sort \n" + "[2] Boire une potion \n" + "[3] Fuire comme un lâche \n" + "[4] Defend yourself");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que voulez-vous faire ? 1, 2, 3 ou 4 ?");
            try {
                int menu = scanner.nextInt();
                if (menu == 4) {
                    Wizard.defend(wizard, boss4);
                    Wizard.defend(wizard, boss5);
                } else if (menu == 3) {
                    System.out.println("Do you really want to give up the fight ?");
                    Jeu.promptEnterKey();
                    System.out.println("Are you sure ? Y/N");
                    scanner = new Scanner(System.in);
                    String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("y")) {
                        System.out.println("You're a piece of crap");
                        Jeu.promptEnterKey();
                        System.out.println("GAME OVER");
                        System.exit(0);
                    } else if (menu3.equalsIgnoreCase("n")) {
                        System.out.println("You are a reasonable person...");
                    } else {
                        System.out.println("Please write the correct character");
                    }
                } else if (menu == 2) {
                    if (wizard.getHealth() < wizard.getHealthMax()) {
                        if (wizard.getPotions().size() > 0) {
                            System.out.println("Which potion would you like to drink ?");
                            Jeu.potionInventory(wizard);
                            try {
                                int potionConsommee = scanner.nextInt();
                                if (potionConsommee >= 0 && potionConsommee <= wizard.getPotions().size()) {
                                    System.out.println("You drink a " + wizard.getPotions().get(potionConsommee).getPotionName());
                                    Jeu.promptEnterKey();
                                    System.out.println("You heal yourself of " + wizard.getPotions().get(potionConsommee).getPotionValue() + " HP !");
                                    if (wizard.getHouse().getBuffPotion() > 1) {
                                        System.out.println("You restore more HP thanks to the power of the Hupplepuff's house !");
                                    }
                                    Potion.drinkPotion(wizard, wizard.getPotions().get(potionConsommee).getPotionValue());
                                    wizard.getPotions().remove(wizard.getPotions().get(potionConsommee));
                                    Jeu.promptEnterKey();
                                    System.out.println("Now you have " + wizard.getHealth() + " / " + wizard.getHealthMax() + " HP");
                                    Character.attackPotion(wizard, boss4);
                                    Character.attackPotion(wizard, boss5);

                                } else {
                                    System.out.println("Please select a correct value.");
                                }
                            } catch (Exception e) {
                                System.out.println("Please select a correct value.");
                            }
                        } else {
                            System.out.println("You are out of potions!");
                        }
                    } else {
                        System.out.println("Your health is already full !");
                    }
                } else if (menu == 1) {
                    System.out.println("What spell do you want to cast?");
                    Jeu.spellArsenal(wizard);
                    try {
                        spellUsed = scanner.nextInt();
                        if (spellUsed >= 0 && spellUsed <= wizard.getWizardKnownSpells().size()) {
                            Character.attack(wizard, boss4);
                            Character.attack(wizard, boss5);
                            if (wizard.getWand().getCore() == boss5.getWand().getCore()) {
                                Jeu.promptEnterKey();
                                int reflectionDamage = (int) (Math.random() * 2) + 0;
                                if (reflectionDamage == 0) {
                                    System.out.println("Your wand act strangly, same for the Voldemort's one !");
                                    Jeu.promptEnterKey();
                                    System.out.println("Thankfully, nothing happens !");
                                    Jeu.promptEnterKey();
                                } else {
                                    System.out.println("Your wand act strangly, same for the Voldemort's one !");
                                    Jeu.promptEnterKey();
                                    wizard.setHealth(wizard.getHealth() - 50);
                                    boss5.setHealth(boss5.getHealth() - 50);
                                    System.out.println("You take \u001B[31m50\u001B[0m HP as backslash damage !");
                                    Jeu.promptEnterKey();
                                    System.out.println("Voldemort takes \u001B[31m50\u001B[0m HP as backslash damage !");
                                }
                            }
                        } else {
                            System.out.println("Please select a correct value.");
                        }
                    } catch (Exception e) {
                        System.out.println("Please select a correct value2.");
                    }
                } else {
                    System.out.println("Please select a correct value.");
                }
            } catch (Exception e) {
                System.out.println("Please select a correct value.");
            }
        } while ((boss4.getHealth() > 0 || boss5.getHealth() > 0) && wizard.getHealth() > 0);

        if (wizard.getHealth() <= 0) {
            System.out.println("WASTED");
            Jeu.promptEnterKey();
            System.out.println("GAME OVER (you suck)");
            System.exit(0);
        }

        if (boss4.getHealth() <= 0) {
            System.out.println("Congratulation, you've defeated Voldemort the terrible (and her sidekick Belatrix)!");
            Jeu.promptEnterKey();
            System.out.println("You join your friends, and finish your journey...");
            Jeu.promptEnterKey();
            System.out.println("Harry Potter RPG, by Jifoux");
        }
    }
}


