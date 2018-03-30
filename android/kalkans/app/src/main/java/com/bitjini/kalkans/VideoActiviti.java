package com.bitjini.kalkans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoActiviti extends YouTubeBaseActivity {

    Button safetytip;
    public static final String API_KEY = "AIzaSyAcdrNGE6tqB70RfYOsnu1KMxQ9nwgDkOM";

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

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
                Intent i = new Intent(VideoActiviti.this,SlideActivity.class);
                startActivity(i);
            }
        });
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube1);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("RQxrWDBzJO4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(API_KEY, onInitializedListener);

    }
}

