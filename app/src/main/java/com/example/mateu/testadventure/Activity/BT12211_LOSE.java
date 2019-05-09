package com.example.mateu.testadventure.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mateu.testadventure.R;

public class BT12211_LOSE extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.mateu.testadventure.MESSAGE";
    private static String []name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt12211__lose);
        Intent intent = getIntent();
        name =intent.getStringArrayExtra(PathChooser.EXTRA_MESSAGE);
    }

    public void OptionOne(View v)
    {
        Intent intent = new Intent(this,BigFightForLoosers.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
        finish();
    }
}
