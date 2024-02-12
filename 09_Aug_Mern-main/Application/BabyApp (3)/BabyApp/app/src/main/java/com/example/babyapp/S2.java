package com.example.babyapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class S2 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        VideoView videoView = findViewById(R.id.videoViews2);
        String vPath = "android.resource://"+getPackageName()+"/"+R.raw.s2;
        Uri uri = Uri.parse(vPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        View like= findViewById(R.id.imageLike2);
        View unLike= findViewById(R.id.imageUnLike2);

        like.setOnClickListener(v->{
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else {
                mediaPlayer.start();
            }
            like.setVisibility(View.GONE);
            unLike.setVisibility(View.VISIBLE);
        });

        unLike.setOnClickListener(v->{
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else {
                mediaPlayer.start();
            }
            like.setVisibility(View.VISIBLE);
            unLike.setVisibility(View.GONE);
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}