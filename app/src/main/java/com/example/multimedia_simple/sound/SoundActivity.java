package com.example.multimedia_simple.sound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.multimedia_simple.R;

/**
 * Created by ZhangXinmin on 2017/7/5.
 * Copyright (c) 2017 . All rights reserved.
 * 播放音频
 */

public class SoundActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParamsAndValues();

    }

    private void initParamsAndValues() {
        mContext = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sound, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sound_pool://使用SoundPool
                Intent pool = new Intent(mContext, SoundPoolActivity.class);
                startActivity(pool);
                break;
            case R.id.sound_media://使用MediaPlayer
                Intent media = new Intent(mContext, MediaPlayerActivity.class);
                startActivity(media);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
