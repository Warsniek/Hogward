package Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public abstract class AbstractEnemy extends Character {
    private float opponentPower;

    public AbstractEnemy (String name, float health, float healthMax, float opponentPower){
        super(name, health, healthMax);
        this.opponentPower = opponentPower;
    }

    public float getOpponentPower(){
        return opponentPower;
    }
    public void getOpponentPower(float opponentPower){
        this.opponentPower = opponentPower;
    }
}
