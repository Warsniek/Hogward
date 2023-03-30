import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.sql.Array;


public class Main{
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
}
