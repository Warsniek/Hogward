package src.java.Console;

import java.util.List;

public class Levels {
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
        opponentPower = enemies.get(0).getopponentPower();
        opponent = enemies.get(0);
    }

}
