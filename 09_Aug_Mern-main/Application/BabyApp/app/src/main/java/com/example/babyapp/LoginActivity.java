package com.example.babyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextLoginEmail, editTextLoginPwd;
    private ProgressBar progressBar;
    private FirebaseAuth authProfile;
    private MediaPlayer mediaPlayer;
    private static final String TAG = "LoginActivity";
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
//        getSupportActionBar().setTitle("Clever Touch");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        swipeToRefresh();

        editTextLoginEmail = findViewById(R.id.editText_login_email);
        editTextLoginPwd = findViewById(R.id.editText_login_pwd);
        progressBar = findViewById(R.id.progressBar);

        authProfile = FirebaseAuth.getInstance();

//        TextView textForgotPassword = findViewById(R.id.textView_forgot_password_link);
//        textForgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this, "You can reset your password now!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
//            }
//        });
        TextView textRegister = findViewById(R.id.textView_register_link);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                Toast.makeText(LoginActivity.this, "You can reset your password now!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

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
                if (editTextLoginPwd.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    editTextLoginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
                } else {
                    editTextLoginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });

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
                String textEmail = editTextLoginEmail.getText().toString();
                String textPwd = editTextLoginPwd.getText().toString();

                if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    editTextLoginEmail.setError("Email is required");
                    editTextLoginEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(LoginActivity.this, "Please re-enter your email", Toast.LENGTH_SHORT).show();
                    editTextLoginEmail.setError("Valid email is required");
                    editTextLoginEmail.requestFocus();
                } else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(LoginActivity.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                    editTextLoginPwd.setError("Password is required");
                    editTextLoginPwd.requestFocus();
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    loginUser(textEmail, textPwd);
                }
            }
        });
    }

//    private void swipeToRefresh() {swipeContainer = findViewById(R.id.swipeContainer);
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

    private void loginUser(String email, String pwd) {
        authProfile.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    FirebaseUser firebaseUser = authProfile.getCurrentUser();

//                    if (firebaseUser.isEmailVerified()){
//                        Toast.makeText(LoginActivity.this, "You are logged in now", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
//                    }else {
////                        firebaseUser.sendEmailVerification();
////                        authProfile.signOut();
////                        showAlertDialog();
//                        Toast.makeText(LoginActivity.this, "Successfully Logged In.", Toast.LENGTH_SHORT).show();
//                    }
                } else {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        editTextLoginEmail.setError("User dose not exists or is no longer valid.Please register again.");
                        editTextLoginEmail.requestFocus();
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        editTextLoginEmail.setError("Invalid credentials. Kindly, check and re-enter.");
                        editTextLoginEmail.requestFocus();
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

//    private void showAlertDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//        builder.setTitle("Email Not Verified");
//        builder.setMessage("Please Verify your Email now. You can not login without email verification.");
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

    @Override
    protected void onStart() {
        super.onStart();
        if (authProfile.getCurrentUser() != null) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            Toast.makeText(LoginActivity.this, "Already Logged In!", Toast.LENGTH_SHORT).show();
            startActivity(i);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "You can Login Now!", Toast.LENGTH_SHORT).show();
        }
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