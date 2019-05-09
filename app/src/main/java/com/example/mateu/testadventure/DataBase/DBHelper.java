package com.example.mateu.testadventure.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mateu.testadventure.Player.Warrior;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Test_Adventure.db";
    public static final String DATABASE_TABLE1="weapon_table";
    public static final String DATABASE_TABLE2="player_table";
//    public static final String DATABASE_TABLE3="activity_table";
//    public static final String DATABASE_TABLE4="player_activity_table";


    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ DATABASE_TABLE1 +
                " (" +
//                "W_NR INTEGER not null primary key autoincrement, " +
                "W_ID TEXT not null primary key," +
                "W_TYPE TEXT," +
                "W_ATTACK INTEGER," +
                "W_NAME TEXT," +
                "W_AGILITY INTEGER," +
                "W_STRENGTH INTEGER," +
                "W_INTELLIGENCE INTEGER" +
                ");"
        );

//        insertWeapon(db,"AB32","Warrior",3,"Zweihänder",0,3,0);
//        insertWeapon(db,"AB33","Warrior",2,"Great sword",0,1,0);
//        insertWeapon(db,"AB34","Warrior",4,"Magic Longsword",0,4,0);
//        insertWeapon(db,"AB35","Warrior",4,"Dragon Destructor",0,2,0);
//        insertWeapon(db,"AB36","Warrior",5,"Beliar's Claw",0,5,0);
//        insertWeapon(db,"AB37","Warrior",6,"Rage of Innos",0,4,0);
//        insertWeapon(db,"AB38","Warrior",1,"Butcher Sword",0,1,0);
//
//        insertWeapon(db,"BB32","Mage",5,"Magic Light Wand",0,0,3);
//        insertWeapon(db,"BB33","Mage",2,"Black Wand",0,0,5);
//        insertWeapon(db,"BB34","Mage",2,"Dragon Breath",0,0,2);
//        insertWeapon(db,"BB35","Mage",4,"Sudden Death",0,0,6);
//        insertWeapon(db,"BB36","Mage",6,"Magic Missle",0,0,7);
//        insertWeapon(db,"BB37","Mage",3,"Green Light",0,0,1);
//        insertWeapon(db,"BB38","Mage",4,"Great Wand",0,0,4);
//
//        insertWeapon(db,"CC32","Assassin",4,"Striker",3,0,0);
//        insertWeapon(db,"CC33","Assassin",3,"Endbringer",1,0,0);
//        insertWeapon(db,"CC34","Assassin",1,"Red Obsidian",5,0,0);
//        insertWeapon(db,"CC35","Assassin",2,"Furious Adamantite Protector",2,0,0);
//        insertWeapon(db,"CC36","Assassin",4,"GoblinSlayer",4,0,0);
//        insertWeapon(db,"CC37","Assassin",5,"Reaper",5,0,0);
//        insertWeapon(db,"CC38","Assassin",7,"Apocalypse",6,0,0);


        db.execSQL("create table " +DATABASE_TABLE2 +
                " (" +
//                "P_NR INTEGER not null primary key autoincrement," +
                "P_ID TEXT not null primary key," +
//                "P_CURRENT_ACTIVITY TEXT,"+
                "P_CLASS TEXT not null," +
                "P_NAME TEXT Unique not null," +
                "P_GENDER TEXT not null," +
                "P_HP INTEGER," +
                "P_AGILITY INTEGER," +
                "P_STRENGTH INTEGER," +
                "P_INTELLIGENCE INTEGER," +
                "P_ATTACK INTEGER," +
                "W_ID TEXT," +
                "FOREIGN KEY (W_ID) REFERENCES weapon_table(W_ID)" +
                ");"
        );
//        insertPlayer(db,"Abdullah","M");
//
//        db.execSQL("create table "+"DATABASE_TABLE3" +
//                " (" +
//                "A_NR INTEGER primary key autoincrement," +
//                "A_ID TEXT unique not null," +
//                "A_NAME TEXT " +
//                ");"
//        );
//
//        insertActivity(db,"ADS314");
//
//        db.execSQL("create table "+DATABASE_TABLE4 +
//                " (" +
//                "P_NR INTEGER," +
//                "A_NR INTEGER," +
//                "FOREIGN KEY (P_NR) REFERENCES player_table(P_NR)," +
//                "FOREIGN KEY (A_NR) REFERENCES acitivity_table(A_NR)" +
//                ");"
//        );
    }

    public void insertWeapon(SQLiteDatabase db,String id,String type, int attack,String name,int agillity,int strength,int intelligence)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("W_ID",id);
        contentValues.put("W_TYPE",type);
        contentValues.put("W_ATTACK",attack);
        contentValues.put("W_NAME",name);
        contentValues.put("W_AGILITY",agillity);
        contentValues.put("W_STRENGTH",strength);
        contentValues.put("W_INTELLIGENCE",intelligence);
        db.insert("weapon_table",null,contentValues);
//        db.close();
    }

    private static void insertPlayer(SQLiteDatabase db,String name,String gender)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_NAME",name);
        contentValues.put("P_GENDER",gender);
        db.insert("player_table",null,contentValues);
    }

//    private static void insertActivity(SQLiteDatabase db,String id)
//    {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("A_ID",id);
//
//        db.insert("activity_table",null,contentValues);
//    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE1 );
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE2 );
//        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE3 );
//        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE4 );
        onCreate(db);
    }
}
