package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Jeu {  // 17/03/23  // 18/03/23  // 20/03/23  // 21/03/23  // 24/03/23   // 25/03/23

    public static List<Spell> spells;
    public static List<ForbiddenSpell> forbiddenSpells;
    public static List<Boss> bosses;

    public static void promptEnterKey() {   //permet d'appuyer sur ENTRER pour ne pas que l'histoire se deroule trop vite
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void atkBuff(List<Spell> spells) {
        float atkBuff = 1.1F;
        for (Spell spell : spells) {
            float newAtk = spell.getSpellPower() * atkBuff;
            spell.setSpellPower(newAtk);
        }
    }

    public static void hpBuff(Wizard wizard) {
        //wizard.setHealth((float) (wizard.getHealth() * 1.1));
        wizard.sethealthMax((float) (wizard.getHealthMax() * 1.1));
    }

    public static void levelUP(Wizard wizard, List<Spell> spells) {
        Scanner scannerLevelUP = new Scanner(System.in);
        System.out.println("LEVEL UP ! Which stat. you want to upgrade ? \n" + "[0] ATK \n" + "[1] HP \n");
        int levelUP = scannerLevelUP.nextInt();
        if (levelUP == 0) {
            atkBuff(spells);
        }
        if (levelUP == 1) {
            hpBuff(wizard);
        }
    }

    public static void spellArsenal(Wizard wizard) {
        for (int i = 0; i < wizard.getWizardKnownSpells().size(); i++) {
            System.out.println("[" + i + "] \u001B[32mNAME \u001B[0m: " + wizard.getWizardKnownSpells().get(i).getSpellName() + " ||\u001B[35m DMG \u001B[0m: " + wizard.getWizardKnownSpells().get(i).getSpellPower() + " ||\u001B[33m ACCURACY\u001B[0m: " + wizard.getWizardKnownSpells().get(i).getSpellAccuracy() + " ||\u001B[34m DESCRIPTION \u001B[0m: " + wizard.getWizardKnownSpells().get(i).getSpellDescription());
        }
    }

    public static void potionInventory(Wizard wizard) {
        for (int i = 0; i < wizard.getPotions().size(); i++) {
            System.out.println("[" + i + "] \u001B[32mNAME \u001B[0m: " + wizard.getPotions().get(i).getPotionName() + " || \u001B[35mHEALING \u001B[0m: " + wizard.getPotions().get(i).getPotionValue() + " HP ");
        }
    }

    public static void randomPotion(Wizard wizard, List<Potion> potions) {
        int randPotion = (int) (Math.random() * 5) + 0;
        System.out.println("It's a " + potions.get(randPotion).getPotionName() + "!");
        wizard.addPotion(potions.get(randPotion));
        System.out.println("Updated potion inventory : ");
        potionInventory(wizard);
    }

    public static void main(String[] args) {


        Levels myLevel = new Levels();
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy("Troll", 600, 600, 150));
        enemies.add(new Enemy("Basilisk", 1000, 1000, 50));
        enemies.add(new Enemy("Dementors", 6666, 6666, 666));
        enemies.add(new Enemy("Death Eaters", 100, 1000, 50));

        bosses = new ArrayList<Boss>();
        bosses.add(new Boss("Pettigrow", 2000, 2000, 1, null, null));
        bosses.add(new Boss("Bellatrix Lestrange", 500, 500, 1, null, null));
        bosses.add(new Boss("Voldemort", 3000, 3000, 1.2F, null, null));
        bosses.add(new Boss("Ombrage", 5000, 5000, 50, null, null));

        List<Potion> potions = new ArrayList<Potion>();
        potions.add(new Potion("Petite pot", 150));
        potions.add(new Potion("Grosse pot", 200));
        potions.add(new Potion("Gourdasse", 500));


        spells = new ArrayList<Spell>();
        spells.add(new Spell("Wingardium Leviosa", 0, 85, false, "You levitate an enemy, or an object"));
        spells.add(new Spell("Accio", 50, 100, false, "You attract an enemy or an object to you"));
        spells.add(new Spell("Depulso", 0, 65, false, "Throws enemy or object. Does no damage on it's own, but enemies and objects can be thrown into surfaces or other enemies"));
        spells.add(new Spell("Expecto Patronum", 0, 100, false, "Conjures up a protective spirit that can act as a shield against certain creatures or as a messenger."));
        spells.add(new Spell("Diffindo", 150, 80, false, "Slices through target to hit enemies behind them"));
        spells.add(new Spell("Expelliarmus", 75, 100, false, "Long-range attack. Disarms most enemies and damages them."));
        spells.add(new Spell("Sectumsempra", 120, 90, false, "Lacerates the target and causes severe haemorrhaging"));


        forbiddenSpells = new ArrayList<ForbiddenSpell>();
        forbiddenSpells.add(new ForbiddenSpell("Expelliarmus", 75, 100, false, "Long-range attack. Disarms most enemies and damages them."));
        forbiddenSpells.add(new ForbiddenSpell("Imperium", 100, 80, true, "Total control"));
        forbiddenSpells.add(new ForbiddenSpell("Doloris", 150, 75, true, "Excruciating pain"));
        forbiddenSpells.add(new ForbiddenSpell("Sectumsempra", 200, 50, true, "Hurt considerably the target"));
        forbiddenSpells.add(new ForbiddenSpell("Avada Kedavra", Integer.MAX_VALUE, 100, true, "Instantaneous death"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("First of all, what is your name ?");
        String playerName = scanner.nextLine();
        System.out.println("Thanks...");

        Pet[] pets = Pet.values();
        Random randomPet = new Random();
        Pet pet = pets[randomPet.nextInt(pets.length)];

        Core[] core = Core.values();
        Random randomCore = new Random();
        Core randCore = core[randomCore.nextInt(core.length)];
        int randNbSize = (int) (Math.random() * 21) + 20;
        Wand wand = new Wand(randCore, randNbSize);

        SortingHat Hat = new SortingHat();

        Wizard wizard = new Wizard(playerName, pet, wand, Hat.ChooseHouse(), spells.get(0), potions.get(0));

        System.out.println("Welcome to Hogwards " + playerName + ".");
        promptEnterKey();
        System.out.println("Your animal is a " + pet + ".");
        if (pet == Pet.TOAD) {
            promptEnterKey();
            System.out.println("Bruh... Unlucky bro");
        }
        promptEnterKey();
        System.out.println("Your wand has a heart constitued of " + wand.getCore() + " and measure " + wand.getSize() + "cm");
        promptEnterKey();
        System.out.println("For now, you have only one spell : " + wizard.getWizardKnownSpells().get(0).getSpellName());
        promptEnterKey();

        System.out.println("Albus Dumbeldore give you a small healing potion to start your journey : " + wizard.getPotions().get(0).getPotionName() + " : " + wizard.getPotions().get(0).getPotionValue() + " health points ");
        promptEnterKey();
        System.out.println("On your way to the reception, you accidentally find a healing potion on the floor !");
        promptEnterKey();
        randomPotion(wizard, potions);
        promptEnterKey();

        System.out.println("When you arrive at the reception, Albus Dumbledore and Professor Minerva McGonagall put the sorting hat on your head to determine your house...");
        promptEnterKey();
        System.out.println("The latter begins to whisper : ");
        promptEnterKey();
        /*SortingHat countdown = new SortingHat();
        countdown.countdown();*/
        promptEnterKey();
        System.out.println(wizard.getHouse().getName() + "!");
        promptEnterKey();

        System.out.println("Everyone in the large hall applauds. But enough of the mundanity, it's time to attend your first class !");
        promptEnterKey();
        wizard.addSpell(spells.get(1));
        System.out.println("You learned a new spell ! : " + wizard.getWizardKnownSpells().get(1).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 1                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level1(wizard, enemies, potions);
        System.out.println("The night port advise, this rude fight made you gain experience.");
        wizard.getWizardKnownSpells().get(0).setSpellPower(0);
        wizard.getWizardKnownSpells().get(1).setSpellPower(50);
        wizard.getWizardKnownSpells().get(0).setSpellName("Wingardium Leviosa");
        //enemies.get(0).setHealth(enemies.get(0).getmaxHealth());
        levelUP(wizard, spells);
        promptEnterKey();
        System.out.println("The next year...");
        wizard.addSpell(spells.get(2));
        System.out.println("You have learned a new spell during the class : " + wizard.getWizardKnownSpells().get(2).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 2                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level2(wizard, enemies, potions);
        System.out.println("The night port advise, this rude fight made you gain experience.");
        wizard.getWizardKnownSpells().get(2).setSpellPower(0);
        wizard.getWizardKnownSpells().get(2).setSpellName("Depulso");
        levelUP(wizard, spells);
        promptEnterKey();
        wizard.addSpell(spells.get(3));
        System.out.println("You have learned a new spell during the class : " + wizard.getWizardKnownSpells().get(3).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 3                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level3(wizard, enemies, potions);
        System.out.println("This rude fight made you gain experience.");
        levelUP(wizard, spells);
        promptEnterKey();
        System.out.println("The night port advise, you heal yourself");
        wizard.setHealth(wizard.getHealthMax());
        promptEnterKey();
        wizard.addSpell(spells.get(4));
        System.out.println("You have learned a new spell during the class : " + wizard.getWizardKnownSpells().get(4).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 4                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level4(wizard, potions);
        bosses.get(0).setHealth(bosses.get(0).getHealthMax());
        bosses.get(2).setHealth(bosses.get(2).getHealthMax());
        System.out.println("This rude fight made you gain experience.");
        levelUP(wizard, spells);
        promptEnterKey();
        System.out.println("The night port advise, you heal yourself");
        wizard.setHealth(wizard.getHealthMax());
        promptEnterKey();
        wizard.addSpell(spells.get(5));
        System.out.println("You have learned a new spell during the class : " + wizard.getWizardKnownSpells().get(5).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 5                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level5(wizard, potions);
        wizard.getWizardKnownSpells().remove(wizard.getWizardKnownSpells().get(6));
        System.out.println("This rude fight made you gain experience.");
        levelUP(wizard, spells);
        promptEnterKey();
        System.out.println("The night port advise, you heal yourself");
        wizard.setHealth(wizard.getHealthMax());
        promptEnterKey();
        wizard.addSpell(spells.get(6));
        System.out.println("You have learned a new spell during the class : " + wizard.getWizardKnownSpells().get(6).getSpellName());
        promptEnterKey();
        System.out.println("Updated arsenal of learning spells : ");
        spellArsenal(wizard);
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 6                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level6(wizard, potions);
        spells.get(6).setSpellName("Sectumsempra");
        spells.get(6).setSpellPower(120);
        System.out.println("This rude fight made you gain experience.");
        levelUP(wizard, spells);
        promptEnterKey();
        System.out.println("The night port advise, you heal yourself");
        wizard.setHealth(wizard.getHealthMax());
        for (Spell spell : spells) {
            float newAtk = spell.getSpellPower() * 1.5F;
            spell.setSpellPower(newAtk);
        }
        for (Potion potion : potions) {
            float newValue = potion.getPotionValue() * 1.5F;
            potion.setPotionValue(newValue);
        }
        promptEnterKey();

        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                     LEVEL 7                                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        promptEnterKey();

        myLevel.Level7(wizard, potions);
    }
}


