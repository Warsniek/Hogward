package src.java.Console;

public abstract class AbstractEnemy extends Character {  // 17/03/23
    private float opponentPower;

    public AbstractEnemy(String name, float health, float healthMax, float opponentPower) {
        super(name, health, healthMax);
        this.opponentPower = opponentPower;
    }

    public float getOpponentPower() {
        return opponentPower;
    }

    public void getOpponentPower(float opponentPower) {
        this.opponentPower = opponentPower;
    }
}
