package Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Wizard  extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> wizardKnownSpells;
    private List<Potion> potions;


    public Wizard(String name, Pet pet, Wand wand, House house, Spell spell, Potion potion) {
        super (name, 100, 500);
        this.pet=pet;
        this.wand=wand;
        this.house=house;
        this.wizardKnownSpells=new ArrayList<Spell>();
        this.potions=new ArrayList<Potion>();

        potions.add(potion);
        wizardKnownSpells.add(spell);


    }

    public void addPotion(Potion potion){
        potions.add(potion);
    }

    public void addSPell(Spell spell){
        wizardKnownSpells.add(spell);
    }

    public Pet getPet(){
        return pet;
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }

    public Wand getWand(){
        return wand;
    }
    public void setWand(Wand wand){
        this.wand = wand;
    }

    public House getHouse(){
        return house;
    }
    public void setHouse(House house){
        this.house = house;
    }

    public List<Spell> getWizardKnownSpells(){
        return wizardKnownSpells;
    }
    public void setWizardKnownSpells(List<Spell> WizardKnownSpells){
        this.wizardKnownSpells = wizardKnownSpells;
    }
}