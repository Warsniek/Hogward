package Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

abstract class AbstractSpell {
    private String spellName;
    private float spellPower;
    private float spellAccuracy;


    public AbstractSpell(String spellName, float spellPower, float spellAccuracy) {
        this.spellName = spellName;
        this.spellPower = spellPower;
        this.spellAccuracy = spellAccuracy;
    }

    public String getSpellName() {
        return spellName;
    }
    public void setSpellName(String name){
        this.spellName = spellName;
    }

    public float getSpellPower(){
        return spellPower;
    }
    public void setSpellPower(float SpellPower){
        this.spellPower = spellPower;
    }

    public float getSpellAccuracy(){
        return spellPower;
    }
    public void setSpellAccuracy(float SpellAccuracy){
        this.spellAccuracy = spellAccuracy;
    }
}

