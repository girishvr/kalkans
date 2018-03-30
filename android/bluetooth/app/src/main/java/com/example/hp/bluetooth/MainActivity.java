package com.example.hp.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataOutputStream[] os = new DataOutputStream[1];

        final BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

        BroadcastReceiver discoveryResult = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String remoteDeviceName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
                BluetoothDevice remoteDevice;

                remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                Toast.makeText(getApplicationContext(), "Discovered: " + remoteDeviceName + " address " + remoteDevice.getAddress(), Toast.LENGTH_SHORT).show();

                try{
                    BluetoothDevice device = bluetooth.getRemoteDevice(remoteDevice.getAddress());

                    Method m = device.getClass().getMethod("createRfcommSocket", new Class[] {int.class});

                    BluetoothSocket clientSocket =  (BluetoothSocket) m.invoke(device, 1);

                    clientSocket.connect();

                    os[0] = new DataOutputStream(clientSocket.getOutputStream());

                    new clientSock().start();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("BLUETOOTH", e.getMessage());
                }
            }
        };

        registerReceiver(discoveryResult, new IntentFilter(BluetoothDevice.ACTION_FOUND));

        bluetooth.enable();
        if (!bluetooth.isDiscovering()) {
            bluetooth.startDiscovery();
        }

        class clientSock extends Thread {
            public void run () {
                try {
                    os[0].writeBytes("Hey"); // anything you want
                    os[0].flush();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    return;
                }
            }
        }
    }

}
