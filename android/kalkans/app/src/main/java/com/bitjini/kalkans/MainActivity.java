package com.bitjini.kalkans;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String MY_PREFS_NAME = "Name";

    private TextView hello;
    private CardView EarthquakeCard, WomenSafetyCard, TheftCard, TerroristCard, FloodCard, MedicalEmergencyCard, LandSlidesCard, AccidentsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(!isUsrLoggedIn){
//            //show login page
//        }else{
//
//        }


        FloodCard = (CardView) findViewById(R.id.Flood_card);
        AccidentsCard = (CardView) findViewById(R.id.Accidents_card);
        MedicalEmergencyCard = (CardView) findViewById(R.id.Medical_Emergency_card);
        LandSlidesCard = (CardView) findViewById(R.id.Land_Slides_card);
        EarthquakeCard = (CardView) findViewById(R.id.Earthquake_card);
        TheftCard = (CardView) findViewById(R.id.Theft_card);
        TerroristCard = (CardView) findViewById(R.id.Terrorist_card);
        WomenSafetyCard = (CardView) findViewById(R.id.Women_Safety_card);
       // hello=(TextView)findViewById(R.id.hello);

       //hello.setText(String.format("Hello %s!", getName()));


        FloodCard.setOnClickListener(this);
        AccidentsCard.setOnClickListener(this);
        MedicalEmergencyCard.setOnClickListener(this);
        LandSlidesCard.setOnClickListener(this);
        EarthquakeCard.setOnClickListener(this);
        TheftCard.setOnClickListener(this);
        TerroristCard.setOnClickListener(this);
        WomenSafetyCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent I;
        switch (v.getId()) {
            case R.id.Flood_card:
                I = new Intent(this, FloodActivity.class);
                Intent i = new Intent(MainActivity.this, FloodActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
               // i.putExtra("Aadhar", getAadhar());
                //i.putExtra("Lang", getLang());
                startActivity(I);
                break;

            case R.id.Accidents_card:
                I = new Intent(this, AccidentActivity.class);
                startActivity(I);
                break;
            case R.id.Medical_Emergency_card:
                I = new Intent(this, MedicalEmergencyActivity.class);
                startActivity(I);
                break;
            case R.id.Land_Slides_card:
                I = new Intent(this, LandSlidesActivity.class);
                startActivity(I);
                break;
            case R.id.Earthquake_card:
                I = new Intent(this, EarthquakeActivity.class);
                startActivity(I);
                break;
            case R.id.Theft_card:
                I = new Intent(this, TheftActivity.class);
                startActivity(I);
                break;
            case R.id.Terrorist_card:
                I = new Intent(this, TerroristActivity.class);
                startActivity(I);
                break;
            case R.id.Women_Safety_card:
                I = new Intent(this, WomenSafetyActivity.class);
                startActivity(I);
                break;
            default:
                break;

        }
    }


    String getName() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("Name", null);
        return name;

    }

    String getEmail() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String Email = prefs.getString("Email", null);
        return Email;

    }

    String getPhone() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String phone = prefs.getString("txtPhone", null);
        return phone;

    }

    String getEphone() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String ephone = prefs.getString("txtEphone", null);
        return ephone;

    }

    /*String getAadhar() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String aadhar = prefs.getString("aadhar", null);
        return aadhar;

    }*/

    String getCity() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String city = prefs.getString("txtCity", null);
        return city;

    }

   /* String getLang() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String lang = prefs.getString("lang", null);
        return lang;

    }*/

    String getDob() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String dob = prefs.getString("txtDob", null);
        return dob;

    }
}






