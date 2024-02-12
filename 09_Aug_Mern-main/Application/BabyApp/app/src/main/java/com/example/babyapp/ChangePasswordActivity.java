package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    private FirebaseAuth authProfile;
    private EditText editTextPwdCurr, editTextPwdNew, editTextPwdConfirm;
    private TextView textViewAuthenticated;
    private Button buttonChangePwd, buttonReAuthenticate;
    private ProgressBar progressBar;
    private String userPwdCurr;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        getSupportActionBar().setTitle("Clever Touch");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        swipeToRefresh();

        editTextPwdNew = findViewById(R.id.editText_change_pwd_new);
        editTextPwdCurr = findViewById(R.id.editText_change_pwd_current);
        editTextPwdConfirm = findViewById(R.id.editText_change_pwd_conf);
        textViewAuthenticated = findViewById(R.id.textView_change_pwd_authenticated);
        progressBar = findViewById(R.id.progressBar);
        buttonReAuthenticate = findViewById(R.id.button_change_pwd_authenticate);
        buttonChangePwd = findViewById(R.id.button_change_pwd);

        editTextPwdNew.setEnabled(false);
        editTextPwdConfirm.setEnabled(false);
        buttonChangePwd.setEnabled(false);

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if (firebaseUser.equals("")){
            Toast.makeText(ChangePasswordActivity.this, "Something went wrong! User's details not available",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChangePasswordActivity.this,UserProfileActivity.class);
            startActivity(intent);
            finish();
        }else {
            reAuthenticateUser(firebaseUser);
        }
        ImageView imageViewShowHidePwd = findViewById(R.id.imageView_show_hide_pwd);
        imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
        imageViewShowHidePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                if ( editTextPwdCurr.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    editTextPwdCurr.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
                }else {
                    editTextPwdCurr.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });
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
//    }

    private void reAuthenticateUser(FirebaseUser firebaseUser) {
        buttonReAuthenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                userPwdCurr = editTextPwdCurr.getText().toString();
                if (TextUtils.isEmpty(userPwdCurr)){
                    Toast.makeText(ChangePasswordActivity.this, "Password is needed", Toast.LENGTH_SHORT).show();
                    editTextPwdCurr.setError("Please enter your current password to authenticate");
                    editTextPwdCurr.requestFocus();
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(),userPwdCurr);
                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                progressBar.setVisibility(View.GONE);
                                editTextPwdCurr.setEnabled(false);
                                editTextPwdNew.setEnabled(true);
                                editTextPwdConfirm.setEnabled(true);
                                buttonReAuthenticate.setEnabled(false);
                                buttonChangePwd.setEnabled(true);
                                textViewAuthenticated.setText("you are authenticated/verified." + "you can change password now!");
                                Toast.makeText(ChangePasswordActivity.this, "Password has been verified." + "Change Password now", Toast.LENGTH_SHORT).show();
                                buttonChangePwd.setBackgroundTintList(ContextCompat.getColorStateList(ChangePasswordActivity.this,R.color.dark_green));
                                buttonChangePwd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        changePwd(firebaseUser);
                                    }
                                });
                            }else {
                                try {
                                    throw task.getException();
                                }catch (Exception e){
                                    Toast.makeText(ChangePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            ImageView imageViewShowHide = findViewById(R.id.imageView_show_hide_pwd);
                            imageViewShowHide.setImageResource(R.drawable.ic_hide_pwd);
                            imageViewShowHide.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (mediaPlayer.isPlaying()) {
                                        mediaPlayer.pause();
                                        mediaPlayer.seekTo(0);
                                    } else {
                                        mediaPlayer.start();
                                    }
                                    if ( editTextPwdNew.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                                        editTextPwdNew.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                        imageViewShowHide.setImageResource(R.drawable.ic_hide_pwd);
                                    }else {
                                        editTextPwdNew.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                        imageViewShowHide.setImageResource(R.drawable.ic_show_pwd);
                                    }
                                }
                            });
                            ImageView pwd = findViewById(R.id.imageView_show_hide_pwd);
                            pwd.setImageResource(R.drawable.ic_hide_pwd);
                            pwd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (mediaPlayer.isPlaying()) {
                                        mediaPlayer.pause();
                                        mediaPlayer.seekTo(0);
                                    } else {
                                        mediaPlayer.start();
                                    }
                                    if ( editTextPwdConfirm.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                                        editTextPwdConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                       pwd.setImageResource(R.drawable.ic_hide_pwd);
                                    }else {
                                        editTextPwdConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                        pwd.setImageResource(R.drawable.ic_show_pwd);
                                    }
                                }
                            });
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
    }

    private void changePwd(FirebaseUser firebaseUser) {
        String userPwdNew = editTextPwdNew.getText().toString();
        String userPwdConfirmNew = editTextPwdConfirm.getText().toString();
        if (TextUtils.isEmpty(userPwdNew)){
            Toast.makeText(ChangePasswordActivity.this, "New Password is needed", Toast.LENGTH_SHORT).show();
            editTextPwdNew.setError("Please enter your new password");
            editTextPwdNew.requestFocus();
        } else if (TextUtils.isEmpty(userPwdConfirmNew)) {
            Toast.makeText(ChangePasswordActivity.this, "Please confirm your New Password", Toast.LENGTH_SHORT).show();
            editTextPwdNew.setError("Please re-enter your new password");
            editTextPwdNew.requestFocus();
        } else if (!userPwdNew.matches(userPwdConfirmNew)) {
            Toast.makeText(ChangePasswordActivity.this, "Password did not match", Toast.LENGTH_SHORT).show();
            editTextPwdNew.setError("Please re-enter same password");
            editTextPwdNew.requestFocus();
        } else if (userPwdCurr.matches(userPwdNew)) {
            Toast.makeText(ChangePasswordActivity.this, "New Password cannot be same as old password", Toast.LENGTH_SHORT).show();
            editTextPwdNew.setError("Please enter your new password");
            editTextPwdNew.requestFocus();
        }else {
            progressBar.setVisibility(View.VISIBLE);
            firebaseUser.updatePassword(userPwdNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(ChangePasswordActivity.this, "Password has been changed", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChangePasswordActivity.this,UserProfileActivity.class);
                        startActivity(intent);
                        finish();
                    }    else {
                        try {
                            throw task.getException();
                        }catch (Exception e){
                            Toast.makeText(ChangePasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(ChangePasswordActivity.this);
//        } else if (id == R.id.menu_refresh){
//            startActivity(getIntent());
//            finish();
//            overridePendingTransition(0,0);
//        } else if (id == R.id.menu_update_profile) {
//            Intent intent = new Intent(ChangePasswordActivity.this,UpdateProfileActivity.class);
//            startActivity(intent);
//            finish();
//        } else if (id == R.id.menu_update_email) {
//            Intent intent = new Intent(ChangePasswordActivity.this,UpdateEmailActivity.class);
//            startActivity(intent);
//            finish();
//        }else if (id == R.id.menu_settings) {
//            Toast.makeText(ChangePasswordActivity.this, "menu_settings", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.menu_change_password) {
            Intent intent = new Intent(ChangePasswordActivity.this,ChangePasswordActivity.class);
            startActivity(intent);
            finish();
//        }else if (id == R.id.menu_delete_profile) {
//            Intent intent = new Intent(ChangePasswordActivity.this,DeleteProfileActivity.class);
//            startActivity(intent);
//            finish();
        }else if (id == R.id.menu_logout) {
            authProfile.signOut();
            Toast.makeText(ChangePasswordActivity.this, "Logged Out", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ChangePasswordActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(ChangePasswordActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
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