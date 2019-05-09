package com.example.mateu.testadventure.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import com.example.mateu.testadventure.R;

public class BT12212_SNEAK extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;
    private  static String weaponID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt12212_sneak);
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

        if(weaponID!=null)
        {
            Intent intent = new Intent(this,BigFight.class);
            intent.putExtra(EXTRA_MESSAGE,name);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(this,BigFightForLoosers.class);
            intent.putExtra(EXTRA_MESSAGE,name);
            startActivity(intent);
            finish();
        }

    }

    public class sqlSaver extends AsyncTask<Context,Void,Void>
    {

        @Override
        protected Void doInBackground(Context... contexts) {

            try
            {

                DBHelper dbHelper = new DBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                Cursor cursor =db.query("player_table",null,"P_ID = ?",new String[]{name[0]},null,null,null);
                if(cursor.moveToFirst())
                {
                    weaponID = cursor.getString(9);
                }
                db.close();


                Intent intent = new Intent(getApplicationContext(),StartGame.class);
                intent.putExtra(EXTRA_MESSAGE,name);
                startActivity(intent);

            }
            catch (SQLException sqlEX)
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Character with given name exisists!", Toast.LENGTH_LONG);
                toast.show();
            }

            return null;
        }
    }

}
