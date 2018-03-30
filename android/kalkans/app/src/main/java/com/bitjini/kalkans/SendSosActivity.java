package com.bitjini.kalkans;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SendSosActivity extends AppCompatActivity implements LocationListener {
    String ServerURL = "http://smartindia-ers.herokuapp.com/calamitys/" ;
    LocationManager locationManager;
    String provider;
    String lat, lon;
    TextView t1, t2;
    Button eme, saf;
    String phoneNo;
    String message;
    Context ctx;
    String userChoosenTask;
   // String MY_PREFS_NAME = "Name";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    private VideoView vid;
    private ImageView ip, iv;
    private TextView t;
    static int x=0;

    String name, phone, email, ephone, dob, city;
    final String PREFS_NAME = "check";
    String MY_PREFS_NAME = "Name";

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

       /* locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
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
        }*/
        saf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SendSosActivity.this,SlideActivity.class);

                startActivity(i);
            }
        });

        eme.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                clicked();

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

                if (settings.getBoolean("Sent", true)) {
                    settings.edit().putBoolean("Sent", false).commit();
                    x=x+1;
                    sending();

                }
                else {
                    final CharSequence[] items = {"OK","CANCEL","Go through safety tips"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(SendSosActivity.this);
                    builder.setTitle("Did help arrive?If not,press 'OK' to resend alert");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            boolean result = UtilSignupActivity.checkPermission(SendSosActivity.this);
                            if (items[item].equals("OK")) {
                                userChoosenTask = "OK";
                                if (result)
                                    sending();

                            } else if (items[item].equals("Cancel")) {
                                dialog.dismiss();
                            }
                            else if(items[item].equals("Go through safety tips")){
                                Intent i = new Intent(SendSosActivity.this, SlideActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                    builder.show();
                }
                return false;
            }
        });
    }

    public void sending() {
       // BackgroundTask backgroundTask = new BackgroundTask(SendSosActivity.this);
        if (isConnectingToInternet(SendSosActivity.this)) {
            String method = "flood";
            Toast.makeText(getApplicationContext(), "internet is available", Toast.LENGTH_LONG).show();
            //backgroundTask.execute(method, name, phone, email, lat, lon, ephone, dob, city);
            sendMessageInternet(lat,lon);

        } else {
            final CharSequence[] items = {"OK","CANCEL"};
            AlertDialog.Builder builder = new AlertDialog.Builder(SendSosActivity.this);
            builder.setTitle("Internet is not available.Would you like to send an SMS?");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    boolean result = UtilSignupActivity.checkPermission(SendSosActivity.this);
                    if (items[item].equals("OK")) {
                        userChoosenTask = "OK";
                        if (result)
                            sendSMSMessage();

                    } else if (items[item].equals("Cancel")) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();
            //Context context = null;
           // check();
        }
    }
          /*  public void check () {
        Context context=null;
               final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.alert_dialog_box);
                dialog.setTitle("Alert!");
                Button dialogButton = dialog.findViewById(R.id.ok);
                Button cancel = dialog.findViewById(R.id.cancel);
                // set the custom dialog components - text, image and button
                //TextView text = (TextView) dialog.findViewById(R.id.nonet);
                //text.setText("Android custom dialog example!");


                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendSMSMessage();
                        // dialog.dismiss();
                    }
                });


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }



        //Toast.makeText(getApplicationContext(),"internet is not available",Toast.LENGTH_LONG).show();*/





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

        }else {
            Toast.makeText(getBaseContext(), "Emergency Call Made! \n Switch on your GPS.", Toast.LENGTH_SHORT).show();
        }
    }

    public void send(View view){
        //msg = e.getText().toString().trim();

        String method = "flood";
        if (isConnectingToInternet(SendSosActivity.this)) {
            sendMessageInternet(lat,lon);
        }
        else{
            sendSMSMessage();
        }
    }

    public  boolean isConnectingToInternet(Context context)
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

public void sendMessageInternet(final String lat,final String lon)
{
    class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            SharedPreferences sharedpreferences = getSharedPreferences("Reg",0);
            //String name = sharedpreferences.getString("Name","not found");
            // String phone = sharedpreferences.getString("txtPhone","not found");
            String currentsos=sharedpreferences.getString("Curentsos","not found");

            JSONObject jObjectData = new JSONObject();

            try {

               jObjectData.put("etype", currentsos);
                jObjectData.put("user_id", "1");
                 jObjectData.put("status","SOS");
                jObjectData.put("text","  ");
                jObjectData.put("lat", lat);
                jObjectData.put("lon", lon);
                jObjectData.put("timestamp","10:20");


            } catch (JSONException e) {
                Log.e("MYAPP", "unexpected JSON exception", e);
                // Do something to recover ... or kill the app.
            }
            try {
                HttpClient httpClient = new DefaultHttpClient();

                HttpPost httpPost = new HttpPost(ServerURL);
                httpPost.addHeader("Content-type", "application/json");

                String json = jObjectData.toString();
                StringEntity se = new StringEntity(json);

                httpPost.setEntity(se);

                HttpResponse httpResponse = httpClient.execute(httpPost);

                HttpEntity httpEntity = httpResponse.getEntity();
                Log.d(EntityUtils.toString(httpEntity), "http entity");
                Log.d(Integer.toString(httpResponse.getStatusLine().getStatusCode()), "http  response");


            } catch (ClientProtocolException e) {
                Toast.makeText(SendSosActivity.this, "data submitting error", Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                Toast.makeText(SendSosActivity.this, "data submitting error", Toast.LENGTH_LONG).show();

            }
            return "Data Inserted Successfully";
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(SendSosActivity.this, result, Toast.LENGTH_LONG).show();

            super.onPostExecute(result);
        }

        public void execute( String etype,String userid,String status,String text,String lat,String lon,String timestamp) {
        }
    }

    SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

    sendPostReqAsyncTask.execute(lat,lon);
}


    public void sendSMSMessage()
    {
        SharedPreferences sharedpreferences = getSharedPreferences("Reg",0);
        String name = sharedpreferences.getString("Name","not found");
       // String phone = sharedpreferences.getString("txtPhone","not found");
        String currentsos=sharedpreferences.getString("Curentsos","not found");
        phoneNo = "9108516990";
        message = currentsos+" "+name+"  "+lat+" " +lon;

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
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();

                }
            }
        }}

    @Override
    public void onLocationChanged(Location location) {

//        t1.setText("Latitude : "+location.getLatitude());
    //    t2.setText("Longitude : "+location.getLongitude());
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


