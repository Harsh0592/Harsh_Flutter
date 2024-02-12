package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {
    private TextView textViewWelcome, textViewFullName,textViewEmail,textViewDOB, textViewGender,textViewChildName;
    private ProgressBar progressBar;
    private String fullName,email,dob,gender,childName;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private TextView textView;
    private int selectedTab = 1;
    private MediaPlayer mediaPlayer;
    private FirebaseAuth authProfile;
    private SwipeRefreshLayout swipeContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
//        getSupportActionBar().setTitle("Clever Touch");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
//        startActivity(new Intent(UserProfileActivity.this,HomeActivity.class));
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
                    startActivity(new Intent(UserProfileActivity.this,HomeActivity.class));
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
                    startActivity(new Intent(UserProfileActivity.this,QuestionActivity.class));
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
                    startActivity(new Intent(UserProfileActivity.this,QuestionGame.class));
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

                    startActivity(new Intent(UserProfileActivity.this,Stories.class));
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

//        Button buttonUpdateProfile = findViewById(R.id.button_update_profile);
//        buttonUpdateProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserProfileActivity.this, UpdateProfileActivity.class);
//                startActivity(intent);
//            }
//        });
//        Button buttonLogout = findViewById(R.id.button_Logout);
//        buttonLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


//        swipeToRefresh();

//         textViewWelcome = findViewById(R.id.textView_show_welcome);
//        textViewFullName = findViewById(R.id.textView_show_full_name);
        textViewEmail = findViewById(R.id.textView_show_email);
        textViewDOB = findViewById(R.id.textView_show_dob);
        textViewGender = findViewById(R.id.textView_show_gender);
        textViewChildName = findViewById(R.id.textView_show_child_name);
        progressBar = findViewById(R.id.progress_bar);

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        if (firebaseUser == null){
            Toast.makeText(UserProfileActivity.this, "Something went wrong! User's details are not available at the moment.", Toast.LENGTH_LONG).show();
        }else {
//
            progressBar.setVisibility(View.VISIBLE);
//            showUserProfile(firebaseUser);

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            reference.child("Register Users").child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Map map = (Map) snapshot.getValue();

//                    Log.d("ENimesh","dataaa = " + map.get("email"));
//                    Log.d("ENimesh","data= "+map.get("yourName"));
//                    Log.d("ENimesh","dataa= "+map.get("dob"));
//                    Log.d("ENimesh","dataaaa= "+map.get("gender"));
//                    Log.d("ENimesh","dat= "+map.get("fullName"));

                    childName = String.valueOf(map.get("YourName"));
                email = firebaseUser.getEmail();
                dob = String.valueOf(map.get("DOB"));
                gender= String.valueOf(map.get("Gender"));


//                dob = map.get("dob");

//                fullName = readUserDetails.yourName;

                    textViewChildName.setText(childName);
                    textViewEmail.setText(email);
                    textViewDOB.setText(dob);
                    textViewGender.setText(gender);
//                    textViewFullName.setText(fullName);

//                }
                    progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

//            reference.child("Register Users").child(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    Map m = new HashMap((Map) snapshot.getValue());
//                    Map map = (Map) snapshot.getValue();
//
//                    Map map  = (Map) snapshot.getValue();
//                    Log.d("ENimesh","stttt" + map.get("dob"));
//                    Log.d("ENimesh","siz" + map.size());
//                    Log.d("ENImesh" , "Data = "+String.valueOf(m.get("dob")));
//                    ReadWriteUserDetails readUserDetails = snapshot.getValue();
//                    Log.d("ENimesh","Data = "+ firebaseUser.getDisplayName());
//                if (readUserDetails != null){
//                childName = firebaseUser.getDisplayName();
//                email = firebaseUser.getEmail();

//                dob = readUserDetails.dob;
//                gender = readUserDetails.gender;
//                fullName = readUserDetails.yourName;

//                    Log.d("Enimesh","Data = "+childName);

//                    textViewChildName.setText(childName);
//                    textViewEmail.setText(email);
//                    textViewDOB.setText(dob);
//                    textViewGender.setText(gender);
//                    textViewFullName.setText(fullName);
//
////                }
//                    progressBar.setVisibility(View.GONE);
//                }

//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });


//            Log.d("ENimesh", "User = "+firebaseUser);
        }
    }

//    private void swipeToRefresh() {
//        swipeContainer = findViewById(R.id.swipeContainer);
//        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                startActivity(getIntent());
//                finish();
//                overridePendingTransition(0,0);
//                swipeContainer.setRefreshing(false);
//            }
//        });
//
//        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
//                android.R.color.holo_orange_light,android.R.color.holo_red_light);
//
//    }

//    private void checkIfEmailVerified(FirebaseUser firebaseUser) {
//        if (!firebaseUser.isEmailVerified()){
//            showAlertDialog();
//        }
//    }

//    private void showAlertDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(UserProfileActivity.this);
//        builder.setTitle("Email Not Verified");
//        builder.setMessage("Please Verify your Email now. You can not login without email verification next time.");
//
//        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_APP_EMAIL);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

//    private void showUserProfile(FirebaseUser firebaseUser) {
//        String userID = firebaseUser.getUid();
//
////        Log.d("ENimesh","user idddd = "+firebaseUser.getEmail());
//
//        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");
//
//        referenceProfile.child(userID).addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
//                Log.d("ENimesh","Data = "+ firebaseUser.getDisplayName());
////                if (readUserDetails != null){
////                childName = firebaseUser.getDisplayName();
////                email = firebaseUser.getEmail();
////                dob = readUserDetails.dob;
////                gender = readUserDetails.gender;
////                fullName = readUserDetails.yourName;
//
//                Log.d("Enimesh","Data = "+childName);
//
//                textViewChildName.setText("childName");
//                textViewEmail.setText("email");
//                textViewDOB.setText("dob");
//                textViewGender.setText("gender");
//                textViewFullName.setText("fullName");
//
////                }
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
////        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot snapshot) {
////                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
////                Log.d("Enimesh","Data = "+ firebaseUser.getDisplayName());
//////                if (readUserDetails != null){
////                    childName = firebaseUser.getDisplayName();
////                    email = firebaseUser.getEmail();
////                    dob = readUserDetails.dob;
////                    gender = readUserDetails.gender;
////                    fullName = readUserDetails.yourName;
////
////                    Log.d("Enimesh","Data = "+childName);
////
////                    textViewChildName.setText(childName);
////                    textViewEmail.setText(email);
////                    textViewDOB.setText(dob);
////                    textViewGender.setText(gender);
////                    textViewFullName.setText(fullName);
////
//////                }
////                progressBar.setVisibility(View.GONE);
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////                Toast.makeText(UserProfileActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
////                progressBar.setVisibility(View.GONE);
////            }
////        });
//
////                referenceProfile.child("Register Users").child(userID).addChildEventListener(new ChildEventListener() {
////                    @Override
////                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                        ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
////                        if (readUserDetails != null) {
////                            childName = firebaseUser.getDisplayName();
////                            email = firebaseUser.getEmail();
////                            dob = readUserDetails.dob;
////                            gender = readUserDetails.gender;
////                            fullName = firebaseUser.getDisplayName();
////
////                            Log.d("ENimesh", "childname = " + childName);
////                            Log.d("ENimesh", "email = " + email);
////                            Log.d("ENimesh", "dob = " + dob);
////                            Log.d("ENimesh", "gender = " + gender);
////                            Log.d("ENimesh", "fullname = " + fullName);
////
//////                    textViewWelcome.setText("Welcome," + fullName + "!");
////                            textViewChildName.setText(childName);
////                            textViewEmail.setText(email);
////                            textViewDOB.setText(dob);
////                            textViewGender.setText(gender);
////                            textViewFullName.setText(fullName);
////                        }
////                        progressBar.setVisibility(View.GONE);
////                    }
////
////                    @Override
////                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                    }
////
////                    @Override
////                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                    }
////
////                    @Override
////                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                    }
////                });
//
////        referenceProfile.child("Register Users").child(userID).addChildEventListener(new ChildEventListener() {
////            @Override
////            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
////                if (readUserDetails != null){
////                    childName = firebaseUser.getDisplayName();
////                    email = firebaseUser.getEmail();
////                    dob = readUserDetails.dob;
////                    gender = readUserDetails.gender;
////                    fullName = firebaseUser.getDisplayName();
////
////                    Log.d("ENimesh","childname = "+childName);
////                    Log.d("ENimesh","email = "+email);
////                    Log.d("ENimesh","dob = "+dob);
////                    Log.d("ENimesh","gender = "+gender);
////                    Log.d("ENimesh","fullname = "+fullName);
////
//////                    textViewWelcome.setText("Welcome," + fullName + "!");
////                    textViewChildName.setText(childName);
////                    textViewEmail.setText(email);
////                    textViewDOB.setText(dob);
////                    textViewGender.setText(gender);
////                    textViewFullName.setText(fullName);
////                }
////                progressBar.setVisibility(View.GONE);
////            }
////
////            @Override
////            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////            }
////
////            @Override
////            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////            }
////
////            @Override
////            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////
////            }
////        });
////
////        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot snapshot) {
////
////                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
////                if (readUserDetails != null){
////                    childName = firebaseUser.getDisplayName();
////                    email = firebaseUser.getEmail();
////                    dob = readUserDetails.dob;
////                    gender = readUserDetails.gender;
////                    fullName = firebaseUser.getDisplayName();
////
////                    Log.d("ENimesh","childname = "+childName);
////                    Log.d("ENimesh","email = "+email);
////                    Log.d("ENimesh","dob = "+dob);
////                    Log.d("ENimesh","gender = "+gender);
////                    Log.d("ENimesh","fullname = "+fullName);
////
//////                    textViewWelcome.setText("Welcome," + fullName + "!");
////                    textViewChildName.setText(childName);
////                    textViewEmail.setText(email);
////                    textViewDOB.setText(dob);
////                    textViewGender.setText(gender);
////                    textViewFullName.setText(fullName);
////                }
////                progressBar.setVisibility(View.GONE);
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////                Toast.makeText(UserProfileActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
////                progressBar.setVisibility(View.GONE);
////            }
////        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(UserProfileActivity.this);
//        } else if (id == R.id.menu_refresh){
//            startActivity(getIntent());
//            finish();
//            overridePendingTransition(0,0);
        }
        else if (id == R.id.menu_update_profile) {
            Intent intent = new Intent(UserProfileActivity.this,UpdateProfileActivity.class);
            startActivity(intent);
            finish();
        }
//        else if (id == R.id.menu_update_email) {
//            Intent intent = new Intent(UserProfileActivity.this,UpdateEmailActivity.class);
//            startActivity(intent);
//            finish();
//        }else if (id == R.id.menu_settings) {
//            Toast.makeText(UserProfileActivity.this, "menu_settings", Toast.LENGTH_SHORT).show();
//        }
        else if (id == R.id.menu_change_password) {
            Intent intent = new Intent(UserProfileActivity.this,ChangePasswordActivity.class);
            startActivity(intent);
            finish();
        }
//        else if (id == R.id.menu_delete_profile) {
//            Intent intent = new Intent(UserProfileActivity.this,DeleteProfileActivity.class);
//            startActivity(intent);
//            finish();
//        }
        else if (id == R.id.menu_logout) {
           authProfile.signOut();
            Toast.makeText(UserProfileActivity.this, "Logged Out", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(UserProfileActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(UserProfileActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);


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