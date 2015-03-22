package com.talkingandroid.hour12applicaton;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.widget.VideoView;
import android.widget.MediaController;



public class VideoViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String videoToPlay = "http://bffmedia.com/bigbunny.mp4";
        Uri video = Uri.parse(videoToPlay);
        videoView.setVideoURI(video);
        videoView.start();
    }

}


