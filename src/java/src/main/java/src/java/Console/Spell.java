package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Spell extends AbstractSpell {
    private boolean forbidden = false;

    public Spell(String spellName, int spellPower, int spellAccuracy, boolean forbidden, String spellDescription) {
        super(spellName, spellPower, spellAccuracy, spellDescription);
        this.forbidden = forbidden;
    }

    public boolean getForbidden() {
        return forbidden;
    }

    public void setForbidden(boolean forbidden) {
        this.forbidden = forbidden;
    }

    public static List<Spell> SetUpSpells() {
        List<Spell> spells = new ArrayList<Spell>();
        spells.add(new Spell("Wingardium Leviosa", 10, 100, false, null));
        spells.add(new Spell("Accio", 10, 100, false, null));
        spells.add(new Spell("Expecto Patronum", 10, 100, false, null));
        spells.add(new Spell("Sectumsempra", 10, 100, false, null));
        spells.add(new Spell("Expelliarmus", 10, 100, false, null));
        return spells;
    }
}