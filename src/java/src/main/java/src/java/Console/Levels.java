package src.java.Console;

import java.util.List;

public class Levels {  // 17/03/23  // 18/03/23  // 20/03/23  // 21/03/23  // 24/03/23   // 25/03/23  // 26/03/23
    public static int spellUsed;
    public static String opponentName;
    public static float opponentGetHP;
    public static float opponentHPMax;
    public static float opponentPower;
    public static AbstractEnemy opponent;
    public static float opponentSetHP;


    public void Levels(Wizard wizard, List<Enemy> enemies) {
        opponentName = enemies.get(0).getName();
        opponentGetHP = enemies.get(0).getHealth();
        opponentHPMax = enemies.get(0).getHealthMax();
        opponentPower = enemies.get(0).getOpponentPower();
        opponent = enemies.get(0);


        System.out.println("frérot t'arrives au toilettes");
        Jeu.promptEnterKey();
        System.out.println("et la bam un troll");
        Jeu.promptEnterKey();

    }

}
