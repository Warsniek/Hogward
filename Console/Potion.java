package Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Potion {
    private String potionName;
    private float potionValue;

    public Potion(String potionName, float potionValue){
        this.potionName=potionName;
        this.potionValue=potionValue;
    }

    public String getPotionName(){
        return potionName;
    }
    public void setPotionName(String potionName){
        this.potionName=potionName;
    }



    public float getPotionValue(){
        return potionValue;
    }
    public void setPotionValue(float potionValue){
        this.potionValue=potionValue;
    }




    public static void healthPotion(Wizard wizard, float potion){
        wizard.sethealth(wizard.getHealth() + potion * wizard.getHouse().getBuffPotion());
    }
}
