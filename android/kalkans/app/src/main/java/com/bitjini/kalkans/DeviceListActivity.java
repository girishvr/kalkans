package com.bitjini.kalkans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeviceListActivity extends AppCompatActivity {
    public static String DEVICE_ADDRESS = "deviceAddress";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_list);
    }
}
