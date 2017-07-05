package com.example.multimedia_simple;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ZhangXinmin on 2017/7/5.
 * Copyright (c) 2017 . All rights reserved.
 */

public class SoundActivity extends AppCompatActivity {
    private Context mContext;
    private SoundPool mSoundPool;
    private AudioManager mAudioManager;
    private int mSoundId;
    private float mCurrentVol;//当前音量
    private float mMaxVol;//最大音量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_sound);

        initParamsAndValues();

        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMethod(mSoundId, 0, 1.0f);
//                SoundUtil.playClickSound(mContext);
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
        mSoundPool.play(soundId, leftVol, 1.0f, 1, loop, 1.0f);
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
            mSoundPool.release();
        }
    }
}
