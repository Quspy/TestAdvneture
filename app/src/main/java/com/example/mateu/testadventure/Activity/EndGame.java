package com.example.mateu.testadventure.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mateu.testadventure.R;

public class EndGame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
    }

    @Override
    public void onBackPressed() {

    }

    public void OptionOne(View v)
    {
        Intent intent = new Intent(this,PathChooser.class);
        startActivity(intent);
        finish();
    }

    public void OptionTwo(View v)
    {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
