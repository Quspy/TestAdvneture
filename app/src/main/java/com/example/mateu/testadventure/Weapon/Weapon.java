package com.example.mateu.testadventure.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {

    private String sIdWeapon;
    private int iAttack;
    private String sName;
    private String sType;
    private List<String> idList = new ArrayList<>();
    private List<String> sNameList = new ArrayList<>();
    private  Random rRand = new Random();


    public Weapon()
    {
        setsIdWeapon();
        setiAttack();
    }

    public String getsIdWeapon() {
        return sIdWeapon;
    }

    public void setsIdWeapon() {

        idList.add("AA");
        idList.add("AB");
        idList.add("AC");
        idList.add("AD");
        idList.add("AE");
        int randomIndex = rRand.nextInt(4);
        String randomElement = idList.get(randomIndex);
        String randomNumber = String.valueOf(getRandomNumberInRange(10,99));
        this.sIdWeapon = randomElement+randomNumber;
    }

    public int getiAttack() {
        return iAttack;
    }

    public void setiAttack() {
        int attack = getRandomNumberInRange(1,4);
        this.iAttack=attack;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }
}

