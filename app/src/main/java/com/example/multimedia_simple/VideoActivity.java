package com.example.multimedia_simple;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by ZhangXinmin on 2017/7/5.
 * Copyright (c) 2017 . All rights reserved.
 */

public class VideoActivity extends AppCompatActivity {

    private Context mContext;
    private VideoView mVideoView;
    private Uri mVideoUri;
    private MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initParamsAndValues();
        initView();

        mVideoView.setVideoURI(mVideoUri);
//        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
                Toast.makeText(mContext, "开始播放视频", Toast.LENGTH_SHORT).show();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(mContext, "视频播放完毕", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initParamsAndValues() {
        mContext = this;
        String videoStr = "android.resource://" + getPackageName() + "/" + R.raw.cloud;
        mVideoUri = Uri.parse(videoStr);
        mMediaController = new MediaController(mContext);
    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.videoview);
    }
}
