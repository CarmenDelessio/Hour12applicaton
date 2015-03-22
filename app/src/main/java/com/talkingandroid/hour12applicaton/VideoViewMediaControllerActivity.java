package com.talkingandroid.hour12applicaton;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoViewMediaControllerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        String videoToPlay = "http://bffmedia.com/bigbunny.mp4";
        Uri video = Uri.parse(videoToPlay);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();
    }

}


