package src.java.Console;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Boss extends AbstractEnemy {  // 19/03/23  // 20/03/23
    private Wand wand;
    private List<Spell> bossKnownSpells;
    private List<ForbiddenSpell> bossKnownForbiddenSpells;

    public Boss(String name, float health, float healthMax, float enemyPower, Spell spell, ForbiddenSpell forbiddenSpell) {
        super(name, health, healthMax, enemyPower);
        this.bossKnownSpells = new ArrayList<Spell>();
        this.bossKnownForbiddenSpells = new ArrayList<ForbiddenSpell>();
        this.wand = wand;
        bossKnownSpells.add(spell);
        bossKnownForbiddenSpells.add(forbiddenSpell);
    }

    public void addSpell(Spell spell) {
        bossKnownSpells.add(spell);
    }

    public void addForbiddenSpell(ForbiddenSpell forbiddenSpell) {
        bossKnownForbiddenSpells.add(forbiddenSpell);
    }

    public List<Spell> getBossKnownSpells() {
        return bossKnownSpells;
    }

    public void setBossKnownSpells(List<Spell> bossKnownSpells) {
        this.bossKnownSpells = bossKnownSpells;
    }

    public List<ForbiddenSpell> getBossKnownForbiddenSpells() {
        return bossKnownForbiddenSpells;
    }

    public void setBossKnownForbiddenSpells(List<ForbiddenSpell> bossKnownForbiddenSpells) {
        this.bossKnownForbiddenSpells = bossKnownForbiddenSpells;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

}

