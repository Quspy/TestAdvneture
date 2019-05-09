package com.example.mateu.testadventure.Player;

import com.example.mateu.testadventure.Weapon.LongSword;

public class Warrior extends Player {

    private LongSword longSword;
    private String type = "Warrior";

    public Warrior(String sName)
    {
        super(sName);
        setiHp(13);
        setiAgility(2);
        setiStrength(5);
        setiIntelligence(1);
        setiAttack(4);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setiAttack()
    {
        int attack = (2+getiStrength()+getLongSword().getiAttack())/2;
        this.setiAttack(attack);
    }

    public LongSword getLongSword() {
        return longSword;
    }

    public void setLongSword(LongSword longSword) {
        this.longSword = longSword;
    }
}
