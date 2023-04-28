package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ForbiddenSpell extends AbstractSpell {
    private boolean forbidden = true;

    public ForbiddenSpell(String forbiddenSpellName, int forbiddenSpellPower, int forbiddenSpellAccuracy, boolean forbidden, String forbiddenSpellDescription) {
        super(forbiddenSpellName, forbiddenSpellPower, forbiddenSpellAccuracy, forbiddenSpellDescription);
        this.forbidden = forbidden;
    }

    public boolean getForbidden() {
        return forbidden;
    }

    public void setForbidden(boolean forbidden) {
        this.forbidden = forbidden;
    }
}
