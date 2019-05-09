package com.example.mateu.testadventure.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mateu.testadventure.R;

public class BT111111 extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt111111);
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
        Intent intent = new Intent(this,BigFight.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
        finish();
    }
}
