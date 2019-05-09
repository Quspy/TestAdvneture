package com.example.mateu.testadventure.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mateu.testadventure.R;

import java.util.Locale;

public class BT1_1 extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;
    private static int mCount=0;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_1);
        Intent intent = getIntent();
        name =intent.getStringArrayExtra(PathChooser.EXTRA_MESSAGE);
        if(mCount<1) {
            Toast toast = Toast.makeText(getApplicationContext(), "CHECKPOINT!", Toast.LENGTH_LONG);
            toast.show();
            mCount++;
        }
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count", mCount);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCount = savedInstanceState.getInt("count");
    }

    public void OptionOne(View v)
    {
        Intent intent = new Intent(this,BT111.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
        finish();
    }

    public void OptionTwo(View v)
    {
        Intent intent = new Intent(this,BT112.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
        finish();
    }
}
