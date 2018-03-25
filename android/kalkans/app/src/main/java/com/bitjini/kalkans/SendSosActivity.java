package com.bitjini.kalkans;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Region;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SendSosActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String provider;
    String lat, lon;
    TextView t1, t2;
    Button eme, saf;
    String phoneNo;
    String message;
    Context ctx;
    String MY_PREFS_NAME = "Name";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    String name, phone, email, ephone, dob, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sos);
        eme = (Button) findViewById(R.id.button);
        saf = (Button) findViewById(R.id.button2);

//        t1 = (TextView) findViewById(R.id.textViewlat);
//        t2 = (TextView) findViewById(R.id.textViewlon);
//
//

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        provider = locationManager.getBestProvider(criteria, false);

        if (provider != null && !provider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 1000, 1, this);

            if (location != null)
                onLocationChanged(location);
            else
                Toast.makeText(getBaseContext(), "Emergency Call Made! \n Location was not retrieved.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getBaseContext(), "Emergency Call Made! \n Switch on your GPS.", Toast.LENGTH_SHORT).show();
        }
        saf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SendSosActivity.this, SfaetyMeasures.class);

                startActivity(i);
            }
        });



        eme.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //clicked();
                sending();
                return false;
            }
        });
    }
    public void sending()
    {
        BackgroundTask backgroundTask = new BackgroundTask(SendSosActivity.this);
        if(isConnectingToInternet(SendSosActivity.this))
        {
            String method = "flood";
            Toast.makeText(getApplicationContext(),"internet is available",Toast.LENGTH_LONG).show();
            backgroundTask.execute(method, name, phone, email, lat, lon, ephone, dob, city);
        }
        else {
            sendSMSMessage();
            Toast.makeText(getApplicationContext(),"internet is not available",Toast.LENGTH_LONG).show();

        }
    }

    /*public void clicked()

    {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        provider = locationManager.getBestProvider(criteria, false);

        if (provider != null && !provider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 1000, 1, this);

            if (location != null) {
                onLocationChanged(location);
            }
            else
                Toast.makeText(getBaseContext(), "Emergency Call Made! \n Location was not retrieved.", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getBaseContext(), "Emergency Call Made! \n Switch on your GPS.", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void send(View view){
        //msg = e.getText().toString().trim();

        String method = "flood";
        BackgroundTask backgroundTask = new BackgroundTask(SendSosActivity.this);
        if (isConnectingToInternet(SendSosActivity.this)) {
            backgroundTask.execute(method, name, phone, email, lat, lon, ephone, dob, city);
        }
        else{
            sendSMSMessage();
        }
    }

    public static boolean isConnectingToInternet(Context context)
    {
        ConnectivityManager connectivity =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
        }
        return false;
    }


    public void sendSMSMessage()
    {
        SharedPreferences sharedpreferences = getSharedPreferences("Reg",0);
        String name = sharedpreferences.getString("Name","not found");
        String phone = sharedpreferences.getString("txtPhone","not found");
        String currentsos=sharedpreferences.getString("Curentsos","not found");
        phoneNo = "9108516990";
        message = currentsos+" "+name+" "+phone+" "+lat+" " +lon;

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNo, null, message, null, null);  // adding number and text
        } catch (Exception e) {
            Toast.makeText(this, "Sms not Send", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();

                }
            }
        }}

    @Override
    public void onLocationChanged(Location location) {

        t1.setText("Latitude : "+location.getLatitude());
        t2.setText("Longitude : "+location.getLongitude());
        Toast.makeText(getBaseContext(), "Emergency Call Made! \n Location Sent.", Toast.LENGTH_SHORT).show();

        lat = Double.toString(location.getLatitude());
        lon = Double.toString(location.getLongitude());

        String method = "sendData";
        // BackgroundTask backgroundTask = new BackgroundTask(this);

        //backgroundTask.execute(method,name,phone,email,lat,lon);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}


