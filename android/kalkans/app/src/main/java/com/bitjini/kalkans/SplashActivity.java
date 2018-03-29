package com.bitjini.kalkans;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    final String PREFS_NAME = "check";
    String MY_PREFS_NAME = "Name";

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       final boolean one= LoginActivity.oneTime;

        handler=new Handler();
        handler.postDelayed(new Runnable() {
          @Override
           public void run() {
               SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

                if (settings.getBoolean("my_first_time", true)) {
                    settings.edit().putBoolean("my_first_time", false).apply();



                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    // close this activity
                    finish();
                }

                else{
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        },1500);

    }
}
