package com.example.hp.videotest;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VideoView vid;
    private ImageView ip, iv;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vid=(VideoView) findViewById(R.id.svid);
        iv=(ImageView) findViewById(R.id.simg);
        ip = (ImageView) findViewById(R.id.playimg);
        t=(TextView) findViewById(R.id.textView1);
        final ProgressDialog pd=new ProgressDialog(MainActivity.this);

        String link = "http://www.w3schools.com/html5/movie.mp4";
        String path1=link;
        Uri uri = Uri.parse(path1);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vid);
        vid.setMediaController(mc);
        mc.setMediaPlayer(vid);
        vid.setVideoURI(uri);
        vid.requestFocus();
        ip.setClickable(true);
        ip.setImageResource(R.drawable.play);
        // ip.setVisibility(ImageView.INVISIBLE);
        vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                //ip.setVisibility(ImageView.VISIBLE);
                pd.dismiss();

            }
        });
        ip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                vid.start();
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.setMessage("Loading Video...");
                pd.setIndeterminate(false);
                pd.setCancelable(true);
                pd.show();

                if(vid.isPlaying()){
                    iv.setVisibility(ImageView.INVISIBLE);
                    ip.setVisibility(ImageView.INVISIBLE);
                }else{
                    iv.setVisibility(ImageView.VISIBLE);
                    ip.setVisibility(ImageView.VISIBLE);
                }

            }
        });

    }
}
