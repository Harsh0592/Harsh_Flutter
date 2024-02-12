package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class NineActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        CardView G_card = findViewById(R.id.N_card1);
        G_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                startActivity(new Intent(NineActivity.this,V5_1.class));
            }
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