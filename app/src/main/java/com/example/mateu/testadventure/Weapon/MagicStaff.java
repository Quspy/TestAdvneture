package com.example.mateu.testadventure.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicStaff extends Weapon {

    private int iIntelligence;
    private List<String> sNameList = new ArrayList<>();
    private Random rRand = new Random();
    public MagicStaff()
    {
        super();
        setiIntelligence();
        setsName();
        setsType("Mage");
    }
    public int getiIntelligence() {
        return iIntelligence;
    }

    public void setiIntelligence() {
        int intelligence = getRandomNumberInRange(1,4);
        this.iIntelligence=intelligence;
    }

    public void setsName()
    {
        sNameList.add("Magic Light Wand");
        sNameList.add("Black Wand");
        sNameList.add("Dragon Breath");
        sNameList.add("Sudden Death");
        sNameList.add("Magic Missle");
        sNameList.add("Green Light");
        sNameList.add("Great Wand");
        sNameList.add("Behemoth Loss");
        int randomIndex = rRand.nextInt(7);
        setsName(sNameList.get(randomIndex));
    }
}
