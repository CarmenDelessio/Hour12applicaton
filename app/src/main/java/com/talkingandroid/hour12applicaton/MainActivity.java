package com.talkingandroid.hour12applicaton;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    String[] choices;
    ListView choicesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        choices = resources.getStringArray(R.array.choices_array);
        choicesListView = (ListView) findViewById(R.id.listView);
        choicesListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, choices));
        choicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String videoToPlay = "http://bffmedia.com/bigbunny.mp4";
                        Uri videoUri = Uri.parse(videoToPlay);
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(videoUri, "video/mp4");
                        startActivity(intent);
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, VideoViewActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, VideoViewMediaControllerActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, VideoViewPlayPause.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, AudioActivity.class));
                        break;
                }

            }
        });
    }

}
