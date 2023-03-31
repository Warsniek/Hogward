package src.java.Console;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Boss extends AbstractEnemy {  // 19/03/23  // 20/03/23
    private List<Spell> bossKnownSpells;
    private List<ForbiddenSpell> forbiddenSpells;

    public Boss(String name, float health, float healthMax, float enemyPower, Spell spell, ForbiddenSpell forbiddenSpell) {
        super(name, health, healthMax, enemyPower);
        this.bossKnownSpells = new ArrayList<Spell>();
        this.forbiddenSpells = new ArrayList<ForbiddenSpell>();
        bossKnownSpells.add(spell);
        forbiddenSpells.add(forbiddenSpell);
    }

    public void addSpell(Spell spell) {
        bossKnownSpells.add(spell);
    }

    public void addForbiddenSpell(ForbiddenSpell forbiddenSpell) {
        forbiddenSpells.add(forbiddenSpell);
    }

    public List<Spell> getKnownSpells() {
        return bossKnownSpells;
    }

    public void setKnownSpells(List<Spell> BossKnownSpells) {
        this.bossKnownSpells = BossKnownSpells;
    }

    public List<ForbiddenSpell> forbiddenSpells() {
        return forbiddenSpells;
    }

    public void setForbiddenSpells(List<ForbiddenSpell> forbiddenSpells) {
        this.forbiddenSpells = forbiddenSpells;
    }


    public void attack(Character c) {
    }
}

