package com.example.com.emergency;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.example.hp.emergency.R;
//import com.example.hp.emergency.homeActivity;

public class Splash extends AppCompatActivity {
    private static int SPLASH_tIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_tIME_OUT);
    }
}