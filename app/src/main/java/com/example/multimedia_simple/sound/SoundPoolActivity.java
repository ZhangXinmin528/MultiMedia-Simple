package com.example.multimedia_simple.sound;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.multimedia_simple.R;

/**
 * Created by ZhangXinmin on 2017/7/9.
 * Copyright (c) 2017 . All rights reserved.
 * 讲解SoundPool的使用:
 * 1.特点：
 * 1>播放较短声音片段；
 * 2>支持从程序中(APK)加载,或者文件系统加载；
 * 3>更低的CPU占有量和更低的延迟；
 * 4>同时播放多条音频流；
 * 5>可以设置循环播放(a non-zero loop);
 * 6>可以修改声音播放的比率；
 * 7>可以设定播放音频的优先级；
 * 8>播放完毕，需要释放资源；
 * 2.应用：
 * 适用于播放短音频（短促，密集，延迟小）；
 */

public class SoundPoolActivity extends AppCompatActivity {
    private Context mContext;
    private SoundPool mSoundPool;
    private AudioManager mAudioManager;
    private int mSoundId;
    private float mCurrentVol;//当前音量
    private float mMaxVol;//最大音量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);

        initParamsAndValues();

        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMethod(mSoundId, 0, 1.0f);
            }
        });

    }

    private void initParamsAndValues() {
        mContext = this;
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);//管理器
        mSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        mSoundId = mSoundPool.load(mContext, R.raw.sound_click, 1);//id
        mCurrentVol = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mMaxVol = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

    }

    /**
     * 播放音频
     *
     * @param soundId Id
     * @param loop    loop mode (0 = no loop, -1 = loop forever)
     * @param rate    playback rate (1.0 = normal playback, range 0.5 to 2.0)
     */
    private void playMethod(int soundId, int loop, float rate) {
        float leftVol = mCurrentVol / mMaxVol;
        mSoundPool.play(soundId, leftVol, 1.0f, 1, loop, rate);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mSoundPool != null)
            mSoundPool.autoPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mSoundPool != null) {
            mSoundPool.stop(mSoundId);
            mSoundPool.release();
        }
    }
}
