package com.bitjini.kalkans;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    JSONObject jsonObject = null;
//public static android.content.SharedPreferences SharedPreferences = null;

    private static final String PREFER_NAME = "Reg";
    public static boolean oneTime = false;
    ProgressDialog pd;

    Button buttonLogin;

    EditText txtEmail, txtPassword;

    // User Session Manager Class
    UserSession session;

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button switchButton = (Button) findViewById(R.id.SignUp);
        switchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignAupctivity.class);
                startActivity(intent);

            }
        });


        // User Session Manager
        session = new UserSession(getApplicationContext());

        // get Email, Password input text
        txtEmail = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.Password);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isUserLoggedIn(), Toast.LENGTH_LONG).show();


        // User Login button
        buttonLogin = (Button) findViewById(R.id.login);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);


        // Login button click event
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                putName();
                // Get username, password from EditText
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                // Validate if username, password is filled
//                if (username.trim().length() > 0 && password.trim().length() > 0) {
//                    String uName = null;
//                    String uPassword = null;
//
//                    if (sharedPreferences.contains("Name")) {
//                        uName = sharedPreferences.getString("Name", "");
//
//                    }
//
//                    if (sharedPreferences.contains("txtPassword")) {
//                        uPassword = sharedPreferences.getString("txtPassword", "");
//
//                    }
//
//                    // Object uName = null;
//                    // Object uEmail = null;
//                    if (username.equals(uName) && password.equals(uPassword)) {
//
//                        oneTime = true;
//                        session.createUserLoginSession(uName, uPassword);
//
//                        // Starting MainActivity
//                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                        // Add new Flag to start new Activity
//                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(i);
//
//
//                        finish();
//
//                    } else {
//
//                        // username / password doesn't match&
//                        Toast.makeText(getApplicationContext(),
//                                "Username/Password is incorrect",
//                                Toast.LENGTH_LONG).show();
//
//                    }
//                } else {
//
//                    // user didn't entered username or password
//                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
//
//                }

                new JsonTask().execute("https://smartindia-ers.herokuapp.com/loginuser/",email,password);

            }
        });
       // new JsonTask().execute("https://smartindia-ers.herokuapp.com/loginuser/");

    }



    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(LoginActivity.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {



                Log.d("username",params[1]);
                Log.d("password",params[2]);
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("email", params[1]);
                connection.setRequestProperty("password", params[2]);
               // String contentType = connection.getHeaderField("user_id");
                connection.connect();
                InputStream stream = connection.getInputStream();

               // Log.d("contentType",contentType);

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                   // if(status == "Success"){
                    //load next page also save response in shared pref
                    //else
                    //show alert try again

                     }
                SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("Reg",0);
                SharedPreferences.Editor editor = sharedpreferences.edit();
               // String userObject = sharedpreferences.getString(buffer.toString(),"null");
                String userObject = buffer.toString();
                editor.putString("UserObject",userObject);
                editor.commit();
                return buffer.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                pd.dismiss();
            }
            //txtJson.setText(result);
        }
    }






    void putName() {
        SharedPreferences.Editor editor = getSharedPreferences(PREFER_NAME, MODE_PRIVATE).edit();
        editor.putString("Name", txtEmail.getText().toString());
        editor.apply();
    }

}

