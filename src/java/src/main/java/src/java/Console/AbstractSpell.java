package src.java.Console;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

abstract class AbstractSpell {  // 17/03/23
    private String spellName;
    private float spellPower;
    private float spellAccuracy;
    private String spellDescription;


    public AbstractSpell(String spellName, float spellPower, float spellAccuracy) {
        this.spellName = spellName;
        this.spellPower = spellPower;
        this.spellAccuracy = spellAccuracy;
        this.spellDescription = spellDescription;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String name) {
        this.spellName = spellName;
    }

    public float getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(float SpellPower) {
        this.spellPower = spellPower;
    }

    public float getSpellAccuracy() {
        return spellPower;
    }

    public void setSpellAccuracy(float SpellAccuracy) {
        this.spellAccuracy = spellAccuracy;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }
}

