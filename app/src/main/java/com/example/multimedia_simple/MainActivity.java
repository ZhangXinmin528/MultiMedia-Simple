package com.example.multimedia_simple;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.multimedia_simple.sound.SoundActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParamsAndValues();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.media_vedio://视频
                Intent video = new Intent(mContext, VideoActivity.class);
                startActivity(video);
                break;
            case R.id.media_sound://音频
                Intent sound = new Intent(mContext, SoundActivity.class);
                startActivity(sound);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
