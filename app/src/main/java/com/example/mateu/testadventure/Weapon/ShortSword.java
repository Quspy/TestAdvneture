package com.example.mateu.testadventure.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShortSword extends Weapon {

    private int iAgility;
    private List<String> sNameList = new ArrayList<>();
    private Random rRand = new Random();

    public ShortSword()
    {
        super();
        setiAgility();
        setsName();
        setsType("Assassin");
    }

    public int getiAgility()
    {
        return iAgility;
    }

    public void setiAgility()
    {
        int agility = getRandomNumberInRange(1,4);
        this.iAgility=agility;
    }

    public void setsName()
    {
        sNameList.add("Striker");
        sNameList.add("Endbringer");
        sNameList.add("Red Obsidian");
        sNameList.add("Furious Adamantite Protector");
        sNameList.add("GoblinSlayer");
        sNameList.add("Reaper");
        sNameList.add("Apocalypse");
        sNameList.add("Arondite");
        int randomIndex = rRand.nextInt(7);
        setsName(sNameList.get(randomIndex));
    }

}
