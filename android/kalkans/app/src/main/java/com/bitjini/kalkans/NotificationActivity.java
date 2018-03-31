package com.bitjini.kalkans;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
/*
public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(null, mBuilder.build());

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
                intent = new Intent(NotificationActivity.this, SendSosActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext)
                        .setSmallIcon(R.drawable.lock)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);



            }
        }
    }*/



