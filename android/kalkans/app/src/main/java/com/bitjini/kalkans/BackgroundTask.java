package com.bitjini.kalkans;

        import android.content.Context;
        import android.content.Intent;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.os.AsyncTask;
        import android.widget.Toast;

        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    /*public boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm != null ? cm.getAllNetworkInfo() : new NetworkInfo[0];
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }*/


    String res;

    Context ctx;
    BackgroundTask(SendSosActivity ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String regurl = "http://techtron.esy.es/emergencydb.php";

        String method = params[0];
        if(method.equals("sendourdata"))
        {
            String name = params[1];
            String phone = params[2];
            String email = params[3];
            String lat = params[5];
            String lon = params[6];
           // String desc = params[7];

            try {
                URL url = new URL(regurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("txtPhone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("lat","UTF-8")+"="+URLEncoder.encode(lat,"UTF-8")+"&"+
                        URLEncoder.encode("txtEphone","UTF-8")+"="+URLEncoder.encode(lat,"UTF-8")+"&"+
                        URLEncoder.encode("txtDob","UTF-8")+"="+URLEncoder.encode(lat,"UTF-8")+"&"+
                        URLEncoder.encode("lon","UTF-8")+"="+URLEncoder.encode(lon,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "Request Registered";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

        /*Intent i = new Intent(ctx, Score.class);
        i.putExtra("total",res);
        ctx.startActivity(i);*/



    }
}

