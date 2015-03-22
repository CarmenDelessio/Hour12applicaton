package com.talkingandroid.hour12applicaton;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;

public class AudioActivity extends Activity {
    MediaPlayer mediaPlayer = new MediaPlayer();
    AssetFileDescriptor audioFileDescriptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

    }
    @Override
    protected void onResume() {
        super.onResume();
        try {
            audioFileDescriptor = getAssets().openFd("helloworld.mp3");
            mediaPlayer.setDataSource(audioFileDescriptor.getFileDescriptor());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

}
