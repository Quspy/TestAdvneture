package com.example.mateu.testadventure.Player;

import com.example.mateu.testadventure.Weapon.ShortSword;

public class Assassin extends Player {

    private ShortSword shortSword;
    private String type = "Assassin";
    public Assassin(String sName)
    {
        super(sName);
        setiHp(11);
        setiAgility(6);
        setiStrength(2);
        setiIntelligence(2);
        setiAttack(5);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setiAttack()
    {
        int attack = (2+getiAgility()+getShortSword().getiAttack())/2;
        this.setiAttack(attack);
    }

    public ShortSword getShortSword() {
        return shortSword;
    }

    public void setShortSword(ShortSword shortSword) {
        this.shortSword = shortSword;
    }
}

