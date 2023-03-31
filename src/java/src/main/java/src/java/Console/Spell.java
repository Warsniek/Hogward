package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Spell {  // 17/03/23
    private String name;
    private float spellPower;
    private float spellAccuracy;
    private int forbidden;

    public Spell(String name, int spellPower, int spellAccuracy, int forbidden) {
        this.name = name;
        this.spellPower = spellPower;
        this.spellAccuracy = spellAccuracy;
        this.forbidden = forbidden;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(float spellPower) {
        this.spellPower = spellPower;
    }

    public float getSpellAccuracy() {
        return spellAccuracy;
    }

    public void setSpellAccuracy(float spellAccuracy) {
        this.spellPower = spellAccuracy;
    }

    public int getForbidden() {
        return forbidden;
    }

    public void setForbidden(int forbidden) {
        this.forbidden = forbidden;
    }


}
