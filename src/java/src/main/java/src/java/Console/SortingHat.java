package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SortingHat {
    public static void Choosehouse() {
        List<House> houses = new ArrayList<>();
        houses.add(new House("Hufflepuff", 1, 1, 1, 1.5F));
        houses.add(new House("Slytherin", 1, 1, 1.5F, 1));
        houses.add(new House("Gryffindor", 0.5F, 1, 1, 1));
        houses.add(new House("Ravenclaw", 1, 1.5F, 1, 1));

    }


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
    }

}

