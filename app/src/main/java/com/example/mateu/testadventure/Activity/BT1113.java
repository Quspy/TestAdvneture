package com.example.mateu.testadventure.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mateu.testadventure.DataBase.DBHelper;
import com.example.mateu.testadventure.Player.Assassin;
import com.example.mateu.testadventure.Player.Mage;
import com.example.mateu.testadventure.Player.Warrior;
import com.example.mateu.testadventure.R;

public class BT1113 extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1113);
        Intent intent = getIntent();
        name =intent.getStringArrayExtra(PathChooser.EXTRA_MESSAGE);
    }

    @Override
    public void onBackPressed() {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.My_hero) {
            Intent intent = new Intent(this,HeroProfile.class);
            intent.putExtra(EXTRA_MESSAGE,name);
            startActivity(intent);
        }
        else if (id == R.id.abuot_us) {
            Intent intent = new Intent(this,AboutUs.class);
            intent.putExtra(EXTRA_MESSAGE,name);
            startActivity(intent);
        }
        else if(id == R.id.night_mode)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "In future version.", Toast.LENGTH_LONG);
            toast.show();
        }
        else if(id == R.id.change_language)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "In future version.", Toast.LENGTH_LONG);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void OptionOne(View v)
    {
        sqlSaver sqlSaver = new sqlSaver();
        sqlSaver.doInBackground();
        Intent intent = new Intent(getApplicationContext(),BT11111_FIGHT.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
        finish();
    }

    public class sqlSaver extends AsyncTask<Context,Void,Void>
    {

        @Override
        protected Void doInBackground(Context... contexts) {
            if(name[2].equals("Warrior"))
            {
                Warrior w = new Warrior(name[1]);
                w.setsIdPlayer(name[0]);
                try
                {
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues contentValues1 = new ContentValues();
                    contentValues1.put("P_HP",5);

                    db.update("player_table",contentValues1,"P_ID = ?",new String[]{w.getsIdPlayer()});

                    db.close();
                }
                catch (SQLException ex)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "There is problem with database", Toast.LENGTH_LONG);
                    toast.show();
                }
                Intent intent = new Intent(getApplicationContext(),BT11111_FIGHT.class);
                intent.putExtra(EXTRA_MESSAGE,name);
                startActivity(intent);
            }
            else if(name[2].equals("Assassin"))
            {
                Assassin a = new Assassin(name[1]);
                a.setsIdPlayer(name[0]);

                try
                {
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues contentValues1 = new ContentValues();
                    contentValues1.put("P_HP",5);

                    db.update("player_table",contentValues1,"P_ID = ?",new String[]{a.getsIdPlayer()});

                    db.close();
                }
                catch (SQLException ex)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "There is problem with database", Toast.LENGTH_LONG);
                    toast.show();
                }
                Intent intent = new Intent(getApplicationContext(),BT11111_FIGHT.class);
                intent.putExtra(EXTRA_MESSAGE,name);
                startActivity(intent);
            }
            else
            {
                Mage m = new Mage(name[1]);
                m.setsIdPlayer(name[0]);
                try
                {
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();


                    ContentValues contentValues1 = new ContentValues();
                    contentValues1.put("P_HP",5);

                    db.update("player_table",contentValues1,"P_ID = ?",new String[]{m.getsIdPlayer()});

                    db.close();
                }
                catch (SQLException ex)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "There is problem with database", Toast.LENGTH_LONG);
                    toast.show();
                }
                Intent intent = new Intent(getApplicationContext(),BT11111_FIGHT.class);
                intent.putExtra(EXTRA_MESSAGE,name);
                startActivity(intent);
            }
            return null;
        }
    }
}
