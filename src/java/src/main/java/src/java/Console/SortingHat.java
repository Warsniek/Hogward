package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


import lombok.Getter;


public class SortingHat {  // 18/03/23
    public House ChooseHouse() {
        List<House> houses = new ArrayList<House>();
        houses.add(new House("Hufflepuff", 1, 1, 1, 1.5F));
        houses.add(new House("Slytherin", 1, 1, 1.5F, 1));
        houses.add(new House("Gryffindor", 0.5F, 1, 1, 1));
        houses.add(new House("Ravenclaw", 1, 1.5F, 1, 1));
        int randHouse = (int) (Math.random() * 4) + 0; // house : random house
        return houses.get(randHouse);
    }

    public void countdown() {
        for (int i = 10; i >= 0; i--) {
            if (i == 10) {
                System.out.println("Mmmmh I see, I see...");
            } else if (i == 6) {
                System.out.println("Mmmh I'm not sure about this...");
            } else if (i == 3) {
                System.out.println("Oh ! Surprising !");
            }
            try {
                Thread.sleep(1000); // Pause de 1 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("That's it, I've got it ! Your house is...");
    }

}


/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous preferez ?");
        System.out.println("1. le jaune");
        System.out.println("2. le vert");
        System.out.println("3. le rouge");
        System.out.println("4. le bleu");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                System.out.println("you are Hufflepuff");
                break;
            case 2:
                System.out.println("you are Slytherin");
                break;
            case 3:
                System.out.println("you are Gryffindor");
                break;
            //case 4:
            //  System.out.println("Vyou are Ravenclaw");
            //break;
            default:
                System.out.println("Choix invalide");
                break;
        }
    }*/



