package com.example.hp.downloadandplay;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity
{
    // Declaring layout widgets
    VideoView videoView;
    ProgressBar progressBar;
    Button btnDownload;
    TextView errorMsg;

    // Declaring connection variables
    Connection con;
    String un,password,db,ip;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the layouts on oncreate of the app
        videoView = (VideoView) findViewById(R.id.videoView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        errorMsg = (TextView) findViewById(R.id.errorMsg);
        btnDownload = (Button) findViewById(R.id.button);

        //Stopping progressbar first
        progressBar.setVisibility(View.GONE);

        // Initializing Connection Variables you need to change your database credentials below
        ip = "111.111.11.111:1111/"; //Change this ip with your Ip and also add port at the end with a slash
        db = "database"; //Change this Database name with yours
        un = "username"; // Change this username with your database username
        password = "password"; // Change this password with your database password

    }

    // function to download image from the server
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void downloadVideo(View view)
    {
        // Setting an Async Task so that main thread does not through exception
        DownloadVideo doin = new DownloadVideo();
        doin.execute();
    }

    // Async task ; a background method
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private class DownloadVideo extends AsyncTask<String, Void, String>
    {
        ResultSet Video = null;
        String data = "";
        String msg =  "";

        @Override
        protected void onPreExecute()
        {
            errorMsg.setText("Downloading Please Wait...");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params)
        {
            //Connecting to database
            con = ConnectionHelper(un, password, db, ip);
            if(con == null)
            {
                msg = "Error with the Internet Connectivity! Connect to valid connection!";
            }
            else
            {
                // Let us suppose here that the video that we are retrieving is present in a row with the videoId equal to '1'
                // PS: you need to change the query string according to the structure of your database
                // Must replace the query with your own need
                String command = "SELECT videoData FROM tableVideo WHERE videoId='1'";
                try
                {
                    Statement stmt = con.createStatement();
                    Video = stmt.executeQuery(command);
                    if(Video != null)
                    {
                        while (Video.next())
                        {
                            data = Video.getString(1);
                        }
                    }
                    msg = "Downloaded Successfully, Check Storage. Now Playing...";
                }
                // catching all the exceptions below
                catch (SQLException ex)
                {
                    msg = "Error Occurred! Try Again";
                    Log.d("Kamran error no 1", ex.getMessage().toString());
                }
                catch (IOError ex)
                {
                    msg = "Error Occurred! Try Again";
                    Log.d("Kamran error no 2", ex.getMessage().toString());
                }
                catch (AndroidRuntimeException ex)
                {
                    msg = "Error Occurred! Try Again";
                    Log.d("Kamran error no 3", ex.getMessage().toString());
                }
                catch (NullPointerException ex)
                {
                    msg = "Error Occurred! Try Again";
                    Log.d("Kamran error no 4", ex.getMessage().toString());
                }
                catch (Exception ex)
                {
                    msg = "Error Occurred! Try Again";
                    Log.d("Kamran error no 5", ex.getMessage().toString());
                }
            }
            return data;
        }

        @Override
        protected void onPostExecute(String resultSet)
        {
            //Stopping the progress bar and showing the message
            progressBar.setVisibility(View.GONE);
            errorMsg.setText(msg);
            if( resultSet != null)
            {
                byte[] decodeString = Base64.decode(resultSet, Base64.DEFAULT);
                try
                {
                    // Creating a new folder in to the device files storage i.e. media storage
                    File folder = new File(Environment.getExternalStorageDirectory() + "/SeotoolzzDownload");
                    boolean success = true;
                    if (!folder.exists())
                    {
                        success = folder.mkdir();
                    }
                    if (success)
                    {
                        // Do something on success
                        // Suppose the video you have uploaded was in mp4 video
                        // If the video you uploaded before was in other extension then must replace .mp4 below with the
                        // corresponding extension
                        String date = getCurrentTimeStamp().toString().replaceAll("[:-]","");
                        FileOutputStream out = new FileOutputStream(folder+"/"+date+".mp4");
                        out.write(decodeString);
                        out.flush();
                        out.close();
                        // Below is the Video URI, Check That Video has been Saved into the storage of your phone
                        // Must write correct path to play the video on your android phone
                        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SeotoolzzDownload/"+ date + ".mp4");

                        videoView.setVideoURI(uri);
                        videoView.start();
                    }
                    else
                    {
                        errorMsg.setText("Failed To Save Video!");
                    }
                }
                catch (Exception e)
                {
                    Log.e("Error", e.toString());
                }
            }
            else
            {
                errorMsg.setText("Error Downloading! Reload Again!");
            }
        }
    }
    // This function is used to connect to database server. It uses the library that we included
    @SuppressLint("NewApi")
    public Connection ConnectionHelper(String user, String password, String database, String server)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + server
                    + database + ";user=" + user
                    + ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("ERROR1", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR2", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR3", e.getMessage());
        }
        return connection;
    }

    //Checking if you are connected to any network or not
    public Boolean isInternetAvailable()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    // Getting current timestamp to write as a file name
    private static java.sql.Timestamp getCurrentTimeStamp()
    {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

}