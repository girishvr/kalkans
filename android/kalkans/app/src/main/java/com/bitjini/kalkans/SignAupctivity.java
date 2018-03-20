package com.bitjini.kalkans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignAupctivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    Editor editor;
    Button Register;
    EditText txtUsername, txtPassword, txtEmail,txtPhone,txtEphone,txtCity,txtDob;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_aupctivity);

        txtUsername = (EditText) findViewById(R.id.Name);
        txtPassword = (EditText) findViewById(R.id.Pass);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPhone = (EditText) findViewById(R.id.pno);
        txtEphone = (EditText) findViewById(R.id.eno);
        txtCity = (EditText) findViewById(R.id.city);
        txtDob = (EditText) findViewById(R.id.dob);
        Register = (Button) findViewById(R.id.register);

// creating an shared Preference file for the information to be stored
// first argument is the name of file and second is the mode, 0 is private mode

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        Register.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                String name = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                String phone = txtPhone.getText().toString();
                String ephone = txtEphone.getText().toString();
                String city = txtCity.getText().toString();
                String dob = txtDob.getText().toString();

                if(txtUsername.getText().length()<=0){
                    Toast.makeText(SignAupctivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( txtEmail.getText().length()<=0){
                    Toast.makeText(SignAupctivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                else if( txtPassword.getText().length()<=0){
                    Toast.makeText(SignAupctivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else if(txtPhone.getText().length()<10) {
                    Toast.makeText(SignAupctivity.this, "Enter Valid number", Toast.LENGTH_SHORT).show();
                }
                else if(txtEphone.getText().length()<10) {
                    Toast.makeText(SignAupctivity.this, "Enter Valid number", Toast.LENGTH_SHORT).show();
                }
                else if(txtCity.getText().length()<=0) {
                    Toast.makeText(SignAupctivity.this, "Enter city", Toast.LENGTH_SHORT).show();
                }
                else if(txtDob.getText().length()<=0) {
                    Toast.makeText(SignAupctivity.this, "Enter date of birth", Toast.LENGTH_SHORT).show();
                }

                else{

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("txtPassword",pass);
                    editor.putString("txtPhone",phone);
                    editor.putString("txtEphone",ephone);
                    editor.putString("txtCity",city);
                    editor.putString("txtDob",dob);
                    editor.commit();}   // commit the values

                // after saving the value open next activity
                Intent ob = new Intent(SignAupctivity.this, LoginActivity.class);
                startActivity(ob);

            }
        });
    }

}