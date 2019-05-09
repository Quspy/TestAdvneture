package com.example.mateu.testadventure.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LongSword extends Weapon {

    private int iStrength;
    private List<String> sNameList = new ArrayList<>();
    private Random rRand = new Random();

    public LongSword()
    {
        super();
        setiStrength();
        setsName();
        setsType("Warrior");
    }

    public int getiStrength() {
        return iStrength;
    }

    public void setiStrength() {
        int strength = getRandomNumberInRange(1,4);
        this.iStrength=strength;
    }

    public void setsName()
    {
        sNameList.add("Zweihänder");
        sNameList.add("Great sword");
        sNameList.add("Magic Longsword");
        sNameList.add("Dragon Destructor");
        sNameList.add("Beliar's Claw");
        sNameList.add("Rage of Innos");
        sNameList.add("Butcher Sword");
        sNameList.add("Massacre");
        int randomIndex = rRand.nextInt(7);
        setsName(sNameList.get(randomIndex));
    }
}
