package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private TextView textView;
    private MediaPlayer mediaPlayer;
    private int selectedTab = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        editTextNumber = findViewById(R.id.editTextNumber);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout activityLayout = findViewById(R.id.activityLayout);
        final LinearLayout gameLayout = findViewById(R.id.gameLayout);
        final LinearLayout storyLayout = findViewById(R.id.storyLayout);

        final ImageView homeImg = findViewById(R.id.homeImg);
        final ImageView activityImg = findViewById(R.id.activityImg);
        final ImageView gameImg = findViewById(R.id.gameImg);
        final ImageView storyImg = findViewById(R.id.storyImg);

        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView activityTxt = findViewById(R.id.activityTxt);
        final TextView gameTxt = findViewById(R.id.gameTxt);
        final TextView storyTxt = findViewById(R.id.storyTxt);

//getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                        .replace(R.id.bottomBar,HomeActivity.class)
//                                .commit();
//        startActivity(new Intent(Activities.this,Activities.class));

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
//                if (selectedTab != 1){
                startActivity(new Intent(QuestionActivity.this,HomeActivity.class));
                activityTxt.setVisibility(View.GONE);
                gameTxt.setVisibility(View.GONE);
                storyTxt.setVisibility(View.GONE);

                activityImg.setImageResource(R.drawable.activity2);
                gameImg.setImageResource(R.drawable.game2);
                storyImg.setImageResource(R.drawable.story2);

                activityLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                gameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                storyLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                homeTxt.setVisibility(View.VISIBLE);
                homeImg.setImageResource(R.drawable.home);
                homeLayout.setBackgroundResource(R.drawable.round_back_home_100);

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                homeLayout.startAnimation(scaleAnimation);

                selectedTab = 1;
//                }
            }
        });
        activityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                if (selectedTab != 2){
//                    startActivity(new Intent(Activities.this,Activities.class));
                    homeTxt.setVisibility(View.GONE);
                    gameTxt.setVisibility(View.GONE);
                    storyTxt.setVisibility(View.GONE);

                    homeImg.setImageResource(R.drawable.home2);
                    gameImg.setImageResource(R.drawable.game2);
                    storyImg.setImageResource(R.drawable.story2);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    gameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    storyLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    activityTxt.setVisibility(View.VISIBLE);
                    activityImg.setImageResource(R.drawable.activity);
                    activityLayout.setBackgroundResource(R.drawable.round_back_activities_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    activityLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }
            }
        });
        gameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                if (selectedTab != 3){
                    startActivity(new Intent(QuestionActivity.this,QuestionGame.class));
                    homeTxt.setVisibility(View.GONE);
                    activityTxt.setVisibility(View.GONE);
                    storyTxt.setVisibility(View.GONE);

                    homeImg.setImageResource(R.drawable.home2);
                    activityImg.setImageResource(R.drawable.activity2);
                    storyImg.setImageResource(R.drawable.story2);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    activityLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    storyLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    gameTxt.setVisibility(View.VISIBLE);
                    gameImg.setImageResource(R.drawable.game);
                    gameLayout.setBackgroundResource(R.drawable.round_back_games_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    gameLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }
            }
        });
        storyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                if (selectedTab != 4){

                    startActivity(new Intent(QuestionActivity.this,Stories.class));
                    homeTxt.setVisibility(View.GONE);
                    activityTxt.setVisibility(View.GONE);
                    gameTxt.setVisibility(View.GONE);

                    homeImg.setImageResource(R.drawable.home2);
                    activityImg.setImageResource(R.drawable.activity2);
                    gameImg.setImageResource(R.drawable.game2);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    activityLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    gameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    storyTxt.setVisibility(View.VISIBLE);
                    storyImg.setImageResource(R.drawable.story);
                    storyLayout.setBackgroundResource(R.drawable.round_back_stories_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    storyLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;
                }
            }
        });

        Button buttonq = findViewById(R.id.button_q);
        buttonq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                String textNumber = editTextNumber.getText().toString();

                if (TextUtils.isEmpty(textNumber)) {
                    Toast.makeText(QuestionActivity.this, "Please enter answer", Toast.LENGTH_SHORT).show();
                    editTextNumber.setError("Answer is required");
                    editTextNumber.requestFocus();
                } else if (textNumber.length() != 2) {
                    Toast.makeText(QuestionActivity.this, "Answer is in only 2 Number", Toast.LENGTH_SHORT).show();
                    editTextNumber.setError("Answer should be 2 number");
                    editTextNumber.requestFocus();
                } else if (!(textNumber.equals("25"))){
                    Toast.makeText(QuestionActivity.this, "Please enter correct answer", Toast.LENGTH_SHORT).show();
                    editTextNumber.setError("Correct answer is required ");
                    editTextNumber.requestFocus();
                }else {
                    Intent i = new Intent(QuestionActivity.this,Activities.class);
                    startActivity(i);
                    finish();
                }
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