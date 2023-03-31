package src.java.Console;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class House {
    private String name;
    private float reduceDamage;
    private float buffAccuracy;
    private float buffDamage;
    private float buffPotion;


    public House(String name, float reduceDamage, float buffAccuracy, float buffDamage, float buffPotion) {
        this.name = name;
        this.reduceDamage = reduceDamage;
        this.buffAccuracy = buffAccuracy;
        this.buffDamage = buffDamage;
        this.buffPotion = buffPotion;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReduceDamage() {
        return reduceDamage;
    }

    public void setReduceDamage(float reduceDamage) {
        this.reduceDamage = reduceDamage;
    }


    public float getBuffAccuracy() {
        return buffAccuracy;
    }

    public void setBuffAccuracy(float buffAccuracy) {
        this.buffAccuracy = buffAccuracy;
    }

    public float getBuffDamage() {
        return buffDamage;
    }

    public void setBuffDamage(float buffDamage) {
        this.buffDamage = buffDamage;
    }

    public float getBuffPotion() {
        return reduceDamage;
    }

    public void setBuffPotion(float buffPotion) {
        this.buffPotion = buffPotion;
    }

}
