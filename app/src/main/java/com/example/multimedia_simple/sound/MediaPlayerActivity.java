package com.example.multimedia_simple.sound;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.multimedia_simple.R;

/**
 * Created by ZhangXinmin on 2017/7/9.
 * Copyright (c) 2017 . All rights reserved.
 */

public class MediaPlayerActivity extends AppCompatActivity {

    private Context mContext;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initParamsAndValues();

    }

    private void initParamsAndValues() {
        mContext = this;
        mMediaPlayer = MediaPlayer.create(mContext, R.raw.titanium);
        mMediaPlayer.start();

    }
}
