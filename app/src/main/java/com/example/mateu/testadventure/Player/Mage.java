package com.example.mateu.testadventure.Player;

import com.example.mateu.testadventure.Weapon.MagicStaff;

public class Mage extends Player {

    private MagicStaff magicStaff;
    private String type = "Mage";

    public Mage(String sName)
    {
        super(sName);
        setiHp(10);
        setiAgility(2);
        setiStrength(1);
        setiIntelligence(6);
        setiAttack(3);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setiAttack()
    {
        int attack = (2+getiIntelligence()+getMagicStaff().getiAttack())/2;
        this.setiAttack(attack);
    }

    public MagicStaff getMagicStaff() {
        return magicStaff;
    }

    public void setMagicStaff(MagicStaff magicStaff) {
        this.magicStaff = magicStaff;
    }
}
