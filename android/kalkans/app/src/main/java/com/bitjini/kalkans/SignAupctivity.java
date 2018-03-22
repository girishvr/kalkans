package com.bitjini.kalkans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class SignAupctivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    Editor editor;
    Button Register;
    EditText txtUsername, txtPassword, txtEmail,txtPhone,txtEphone,txtCity,txtDob;
    UserSession session;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_aupctivity);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        txtUsername = (EditText) findViewById(R.id.Name);
        txtPassword = (EditText) findViewById(R.id.Pass);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPhone = (EditText) findViewById(R.id.pno);
        txtEphone = (EditText) findViewById(R.id.eno);
        txtCity = (EditText) findViewById(R.id.city);
        txtDob = (EditText) findViewById(R.id.dob);
        Register = (Button) findViewById(R.id.register);

        awesomeValidation.addValidation(this, R.id.Name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.Email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.Pass, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.pno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.eno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.city, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);


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

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("txtPassword",pass);
                    editor.putString("txtPhone",phone);
                    editor.putString("txtEphone",ephone);
                    editor.putString("txtCity",city);
                    editor.putString("txtDob",dob);
                    editor.commit(); // commit the values

                if (v == Register) {
                    submitForm();
                }

                // after saving the value open next activity
               // Intent ob = new Intent(SignAupctivity.this, LoginActivity.class);
                //startActivity(ob);

            }
        });

    }
    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
            Intent ob = new Intent(SignAupctivity.this, LoginActivity.class);
            startActivity(ob);
            //process the data further
        }
    }

}