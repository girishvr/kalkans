package com.example.hp.videotest;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private VideoView vid;
    private ImageView ip, iv;
    private TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vid = (VideoView) findViewById(R.id.svid);
       // iv = (ImageView) findViewById(R.id.simg);
       // ip = (ImageView) findViewById(R.id.playimg);
        // t = (TextView) findViewById(R.id.textView1);
        //final ProgressDialog pd = new ProgressDialog(MainActivity.this);

        String link = "rtsp://r3---sn-a5meknel.googlevideo.com/Cj0LENy73wIaNAk2YfVIag-xBBMYDSANFC3QybdaMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/8F96FE5D9668F4CE216962E61F1BA85F30DAFA50.89D2A6CD40C00AD6DFBB04432EB33478628D88D9/yt6/1/video.3gp";
        String path1 = link;
        Uri uri = Uri.parse(path1);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vid);
        vid.setMediaController(mc);
        mc.setMediaPlayer(vid);
        vid.setVideoURI(uri);
        vid.requestFocus();
        vid.start();
//        ip.setClickable(true);
//        ip.setImageResource(R.drawable.play);
//        ip.setVisibility(ImageView.INVISIBLE);
//        vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                // TODO Auto-generated method stub
//                //ip.setVisibility(ImageView.VISIBLE);
//                pd.dismiss();
////
//            }
//        });
//        ip.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub



//
//                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                pd.setMessage("Loading Video...");
//                pd.setIndeterminate(false);
//                pd.setCancelable(true);
//                pd.show();
//
//                if (vid.isPlaying()) {
//                    iv.setVisibility(ImageView.INVISIBLE);
//                    ip.setVisibility(ImageView.INVISIBLE);
//                } else {
//                    iv.setVisibility(ImageView.VISIBLE);
//                    ip.setVisibility(ImageView.VISIBLE);
//                }


//                TextView text_view = (TextView) findViewById(R.id.textView1);
//                Typeface font = Typeface.createFromAsset(getAssets(), "floodd.ttf");
//                text_view.setTypeface(font);

//
//            public void onStop() {
//                onStop();
//            }


    }
    }
