package com.example.babyapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlanetFive extends AppCompatActivity {

    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,cardView9;
    private MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5,mediaPlayer6,mediaPlayer7,mediaPlayer8,mediaPlayer9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_five);

        cardView1 = findViewById(R.id.card_1);
        cardView2 = findViewById(R.id.card_2);
        cardView3 = findViewById(R.id.card_3);
        cardView4 = findViewById(R.id.card_4);
        cardView5 = findViewById(R.id.card_5);
        cardView6 = findViewById(R.id.card_6);
        cardView7 = findViewById(R.id.card_7);
        cardView8 = findViewById(R.id.card_8);
        cardView9 = findViewById(R.id.card_9);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.def_earth);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.def_sun);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.def_mercury);
        mediaPlayer4 = MediaPlayer.create(this,R.raw.def_mars);
        mediaPlayer5 = MediaPlayer.create(this,R.raw.def_jupiter);
        mediaPlayer6 = MediaPlayer.create(this,R.raw.def_saturn);
        mediaPlayer7 = MediaPlayer.create(this,R.raw.def_uranus);
        mediaPlayer8 = MediaPlayer.create(this,R.raw.def_neptune);
        mediaPlayer9 = MediaPlayer.create(this,R.raw.def_venus);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                    mediaPlayer1.seekTo(0);
                } else {
                    mediaPlayer1.start();
                }
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.pause();
                    mediaPlayer2.seekTo(0);
                } else {
                    mediaPlayer2.start();
                }
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer3.isPlaying()) {
                    mediaPlayer3.pause();
                    mediaPlayer3.seekTo(0);
                } else {
                    mediaPlayer3.start();
                }
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer4.isPlaying()) {
                    mediaPlayer4.pause();
                    mediaPlayer4.seekTo(0);
                } else {
                    mediaPlayer4.start();
                }
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer5.isPlaying()) {
                    mediaPlayer5.pause();
                    mediaPlayer5.seekTo(0);
                } else {
                    mediaPlayer5.start();
                }
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer6.isPlaying()) {
                    mediaPlayer6.pause();
                    mediaPlayer6.seekTo(0);
                } else {
                    mediaPlayer6.start();
                }
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer7.isPlaying()) {
                    mediaPlayer7.pause();
                    mediaPlayer7.seekTo(0);
                } else {
                    mediaPlayer7.start();
                }
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer8.isPlaying()) {
                    mediaPlayer8.pause();
                    mediaPlayer8.seekTo(0);
                } else {
                    mediaPlayer8.start();
                }
            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer9.isPlaying()) {
                    mediaPlayer9.pause();
                    mediaPlayer9.seekTo(0);
                } else {
                    mediaPlayer9.start();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer1 != null) {
            mediaPlayer1.release();
            mediaPlayer1 = null;
        }if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            mediaPlayer2 = null;
        }if (mediaPlayer3 != null) {
            mediaPlayer3.release();
            mediaPlayer3 = null;
        }if (mediaPlayer4 != null) {
            mediaPlayer4.release();
            mediaPlayer4 = null;
        }if (mediaPlayer5 != null) {
            mediaPlayer5.release();
            mediaPlayer5 = null;
        }if (mediaPlayer6 != null) {
            mediaPlayer6.release();
            mediaPlayer6 = null;
        }if (mediaPlayer7 != null) {
            mediaPlayer7.release();
            mediaPlayer7 = null;
        }if (mediaPlayer8 != null) {
            mediaPlayer8.release();
            mediaPlayer8 = null;
        }if (mediaPlayer9 != null) {
            mediaPlayer9.release();
            mediaPlayer9 = null;
        }

    }

}