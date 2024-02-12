package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        ImageView imageView = findViewById(R.id.splash_img);
        Glide.with(this).asGif().load(R.drawable.clevertouch).into(imageView);

        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        TextView textRegister = findViewById(R.id.button_register);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

/*
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5*1000);
                    startActivity(new Intent(MainActivity.this, loginActivity.class));
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
                super.run();
            }
        };thread.start();
*/
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