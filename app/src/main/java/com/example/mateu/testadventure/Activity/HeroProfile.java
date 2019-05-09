package com.example.mateu.testadventure.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mateu.testadventure.DataBase.DBHelper;
import com.example.mateu.testadventure.R;

public class HeroProfile extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;
    private static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_profile);
        Intent intent = getIntent();
        name =intent.getStringArrayExtra(PathChooser.EXTRA_MESSAGE);
        imageView = findViewById(R.id.imageView);
        if(name[2].equals("Warrior"))
        {
            if(name[3].equals("M")) {
                imageView.setImageResource(R.drawable.malewarrior);
            }
            else
            {
                imageView.setImageResource(R.drawable.femalewarrior);
            }
        }
        else if(name[2].equals("Assassin")) {
            if (name[3].equals("M")) {
                imageView.setImageResource(R.drawable.maleassassin);
            } else {
                imageView.setImageResource(R.drawable.femaleassassin);
            }
        }
        else {
            if(name[3].equals("M")) {
                imageView.setImageResource(R.drawable.malemage);
            }
            else
            {
                imageView.setImageResource(R.drawable.femalemage);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public class sqlSaver extends AsyncTask<Context,Void,Void>
    {

        @Override
        protected Void doInBackground(Context... contexts) {

            try
            {
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                Cursor cursor = db.query("player_table",null,"P_ID = ?",new String[]{name[0]},null,null,null);

                if(cursor.moveToFirst())
                {
                    klasa =cursor.getString(1);
                    namecharacter =cursor.getString(2);
                    hp =cursor.getInt(4);
                    agi =cursor.getInt(5);
                    stre =cursor.getInt(6);
                    inte =cursor.getInt(7);
                    attack =cursor.getInt(8);
                    weaponid =cursor.getString(9);
                }
                if(weaponid!=null)
                {
//                    db.rawQuery("SELECT*FROM weapon_table where W_ID = ?",new String[]{weaponid});
                    Cursor cursor1 = db.query("weapon_table",null,"W_ID = ?",new String[]{weaponid},null,null,null);
                    if(cursor1.moveToFirst())
                    {
                        weaponname=cursor1.getString(3);
                        weaponattack=cursor1.getInt(2);
                    }
                }
                db.close();
            }
            catch (SQLException ex)
            {
                Toast toast = Toast.makeText(getApplicationContext(), "There is problem with database", Toast.LENGTH_LONG);
                toast.show();
            }
            return null;
        }
    }
    private String klasa;
    String namecharacter;
    int hp;
    int agi;
    int stre;
    int inte;
    int attack;
    String weaponid;
    String weaponname;
    int weaponattack;
    TextView PClass;
    TextView PName;
    TextView PHp;
    TextView PAg;
    TextView PSt;
    TextView PInt;
    TextView PAtt;
    TextView WName;
    TextView WAtt;
    public void OptionOne(View view)
    {
        sqlSaver sqlSaver = new sqlSaver();
        sqlSaver.doInBackground();
        PClass = findViewById(R.id.PlayerClassRespond);
        PName = findViewById(R.id.PlayerNameRespond);
        PHp = findViewById(R.id.PlayerHPRespond);
        PAg = findViewById(R.id.PlayerAgillityRespond);
        PSt = findViewById(R.id.PlayerStrengthRespond);
        PInt = findViewById(R.id.PlayerIntelligenceRespond);
        PAtt = findViewById(R.id.PlayerAttackRespond);
        WName = findViewById(R.id.WeaponNameRespond);
        WAtt = findViewById(R.id.WeaponAttackRespond);

        PClass.setText(klasa);
        PName.setText(namecharacter);
        PHp.setText(String.valueOf(hp));
        PAg.setText(String.valueOf(agi));
        PSt.setText(String.valueOf(stre));
        PInt.setText(String.valueOf(inte));
        PAtt.setText(String.valueOf(attack));
        if(weaponid!=null) {
            WName.setText(weaponname);
            WAtt.setText(String.valueOf(weaponattack));
        }
        else
        {
            WName.setText("Empty");
            WAtt.setText(String.valueOf("Empty"));
        }
    }
    public void OptionTwo(View view)
    {
        finish();
    }

}
