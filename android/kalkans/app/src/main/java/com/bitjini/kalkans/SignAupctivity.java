package com.bitjini.kalkans;
import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.apache.commons.codec.StringEncoder;
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
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SignAupctivity extends AppCompatActivity{
    String ServerURL = "https://smartindia-ers.herokuapp.com/users/" ;
    SharedPreferences sharedPreferences;
    Editor editor;
    String TempName;
    String TempEmail;
    String TempPhone;
    String TempCity;
    String TempEphone;
    String Templang;
    String TempDOB,Tempgender;
    Button Register;
    EditText txtUsername,txtPassword, txtEmail, txtPhone, txtEphone, txtCity, txtDob,txtlang,txtgender,txtadhar;
    UserSession session;
    ImageButton capture;
    ImageView photo;
    String userChoosenTask;
    private AwesomeValidation awesomeValidation;
    private static int RESULT_LOAD_IMAGE = 1;
    public static final int RequestPermissionCode = 1;

    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_aupctivity);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        txtUsername = (EditText) findViewById(R.id.Name);
        txtPassword = (EditText) findViewById(R.id.Pass);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPhone = (EditText) findViewById(R.id.pno);
        txtlang =(EditText) findViewById(R.id.lang);
        txtEphone = (EditText) findViewById(R.id.eno);
        txtCity = (EditText) findViewById(R.id.city);
        txtDob = (EditText) findViewById(R.id.dob);
        txtgender = (EditText) findViewById(R.id.gender);

        //txtadhar=(EditText) findViewsById(R.id.aadhar);
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
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById();
        setDateTimeField();


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
                String em_no = txtEphone.getText().toString();
                String city = txtCity.getText().toString();
                String DOB = txtDob.getText().toString();
                String lang = txtlang.getText().toString();
               // String adhar=txtadhar.getText().toString();
                String gender = txtgender.getText().toString();
                // as now we have information in string. Lets stored them with the help of editor
                editor.putString("Name", name);
                editor.putString("Email", email);
                editor.putString("txtPassword", pass);
                editor.putString("txtPhone", phone);
                editor.putString("txtEphone", em_no);
                editor.putString("txtCity", city);
                editor.putString("txtDob", DOB);
                editor.putString("txtlang",lang);
                editor.putString("txtgender",gender);
                //editor.putString("txtadhar",adhar);
                editor.commit(); // commit the values




                if (v == Register) {

                    submitForm();
                }

            }
        });
    }

    private void findViewsById() {
        txtDob= (EditText) findViewById(R.id.dob);
        txtDob.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {


            Calendar newCalendar = Calendar.getInstance();
            fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    txtDob.setText(dateFormatter.format(newDate.getTime()));
                }

            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        txtDob.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (view == txtDob) {
                    fromDatePickerDialog.show();
                }
            }
        });
    }



    private void submitForm() {
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
            GetData();

            InsertData(TempName, TempPhone,TempEmail,TempEphone,TempCity,TempDOB,Templang,Tempgender);

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

    public void GetData() {
        TempCity = txtCity.getText().toString();
        TempName = txtUsername.getText().toString();
        TempPhone = txtPhone.getText().toString();
      //  TempAdhar=txtadhar.getText().toString();
        TempDOB=txtDob.getText().toString();
        TempEphone = txtEphone.getText().toString();
        Templang = txtPassword.getText().toString();
        TempEmail = txtEmail.getText().toString();
        Tempgender=txtgender.getText().toString();


    }

    public void InsertData(final String name, final String phone, final String email, final String em_no, final String city,final  String DOB,final String lang,final String gender) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name;
                String EmailHolder = email;
                String numberHolder = phone;
                String nnumberHolder = em_no;
                String nnameHolder = city;
                String nnnumberHolder = DOB;
                String nnnameHolder=lang;
                String nnnnameHolder=gender;
               // String nnnaameHolder=adhar;

//                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//
//                nameValuePairs.add(new BasicNameValuePair("name", NameHolder));
//                nameValuePairs.add(new BasicNameValuePair("email", EmailHolder));
////                nameValuePairs.add(new BasicNameValuePair("phone", 9483));
////                nameValuePairs.add(new BasicNameValuePair("em_no", nnumberHolder));
//                nameValuePairs.add(new BasicNameValuePair("city", nnameHolder));
//                nameValuePairs.add(new BasicNameValuePair("DOB",nnnumberHolder));
//                nameValuePairs.add(new BasicNameValuePair("language",nnnameHolder));
//                nameValuePairs.add(new BasicNameValuePair("gender",nnnnameHolder));
//                nameValuePairs.add(new BasicNameValuePair("adhar","123"));
                JSONObject jObjectData = new JSONObject();

                try {

                    jObjectData.put("name", NameHolder);
                    jObjectData.put("email", EmailHolder);
                    jObjectData.put("phone", numberHolder);
                    jObjectData.put("em_no", nnumberHolder);
                    jObjectData.put("city", nnameHolder);
                    jObjectData.put("DOB", nnnumberHolder);
                    jObjectData.put("gender", nnnnameHolder);
                    jObjectData.put("adhar", "121212323434");
                    jObjectData.put("language", nnnameHolder);
                } catch (JSONException e) {
                    Log.e("MYAPP", "unexpected JSON exception", e);
                    // Do something to recover ... or kill the app.
                }
                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);
                    httpPost.addHeader("Content-type","application/json");

                    String json = jObjectData.toString();
                    StringEntity se = new StringEntity(json);

                    httpPost.setEntity(se);

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();

//                    if (httpEntity != null) {
//                        InputStream instream = httpEntity.getContent();
//                        String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
////                        String result = RestClient.convertStreamToString(instream);
//                        Log.i("Read from server", result);
//                    }
                        Log.d(EntityUtils.toString(httpEntity),"http entity");
                        Log.d(Integer.toString(httpResponse.getStatusLine().getStatusCode()),"http  response");


                } catch (ClientProtocolException e) {
                    Toast.makeText(SignAupctivity.this, "data submitting error", Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    Toast.makeText(SignAupctivity.this, "data submitting error ", Toast.LENGTH_LONG).show();

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                Toast.makeText(SignAupctivity.this, result, Toast.LENGTH_LONG).show();

                super.onPostExecute(result);


            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();


        sendPostReqAsyncTask.execute(name, email, phone, em_no, city, DOB,lang,gender);

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


