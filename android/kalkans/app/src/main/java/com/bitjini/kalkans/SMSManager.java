package com.bitjini.kalkans;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMSManager extends BroadcastReceiver {

    static String infoSMS = "";

    //String ServerURL = "http://smartindia-ers.herokuapp.com/calamitys/";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the message
        Bundle extras = intent.getExtras();

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
                Toast.makeText(context, infoSMS, Toast.LENGTH_LONG).show();

            }
/* NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            String MyText = "Reminder";
           // Notification mNotification = new Notification(R.drawable.notification_icon, MyText, System.currentTimeMillis() );
            //The three parameters are: 1. an icon, 2. a title, 3. time when the notification appears

            String MyNotificationTitle = "Alert!!";
            String MyNotificationText  = infoSMS;

            Intent MyIntent = new Intent(Intent.ACTION_VIEW);
            PendingIntent StartIntent = PendingIntent.getActivity(getApplicationContext(),0,MyIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            //A PendingIntent will be fired when the notification is clicked. The FLAG_CANCEL_CURRENT flag cancels the pendingintent

            mNotification.setLatestEventInfo(getApplicationContext(), MyNotificationTitle, MyNotificationText, StartIntent);

            int NOTIFICATION_ID = 1;
            notificationManager.notify(NOTIFICATION_ID , mNotification);
        }
    }*/
        }
    }
}