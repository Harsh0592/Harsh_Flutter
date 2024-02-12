package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Activities extends AppCompatActivity {

    private ImageView imageView;
    private LinearLayout linearLayout;
    private TextView textView;
    float v = 0;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int selectedTab = 1;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        mediaPlayer = MediaPlayer.create(this, R.raw.click);
//        tabLayout = findViewById(R.id.tab_layout);

//
//        tabLayout.addTab(tabLayout.newTab().setText("2 to 4"));
//        tabLayout.addTab(tabLayout.newTab().setText("5 to 9"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final ActivityAdapter adapter = new ActivityAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.setTranslationY(300);
//        tabLayout.setAlpha(v);
//        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();



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
                    startActivity(new Intent(Activities.this,HomeActivity.class));
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
                    startActivity(new Intent(Activities.this,QuestionGame.class));
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

                    startActivity(new Intent(Activities.this,Stories.class));
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

        ImageView account = findViewById(R.id.acc);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                startActivity(new Intent(Activities.this,UserProfileActivity.class));

            }
        });
        View five_to_nine = findViewById(R.id.activity_5to9_include);
        View two_to_four = findViewById(R.id.activity_2to4_include);
        CardView cardView1 = findViewById(R.id.activityCard_2to4);
        CardView cardView2 = findViewById(R.id.activityCard_5to9);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                five_to_nine.setVisibility(View.GONE);
                two_to_four.setVisibility(View.VISIBLE);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                five_to_nine.setVisibility(View.VISIBLE);
                two_to_four.setVisibility(View.GONE);
            }
        });
        CardView G_card1 = findViewById(R.id.N_card1);
        G_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                startActivity(new Intent(Activities.this,V5_1.class));
            }
        });
        CardView G_card2 = findViewById(R.id.F_card1);
        G_card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                startActivity(new Intent(Activities.this,V2_1.class));
            }
        });
//        ImageView acc = findViewById(R.id.imageView12);
//        acc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Activities.this,V2_1.class));
//
//            }
//        });
//        ImageView ac = findViewById(R.id.imageView13);
//        ac.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Activities.this,V5_1.class));
//
//            }
//        });

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