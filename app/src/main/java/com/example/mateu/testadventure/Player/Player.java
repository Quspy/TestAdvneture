package com.example.mateu.testadventure.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private  String sIdPlayer;
    private String sName;
    private String cGender;
    private String idActivityPlayer;
    private List<String> idActivitiesList = new ArrayList<>();
    private int iHp;
    private int iAgility;
    private int iStrength;
    private int iIntelligence;
    private int iAttack;
    private List<String> idList = new ArrayList<String>();
    private Random rRand = new Random();
    public Player(String sName)
    {
        setsName(sName);
    }

    public String getsIdPlayer() {
        return sIdPlayer;
    }

    public void setsIdPlayer() {
        idList.add("BA");
        idList.add("BB");
        idList.add("BC");
        idList.add("BD");
        idList.add("BE");
        int randomIndex = rRand.nextInt(4);
        String randomElement = idList.get(randomIndex);
        String randomNumber = String.valueOf(getRandomNumberInRange(10,99));
        this.sIdPlayer = randomElement+randomNumber;
    }

    public void setsIdPlayer(String sIdPlayer) {
        this.sIdPlayer = sIdPlayer;
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

            if(sName.length()>=1)
            {
                this.sName = sName;
            }
    }

    public int getiHp() {
        return iHp;
    }

    public void setiHp(int iHp) {
        this.iHp = iHp;
    }

    public int getiAgility() {
        return iAgility;
    }

    public void setiAgility(int iAgility) {
        this.iAgility = iAgility;
    }

    public int getiStrength() {
        return iStrength;
    }

    public void setiStrength(int iStrength) {
        this.iStrength = iStrength;
    }

    public int getiIntelligence() {
        return iIntelligence;
    }

    public void setiIntelligence(int iIntelligence) {
        this.iIntelligence = iIntelligence;
    }

    public int getiAttack() {
        return iAttack;
    }

    public void setiAttack(int iAttack) {
        this.iAttack = iAttack;
    }

    public String getcGender() {
        return cGender;
    }

    public void setcGender(String cGender) {
        this.cGender = cGender;
    }

    public String getIdActivityPlayer() {
        return idActivityPlayer;
    }

    public void setIdActivityPlayer(String idActivityPlayer) {
        this.idActivityPlayer = idActivityPlayer;
        this.idActivitiesList.add(idActivityPlayer);
    }

    public List<String> getIdActivitiesList() {
        return idActivitiesList;
    }

    public void setIdActivitiesList(List<String> idActivitiesList) {
        this.idActivitiesList=idActivitiesList;
    }
}


