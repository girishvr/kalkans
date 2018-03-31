package com.bitjini.kalkans;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
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
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


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
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                String currentsos="Flood";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                final int b=SendSosActivity.x;
                if(b!=0)
                {
                    FloodCard.setCardBackgroundColor(Color.GRAY);
                    //FloodCard = (CardView) findViewById(R.id.Flood_card);
                }
                I = new Intent(this, SendSosActivity.class);
                Intent i = new Intent(MainActivity.this, SendSosActivity.class);
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
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="Fire";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                 i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Medical_Emergency_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                 currentsos="MedicalEmergency";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Land_Slides_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="Earthquake";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                 i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Earthquake_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="Accident";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                 i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Theft_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="WomenSafety";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                 i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Terrorist_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="Terrorist";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
                startActivity(I);
                break;
            case R.id.Women_Safety_card:
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPreferences.edit();
                currentsos="Tsunami";
                editor.putString("Curentsos",currentsos);
                editor.commit();
                I = new Intent(this, SendSosActivity.class);
                i = new Intent(MainActivity.this, SendSosActivity.class);
                i.putExtra("Name", getName());
                i.putExtra("Email", getEmail());
                i.putExtra("txtPhone", getPhone());
                i.putExtra("txtEphone", getEphone());
                i.putExtra("txtCity", getCity());
                i.putExtra("txtDob", getDob());
                I = new Intent(this, SendSosActivity.class);
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

    public class SMSManager extends BroadcastReceiver {

        String infoSMS = "";

        //String ServerURL = "http://smartindia-ers.herokuapp.com/calamitys/";
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get the message
            Bundle extras = intent.getExtras();
            String x = "1";

            // Set object message in android device
            SmsMessage[] smgs = null;
            // Content SMS message

            if (extras != null) {
                // Retrieve the SMS message received
                Object[] pdus = (Object[]) extras.get("pdus");
                smgs = new SmsMessage[pdus.length];
                for (int i = 0; i < smgs.length; i++) {
                    smgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    infoSMS = smgs[i].getMessageBody().toString();

                    SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("Reg", 0);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    // String userObject = sharedpreferences.getString(buffer.toString(),"null");
                    String infosms = infoSMS;
                    editor.putString("InfoSMS", infosms);
                    editor.putString("X", x);
                    editor.commit();

                }
                Context mContext = null;
// Create an explicit intent for an Activity in your app
                intent = new Intent(MainActivity.this, SendSosActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext)
                        .setSmallIcon(R.drawable.lock)
                        .setContentTitle("My notification")
                        .setContentText(infoSMS)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);



            }
        }
    }
}







