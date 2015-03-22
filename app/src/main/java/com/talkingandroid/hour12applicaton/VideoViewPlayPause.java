package com.talkingandroid.hour12applicaton;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;


public class VideoViewPlayPause extends Activity {
    Boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_play_pause);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final TextView textView= (TextView) findViewById(R.id.textView);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        final Button pauseButton= (Button) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isPaused){
                    videoView.start();
                    pauseButton.setText("Pause");
                    isPaused=false;
                }else{
                    videoView.pause();
                    pauseButton.setText("Play");
                    isPaused=true;
                }
            }
        });


        String videoToPlay = "http://bffmedia.com/bigbunny.mp4";
        Uri video = Uri.parse(videoToPlay);
        videoView.setVideoURI(video);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            public void onPrepared(MediaPlayer mp) {
                int height = mp.getVideoHeight();
                int width = mp.getVideoWidth();
                int duration = mp.getDuration();
                textView.setText("Video: " + width +" " +height+ " " + duration +" milliseconds");
                progressBar.setVisibility(View.GONE);
                pauseButton.setVisibility(View.VISIBLE);
                videoView.requestFocus();
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.seekTo(0);
                isPaused = true;
                pauseButton.setText("Play");
            }
        });

    }

}
