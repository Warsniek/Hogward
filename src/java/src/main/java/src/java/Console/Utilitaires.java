import src.java.Console.Jeu;
import src.java.Console.Wizard;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Utilitaires {


    public void castExpectoPatronumIn10Sec() {
        boolean success = isStringEnteredCorrectly("Expecto Patronum", 10);
        if (success) {
            System.out.println("Concratulation, you cast Expecto Patronum perfectly and at time !");
        } else {
            System.out.println("Game Over !");
        }
    }

    public boolean isStringEnteredCorrectly(String expectedString, int seconds) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have " + seconds + " seconds to print the following String : " + expectedString);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up !");
                System.exit(0);
            }
        }, seconds * 1000L);

        while (true) {
            if (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();
                if (inputString.equals(expectedString)) {
                    timer.cancel();
                    return true;
                } else {
                    System.out.println("Please retry.");
                }
            }
        }
    }

    public void defendYourselfIn10Sec(Wizard wizard) {
        boolean success = isStringEnteredCorrectly("Expelliarmus", 10);
        if (success) {
            System.out.println("\"Avada Kedavra !!\"");
            Jeu.promptEnterKey();
            System.out.println("Congratulation, you defend yourself perfectly and at time !");
            Jeu.promptEnterKey();
        } else {
            System.out.println("Avada Kedavra !");
            Jeu.promptEnterKey();
            System.out.println("You did not succeed to defend yourself !");
            Jeu.promptEnterKey();
            wizard.setHealth(0);
            System.out.println(" inflict you " + Jeu.forbiddenSpells.get(4).getSpellPower() + " damage !");
            Jeu.promptEnterKey();
        }
    }
}