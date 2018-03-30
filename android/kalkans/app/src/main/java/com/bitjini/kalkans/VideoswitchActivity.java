package com.bitjini.kalkans;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoswitchActivity extends YouTubeBaseActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public final static String API_KEY = "AIzaSyAcdrNGE6tqB70RfYOsnu1KMxQ9nwgDkOM";

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    Button safetytip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_activiti);

        // hin = (Button) findViewById(R.id.button3);
        safetytip = (Button) findViewById(R.id.button4);
        //   safetytip=(Button)findViewById(R.id.saftytips);

        safetytip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  final  Intent i = new Intent(VideoswitchActivity.this, SlideActivity.class);


                youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube2);
                youTubePlayerView.initialize(API_KEY, onInitializedListener);

                onInitializedListener = new YouTubePlayer.OnInitializedListener() {

                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.loadVideo("link");


                        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
                        editor = sharedPreferences.edit();
                        boolean commit = editor.commit();
                        String currentsos = "";

                        switch (currentsos) {
                            case "Flood": Intent i = new Intent(VideoswitchActivity.this, SlideActivity.class);
                                String link = "RQxrWDBzJO4";
                                startActivity(i);
                                break;
                            case "Fire":
                                i = new Intent(VideoswitchActivity.this, SlideActivity.class);
                                link = "6iYJUbs9msk";
                                startActivity(i);
                                break;
                            case "Earthquke":
                                link = "BLEPakj1YTY";
                                break;
                            case "Accidents":
                                link = "7ClH977D0Yg";
                                break;
                            case "Medical_Emergency":
                                link = "EOjWDMoxf1U";
                                break;
                            case "Terrorist":
                                link = "ZwULI5wMtuY";
                                break;
                            case "Tsunami":
                                link = "o4J7U-doTeI";
                                break;
                            case "Women_safety":
                                link = "94V828qSPqE";
                                break;

                        }
                    }


                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                };


            }
        });
    }
}

