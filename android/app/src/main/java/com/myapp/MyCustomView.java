package com.myapp;

import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_AUDIO_TRACK_RECEIVED;
import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_FIRST_AUDIO_DECODE;
import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_FIRST_VIDEO_DECODE;
import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_STATS_UPDATE;
import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_VIDEO_SIZE_CHANGE;
import static com.qiniu.droid.rtplayer.QNRTPlayer.INFO_VIDEO_TRACK_RECEIVED;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.qiniu.droid.rtplayer.QNError;
import com.qiniu.droid.rtplayer.QNRTPlayer;
import com.qiniu.droid.rtplayer.QNRTPlayerFactory;
import com.qiniu.droid.rtplayer.QNRTPlayerSetting;
import com.qiniu.droid.rtplayer.QNRTPlayerUrl;
import com.qiniu.droid.rtplayer.render.QNSurfaceView;

public class MyCustomView extends FrameLayout {
    QNSurfaceView mRenderView;
    QNRTPlayer mRTPlayer;
    QNRTPlayerUrl mRTUrl = new QNRTPlayerUrl();

    public MyCustomView(@NonNull Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.my_view, this);
        mRenderView = findViewById(R.id.render_view);
        mRTPlayer = QNRTPlayerFactory.createQNRTPlayer(getContext());
        mRTPlayer.initPlayer(new QNRTPlayerSetting());
        mRTPlayer.setSurfaceRenderWindow(mRenderView);
        mRTPlayer.setEventListener(new QNRTPlayer.EventListener() {
            @Override
            public void onPlayerStateChanged(int i) {
                Log.d("Daniel debug", "onPlayerStateChanged " + i);
            }

            @Override
            public void onPlayerInfo(int i, Object o) {
                switch (i) {
                    case INFO_FIRST_VIDEO_DECODE:
                        Log.d("Daniel debug", "收到第一个解码后的视频帧触发");
                        break;
                    case INFO_FIRST_AUDIO_DECODE:
                        Log.d("Daniel debug", "收到第一个解码后的音频帧触发");
                        break;
                    case INFO_VIDEO_SIZE_CHANGE:
                        Log.d("Daniel debug", "视频帧大小变化时触发");
                        break;
                    case INFO_AUDIO_TRACK_RECEIVED:
                        Log.d("Daniel debug", "媒体流收到音频轨道信息时触发");
                        break;
                    case INFO_VIDEO_TRACK_RECEIVED:
                        Log.d("Daniel debug", "媒体流收到视频轨道信息时触发");
                        break;
                    case INFO_STATS_UPDATE:
                        Log.d("Daniel debug", "播放器回调码率等信息时触发");
                        break;
                }
            }

            @Override
            public void onPlayerError(QNError qnError) {
                Log.d("Daniel debug", "onPlayerError " + qnError.mCode + qnError.mDescription);
            }
        });
        setUrl("");
    }

    public void setUrl(String videoPath) {
        mRTUrl.setURL("https://live-pilidemo.cloudvdn.com/pilidemo/timestamp.m3u8");
        mRTUrl.setHttpPost(false);
        mRTPlayer.playUrl(mRTUrl);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("Daniel debug", "onDetachedFromWindow");
    }
}
