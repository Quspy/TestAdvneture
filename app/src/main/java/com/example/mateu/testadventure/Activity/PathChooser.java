package com.example.mateu.testadventure.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.mateu.testadventure.DataBase.DBHelper;
import com.example.mateu.testadventure.Player.Assassin;
import com.example.mateu.testadventure.Player.Mage;
import com.example.mateu.testadventure.Player.Warrior;
import com.example.mateu.testadventure.R;

public class PathChooser extends AppCompatActivity {

//    private static String idActivity="B1";
    RadioButton Female;
    RadioButton Male;
    RadioButton Warrior;
    RadioButton Mage;
    RadioButton Assassin;
    TextInputEditText name;
    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_chooser);
        Intent intent=getIntent();
        Male = findViewById(R.id.MaleRB);
        Mage = findViewById(R.id.MageRB);
        Mage.setChecked(true);
        Male.setChecked(true);

    }

    @Override
    public void onBackPressed() {

    }

    public void CreateCharacter(View view) {
        sqlSaver sqlSaver = new sqlSaver();
        sqlSaver.doInBackground();
    }

    public class sqlSaver extends AsyncTask<Context,Void,Void>
    {

        @Override
        protected Void doInBackground(Context... contexts) {
            Assassin = findViewById(R.id.AssassinRB);
            Mage = findViewById(R.id.MageRB);
            Warrior = findViewById(R.id.WarriorRB);
            Female = findViewById(R.id.FemaleRB);
            Male = findViewById(R.id.MaleRB);
            name = findViewById(R.id.Name);
            String wname = name.getText().toString();

            // sprawdzenie poprawności nicku
            if(name.getText().length()>12)
            {
                name.setError("Max 12 letters!");

            }
            else if(name.getText().length() == 0)
            {
                name.setError("Min 1 letter!");
            }

            // przydzielenie danych do odpowiednich obiektów w zależności od zaznaczonego elementu
            if(Warrior.isChecked()&&name.getText().length()<=12&&name.getText().length()>0)
            {
                Warrior w = new Warrior(wname);
                w.setsIdPlayer();
//            w.setIdActivityPlayer(idActivity);
                if(Female.isChecked())
                {
                    w.setcGender("K");
                }
                else
                {
                    w.setcGender("M");
                }

                try
                {
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues contentValues = new ContentValues();
                    contentValues.put("P_ID", w.getsIdPlayer());
//                contentValues.put("P_CURRENT_ACTIVITY", w.getIdActivityPlayer());
                    contentValues.put("P_CLASS", w.getType());
                    contentValues.put("P_NAME", w.getsName());
                    contentValues.put("P_GENDER", w.getcGender());
                    contentValues.put("P_HP", w.getiHp());
                    contentValues.put("P_AGILITY", w.getiAgility());
                    contentValues.put("P_STRENGTH", w.getiStrength());
                    contentValues.put("P_INTELLIGENCE", w.getiIntelligence());
                    contentValues.put("P_ATTACK", w.getiAttack());

                    db.insertOrThrow("player_table", null, contentValues);

                    db.close();

                    String[] dane = {w.getsIdPlayer(),w.getsName(),w.getType(),w.getcGender()};
                    Intent intent = new Intent(getApplicationContext(),StartGame.class);
                    intent.putExtra(EXTRA_MESSAGE,dane);
                    startActivity(intent);
                    finish();
                }
                catch (SQLException sqlEX)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Character with given name exisists!", Toast.LENGTH_LONG);
                    toast.show();
                }



            }
            else if(Mage.isChecked()&&name.getText().length()<=12&&name.getText().length()>0)
            {
                Mage m = new Mage(wname);
                m.setsIdPlayer();
//            m.setIdActivityPlayer(idActivity);
                if(Female.isChecked())
                {
                    m.setcGender("K");
                }
                else
                {
                    m.setcGender("M");
                }
                try
                {
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues contentValues = new ContentValues();
                    contentValues.put("P_ID", m.getsIdPlayer());
//                contentValues.put("P_CURRENT_ACTIVITY", m.getIdActivityPlayer());
                    contentValues.put("P_CLASS", m.getType());
                    contentValues.put("P_NAME", m.getsName());
                    contentValues.put("P_GENDER", m.getcGender());
                    contentValues.put("P_HP", m.getiHp());
                    contentValues.put("P_AGILITY", m.getiAgility());
                    contentValues.put("P_STRENGTH", m.getiStrength());
                    contentValues.put("P_INTELLIGENCE", m.getiIntelligence());
                    contentValues.put("P_ATTACK", m.getiAttack());

                    db.insertOrThrow("player_table", null, contentValues);

                    db.close();

                    String[] dane = {m.getsIdPlayer(),m.getsName(),m.getType(),m.getcGender()};
                    Intent intent = new Intent(getApplicationContext(),StartGame.class);
                    intent.putExtra(EXTRA_MESSAGE,dane);
                    startActivity(intent);
                    finish();
                }
                catch (SQLException sqlEX)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Character with given name exisists!", Toast.LENGTH_LONG);
                    toast.show();
                }


            }
            else if(Assassin.isChecked()&&name.getText().length()<=12&&name.getText().length()>0)
            {
                Assassin a = new Assassin(wname);
                a.setsIdPlayer();
//            a.setIdActivityPlayer(idActivity);
                if(Female.isChecked())
                {
                    a.setcGender("K");
                }
                else
                {
                    a.setcGender("M");
                }

                try
                {

                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues contentValues = new ContentValues();
                    contentValues.put("P_ID", a.getsIdPlayer());
                    contentValues.put("P_CLASS", a.getType());
                    contentValues.put("P_NAME", a.getsName());
                    contentValues.put("P_GENDER", a.getcGender());
                    contentValues.put("P_HP", a.getiHp());
                    contentValues.put("P_AGILITY", a.getiAgility());
                    contentValues.put("P_STRENGTH", a.getiStrength());
                    contentValues.put("P_INTELLIGENCE", a.getiIntelligence());
                    contentValues.put("P_ATTACK", a.getiAttack());

                    db.insertOrThrow("player_table", null, contentValues);
                    db.close();

                    String[] dane = {a.getsIdPlayer(),a.getsName(),a.getType(),a.getcGender()};
                    Intent intent = new Intent(getApplicationContext(),StartGame.class);
                    intent.putExtra(EXTRA_MESSAGE,dane);
                    startActivity(intent);
                    finish();
                }
                catch (SQLException sqlEX)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Character with given name exisists!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
            return null;
        }
    }


        //  TERAZ JEST ODCZYT
//        try
//        {
//            DBHelper dbHelper = new DBHelper(this);
//            SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//            Cursor cursor =db.query("weapon_table",null,null,null,null,null,null);
//            if(cursor.moveToFirst())
//            {
//                String id = cursor.getString(4);
//                Toast toast = Toast.makeText(this, id, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//            db.close();
//            cursor.close();
//        }
//        catch (SQLException sql)
//        {
//            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//        }

    }

