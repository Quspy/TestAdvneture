package com.example.mateu.testadventure.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.mateu.testadventure.R;

public class AboutUs extends AppCompatActivity {


    private static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.yourphoto);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void OptionOne(View view)
    {
        this.finish();
    }
}
