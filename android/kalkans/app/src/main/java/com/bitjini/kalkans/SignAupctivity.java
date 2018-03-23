package com.bitjini.kalkans;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class SignAupctivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Editor editor;
    Button Register;
    EditText txtUsername, txtPassword, txtEmail, txtPhone, txtEphone, txtCity, txtDob;
    UserSession session;
    ImageButton capture;
    ImageView photo;
    String userChoosenTask;
    private AwesomeValidation awesomeValidation;
    private static int RESULT_LOAD_IMAGE = 1;
    public static final int RequestPermissionCode = 1;


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
        capture = (ImageButton) findViewById(R.id.capture);
        photo = (ImageView) findViewById(R.id.photo);

        EnableRuntimePermission();

        awesomeValidation.addValidation(this, R.id.Name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.Email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.Pass, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.pno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.eno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.city, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);


// creating an shared Preference file for the information to be stored
// first argument is the name of file and second is the mode, 0 is private mode


        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectImage();
            }
        });

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        Register.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String name = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                String phone = txtPhone.getText().toString();
                String ephone = txtEphone.getText().toString();
                String city = txtCity.getText().toString();
                String dob = txtDob.getText().toString();

                // as now we have information in string. Lets stored them with the help of editor
                editor.putString("Name", name);
                editor.putString("Email", email);
                editor.putString("txtPassword", pass);
                editor.putString("txtPhone", phone);
                editor.putString("txtEphone", ephone);
                editor.putString("txtCity", city);
                editor.putString("txtDob", dob);
                editor.commit(); // commit the values

                if (v == Register) {
                    submitForm();
                }

            }
        });
    }

    private void submitForm() {
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
            Intent ob = new Intent(SignAupctivity.this, LoginActivity.class);
            startActivity(ob);
            //process the data further
        }
    }

    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SignAupctivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = UtilSignupActivity.checkPermission(SignAupctivity.this);
                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent() {

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 7);
    }

    private void galleryIntent() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            onSelectFromGalleryResult(data);
        }
       else if (requestCode == 7 && resultCode == RESULT_OK) {
            onCaptureImageResult(data);
        }

    }

    private void onCaptureImageResult(Intent data){
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        photo.setImageBitmap(bitmap);

    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        photo.setImageURI(selectedImageUri);
    }

        public void EnableRuntimePermission(){

            if (ActivityCompat.shouldShowRequestPermissionRationale(SignAupctivity.this,
                    Manifest.permission.CAMERA))
            {

                Toast.makeText(SignAupctivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

            } else {

                ActivityCompat.requestPermissions(SignAupctivity.this,new String[]{
                        Manifest.permission.CAMERA}, RequestPermissionCode);

            }
        }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(SignAupctivity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(SignAupctivity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    }


