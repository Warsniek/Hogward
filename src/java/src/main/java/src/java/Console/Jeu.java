package src.java.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


public class Jeu{  // 17/03/23  // 18/03/23  // 20/03/23  // 21/03/23  // 24/03/23   // 25/03/23
    public static void promptEnterKey(){                                 //permet d'appuyer sur entrer pour continuer l'histoire pour ne pas tout derouler rapide
        System.out.println("Press\"ENTER\" to continue ...");
        Scanner scanner = new Scanner (System.in);
        scanner.nextLine();
    }

    public static void atkBuff(List<Spell> spells){
        float atkBuff = 1.1F;
        for (Spell spell : spells){
            float newAtk = spell.getSpellPower() * atkBuff;
            spell.setSpellPower(newAtk);
        }
    }

    public static void hpBuff(Wizard wizard){
        wizard.setHealth(float) (wizard.getHealth()* 1.1);
    }

    public static void main(String[] args){
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy ("troll", 500, 500, 100));
        enemies.add(new Enemy ("Basilic", 100, 1000, 50));
        enemies.add(new Enemy ("Détraqueurs", 100, 500, 50));
        enemies.add(new Enemy ("Ombrage", 100, 1000, 50));



        List<Boss> boss = new ArrayList<Boss>();
        boss.add(new Boss ("Rogue", 500, 500, 100, 11, false));
        boss.add(new Boss ("Lestrange", 100, 1000, 50));
        boss.add(new Boss ("Voldemort", 100, 500, 50));

        List<Potion> potions = new ArrayList<Potion>();
        potions.add(new Potion ("petite pote", 10));
        potions.add(new Potion ("grosse pote", 30));
        potions.add(new Potion ("Gourdasse", 60));


        List<Spell> spells = new ArrayList<Spell>();
        spells.add(new Spell ("Wingardium Leviosa", 0, 500, 100));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre nom");
        String playerName = scanner.nextLine();   //le nom du joueur
        System.out.println("Thanks");


        Pet[] pets = Pet.values();
        Random randomPet = new Random();
        Pet pet = pets[randomPet.nextInt(pets.length)];


        Core[] cores = Core.values();
        Random randomCore = new Random();
        Core core = cores[randomPet.nextInt(pets.length)];
        int randomSize = (int)(Maths.random() * 18) + 8;
        Wand wand = new Wand(randomCore, randomSize);


        Wizard wizard = new Wizard (playerName, pet, wand, SortingHat.ChooseHouse(), spells.get(0), potions.get(0));
    }
}
