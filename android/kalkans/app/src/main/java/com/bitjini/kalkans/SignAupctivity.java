package com.bitjini.kalkans;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignAupctivity extends AppCompatActivity{
    String ServerURL = "http://techtron.esy.es/userdb.php" ;
    SharedPreferences sharedPreferences;
    Editor editor;
    String TempName;
    String TempEmail;
    String TempPhone;
    String TempCity;
    String TempEphone;
    String Templang;
    Button Register;
    EditText txtUsername, txtPassword, txtEmail,txtPhone,txtEphone,txtCity,txtDob;
    UserSession session;
    ImageButton capture;
    String userChoosenTask;
    private AwesomeValidation awesomeValidation;
    private static int SELECT_FILE=1;
    private static int REQUEST_CAMERA=1;
    private static int RESULT_LOAD_IMAGE=1;
    private final int requestCode = 20;
    final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;
    private Uri fileUri;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;


    Uri imageUri                      = null;
    static TextView imageDetails      = null;
    public  static ImageView showImg  = null;
    SignAupctivity CameraActivity = null;


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
            GetData();
            InsertData(TempName, TempPhone,TempEmail,TempCity,TempEphone);

            Intent ob = new Intent(SignAupctivity.this, LoginActivity.class);
            startActivity(ob);
            //process the data further
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(SignAupctivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = UtilSignupActivity.checkPermission(SignAupctivity.this);
                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";
                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent() {

    }
    private void galleryIntent()
    {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView photo = (ImageView) findViewById(R.id.photo);
            photo.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
    public void GetData(){
        TempCity = txtCity.getText().toString();
        TempName = txtUsername.getText().toString();
        TempPhone = txtPhone.getText().toString();
        TempCity = txtCity.getText().toString();
        TempEphone = txtEphone.getText().toString();
        Templang = txtPassword.getText().toString();
        TempEmail = txtEmail.getText().toString();

    }
    public void InsertData(final String name, final String phone, final String email, final String ephone, final String city){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name ;
                String EmailHolder = email ;
                String numberHolder = phone ;
                String nnumberHolder = ephone ;
                String nnameHolder = city ;



                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("email", EmailHolder));
                nameValuePairs.add(new BasicNameValuePair("phone", numberHolder));
                nameValuePairs.add(new BasicNameValuePair("ephone", nnumberHolder));
                nameValuePairs.add(new BasicNameValuePair("city", nnameHolder));



                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {
                } catch (IOException e) {
                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                Toast.makeText(SignAupctivity.this,"data submitted Successfully", Toast.LENGTH_LONG).show();

                super.onPostExecute(result);


            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(name, email, phone, ephone, city);
    }

}


       /* @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case UtilSignupActivity.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ivImage.setImageBitmap(bm);
    }

    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ivImage.setImageBitmap(bm);
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ivImage.setImageBitmap(thumbnail);
    }

    File destination = new File(Environment.getExternalStorageDirectory(),
            System.currentTimeMillis() + ".jpg");

    FileOutputStream fo;
        try {
        try {
            destination.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            fo = new FileOutputStream(destination);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        fo.write(bytes.toByteArray());
        try {
            fo.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }*/




