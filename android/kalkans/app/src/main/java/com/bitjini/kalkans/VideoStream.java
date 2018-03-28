package com.bitjini.kalkans;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoStream extends AppCompatActivity {

    private VideoView vid;
    private ImageView ip, iv;
//    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vid = (VideoView) vid.findViewById(R.id.svid);
        iv = (ImageView) iv.findViewById(R.id.simg);
        ip = (ImageView) ip.findViewById(R.id.playimg);
        // t = (TextView) findViewById(R.id.textView1);

        // final ProgressDialog pd =  new ProgressDialog(getActivity(), R.layout.activity_sfaety_measures);
        final ProgressDialog pd = new ProgressDialog(VideoStream.this);




        String link = "https://m.youtube.com/watch?v=g6XLRu-bloc&itct=CAwQpDAYBSITCKnwk_a5h9oCFUp2aAod9ZQNKzIHcmVsYXRlZEiCsru11aj_hI4B&hl=en&gl=IN&client=mv-google\n";
        String path1 = link;
        Uri uri = Uri.parse(path1);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vid);
        vid.setMediaController(mc);
        mc.setMediaPlayer(vid);
        vid.setVideoURI(uri);
        vid.requestFocus();
        ip.setClickable(true);
        ip.setImageResource(R.drawable.play);
        ip.setVisibility(ImageView.INVISIBLE);
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

                if (vid.isPlaying()) {
                    iv.setVisibility(ImageView.INVISIBLE);
                    ip.setVisibility(ImageView.INVISIBLE);
                } else {
                    iv.setVisibility(ImageView.VISIBLE);
                    ip.setVisibility(ImageView.VISIBLE);
                }

            }
//
//            public void onStop() {
//                onStop();


        });
    }
}
