package com.bitjini.kalkans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{

//public static android.content.SharedPreferences SharedPreferences = null;

    private static final String PREFER_NAME = "Reg";
    public static boolean oneTime=false;

    Button buttonLogin;

    EditText txtUsername, txtPassword;

    // User Session Manager Class
    UserSession session;

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button switchButton = (Button)findViewById(R.id.SignUp);
        switchButton.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignAupctivity.class);
                startActivity(intent);

            }
        });


        // User Session Manager
        session = new UserSession(getApplicationContext());

        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.Password);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isUserLoggedIn(), Toast.LENGTH_LONG).show();


        // User Login button
        buttonLogin = (Button) findViewById(R.id.login);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);


        // Login button click event
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                // Validate if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0){
                    String uName = null;
                    String uPassword =null;

                    if (sharedPreferences.contains("Name"))
                    {
                        uName = sharedPreferences.getString("Name", "");

                    }

                    if (sharedPreferences.contains("txtPassword"))
                    {
                        uPassword = sharedPreferences.getString("txtPassword", "");

                    }

                    // Object uName = null;
                    // Object uEmail = null;
                    if(username.equals(uName) && password.equals(uPassword)){

                        oneTime = true;
                        session.createUserLoginSession(uName,uPassword);

                        // Starting MainActivity
                        Intent i = new  Intent(getApplicationContext(),MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);


                        finish();

                    }else{

                        // username / password doesn't match&
                        Toast.makeText(getApplicationContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG).show();

                    }
                }else{

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
