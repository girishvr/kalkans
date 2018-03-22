package com.bitjini.kalkans;

        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.location.Criteria;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class FloodActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String provider;
    String lat, lon;
    TextView t1, t2;
    Button eme, saf;


    String name, phone, email, ephone, dob, city;
    // String ctype = "pothole";
    // String desc="Pot holes done!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood);
        eme = (Button) findViewById(R.id.button);
        saf = (Button) findViewById(R.id.button2);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        saf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FloodActivity.this,VideoStream.class);
                startActivity(i);
            }
        });
//        eme = new Button(this);


        eme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked();
            }
        });
    }

    public void clicked()

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

            if (location != null)
                onLocationChanged(location);
            else
                Toast.makeText(getBaseContext(), "Emergency Call Made! \n Location was not retrieved.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getBaseContext(), "Emergency Call Made! \n Switch on your GPS.", Toast.LENGTH_SHORT).show();
        }
      /*  name = getIntent().getExtras().getString("name");
        phone = getIntent().getExtras().getString("txtPhone");
        email = getIntent().getExtras().getString("email");
        ephone = getIntent().getExtras().getString("txtEphone");
        dob = getIntent().getExtras().getString("txtDob");
        city = getIntent().getExtras().getString("txtCity");*/


    }

    public void send(View view) {
        //msg = e.getText().toString().trim();

        String method = "flood";
        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method, name, phone, email, lat, lon, ephone, dob, city);

        // e.setText("");
    }


    @Override
    public void onLocationChanged(Location location) {

        t1.setText("Latitude : "+location.getLatitude());
        t2.setText("Longitude : "+location.getLongitude());
        Toast.makeText(getBaseContext(), "Emergency Call Made! \n Location Sent.", Toast.LENGTH_SHORT).show();


        lat = Double.toString(location.getLatitude());
        lon = Double.toString(location.getLongitude());

        String method = "sendData";
        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method,name,phone,email,lat,lon);

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


