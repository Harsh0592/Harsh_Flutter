package com.example.babyapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CalenderTwo extends AppCompatActivity {
    private CardView cardView_1,cardView_2,cardView_3,cardView_4,cardView_5,cardView_6,cardView_7,cardView_8,cardView_9,cardView_10,cardView_11,cardView_12;
    private MediaPlayer mediaPlayer_1,mediaPlayer_2,mediaPlayer_3,mediaPlayer_4,mediaPlayer_5,mediaPlayer_6,mediaPlayer_7,mediaPlayer_8,mediaPlayer_9,mediaPlayer_10,mediaPlayer_11,mediaPlayer_12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_two);
        cardView_1 = findViewById(R.id.card1);
        cardView_2 = findViewById(R.id.card2);
        cardView_3 = findViewById(R.id.card3);
        cardView_4 = findViewById(R.id.card4);
        cardView_5 = findViewById(R.id.card5);
        cardView_6 = findViewById(R.id.card6);
        cardView_7 = findViewById(R.id.card7);
        cardView_8 = findViewById(R.id.card8);
        cardView_9 = findViewById(R.id.card9);
        cardView_10 = findViewById(R.id.card10);
        cardView_11 = findViewById(R.id.card11);
        cardView_12 = findViewById(R.id.card12);

        mediaPlayer_1 = MediaPlayer.create(this, R.raw.january);
        mediaPlayer_2 = MediaPlayer.create(this,R.raw.february);
        mediaPlayer_3 = MediaPlayer.create(this,R.raw.march);
        mediaPlayer_4 = MediaPlayer.create(this,R.raw.april);
        mediaPlayer_5 = MediaPlayer.create(this,R.raw.may);
        mediaPlayer_6 = MediaPlayer.create(this,R.raw.june);
        mediaPlayer_7 = MediaPlayer.create(this,R.raw.july);
        mediaPlayer_8 = MediaPlayer.create(this,R.raw.august);
        mediaPlayer_9 = MediaPlayer.create(this,R.raw.september);
        mediaPlayer_10 = MediaPlayer.create(this,R.raw.october);
        mediaPlayer_11 = MediaPlayer.create(this,R.raw.november);
        mediaPlayer_12 = MediaPlayer.create(this,R.raw.december);
        cardView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_1.isPlaying()) {
                    mediaPlayer_1.pause();
                    mediaPlayer_1.seekTo(0);

                } else {
                    mediaPlayer_1.start();
                }
            }
        });
        cardView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_2.isPlaying()) {
                    mediaPlayer_2.pause();
                    mediaPlayer_2.seekTo(0);

                } else {
                    mediaPlayer_2.start();
                }
            }
        });

        cardView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_3.isPlaying()) {
                    mediaPlayer_3.pause();
                    mediaPlayer_3.seekTo(0);
                } else {
                    mediaPlayer_3.start();
                }
            }
        });
        cardView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_4.isPlaying()) {
                    mediaPlayer_4.pause();
                    mediaPlayer_4.seekTo(0);
                } else {
                    mediaPlayer_4.start();
                }
            }
        });
        cardView_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_5.isPlaying()) {
                    mediaPlayer_5.pause();
                    mediaPlayer_5.seekTo(0);
                } else {
                    mediaPlayer_5.start();
                }
            }
        });
        cardView_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_6.isPlaying()) {
                    mediaPlayer_6.pause();
                    mediaPlayer_6.seekTo(0);
                } else {
                    mediaPlayer_6.start();
                }
            }
        });
        cardView_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_7.isPlaying()) {
                    mediaPlayer_7.pause();
                    mediaPlayer_7.seekTo(0);
                } else {

                    mediaPlayer_7.start();
                }
            }
        });
        cardView_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_8.isPlaying()) {
                    mediaPlayer_8.pause();
                    mediaPlayer_8.seekTo(0);
                } else {
                    mediaPlayer_8.start();
                }
            }
        });
        cardView_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_9.isPlaying()) {
                    mediaPlayer_9.pause();
                    mediaPlayer_9.seekTo(0);
                } else {
                    mediaPlayer_9.start();
                }
            }
        });

        cardView_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_10.isPlaying()) {
                    mediaPlayer_10.pause();
                    mediaPlayer_10.seekTo(0);
                } else {
                    mediaPlayer_10.start();
                }
            }
        });

        cardView_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_11.isPlaying()) {
                    mediaPlayer_11.pause();
                    mediaPlayer_11.seekTo(0);
                } else {
                    mediaPlayer_11.start();
                }
            }
        });

        cardView_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer_12.isPlaying()) {
                    mediaPlayer_12.pause();
                    mediaPlayer_12.seekTo(0);
                } else {
                    mediaPlayer_12.start();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer_1 != null) {
            mediaPlayer_1.release();
            mediaPlayer_1 = null;
        }if (mediaPlayer_2 != null) {
            mediaPlayer_2.release();
            mediaPlayer_2 = null;
        }if (mediaPlayer_3 != null) {
            mediaPlayer_3.release();
            mediaPlayer_3 = null;
        }if (mediaPlayer_4 != null) {
            mediaPlayer_4.release();
            mediaPlayer_4 = null;
        }if (mediaPlayer_5 != null) {
            mediaPlayer_5.release();
            mediaPlayer_5 = null;
        }if (mediaPlayer_6 != null) {
            mediaPlayer_6.release();
            mediaPlayer_6 = null;
        }if (mediaPlayer_7 != null) {
            mediaPlayer_7.release();
            mediaPlayer_7 = null;
        }if (mediaPlayer_8 != null) {
            mediaPlayer_8.release();
            mediaPlayer_8 = null;
        }if (mediaPlayer_9 != null) {
            mediaPlayer_9.release();
            mediaPlayer_9 = null;
        }if (mediaPlayer_10 != null) {
            mediaPlayer_10.release();
            mediaPlayer_10 = null;
        }if (mediaPlayer_11 != null) {
            mediaPlayer_11.release();
            mediaPlayer_11 = null;
        }if (mediaPlayer_12 != null) {
            mediaPlayer_12.release();
            mediaPlayer_12 = null;
        }
    }
}