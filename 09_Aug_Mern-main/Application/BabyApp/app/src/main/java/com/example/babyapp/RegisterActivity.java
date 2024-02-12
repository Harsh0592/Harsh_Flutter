package com.example.babyapp;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextRegisterYourName, editTextRegisterEmail, editTextRegisterDOB, editTextRegisterChildName,
    editTextRegisterPwd;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private DatePickerDialog picker;
    private MediaPlayer mediaPlayer;
    private SwipeRefreshLayout swipeContainer;
    private static final String TAG = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mediaPlayer = MediaPlayer.create(this, R.raw.click);
//
//        getSupportActionBar().setTitle("Clever Touch");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        swipeToRefresh();

        Toast.makeText(RegisterActivity.this, "You can register now",Toast.LENGTH_LONG).show();
        progressBar = findViewById(R.id.progressBar);
        editTextRegisterYourName = findViewById(R.id.editText_register_your_name);
        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterDOB = findViewById(R.id.editText_register_dob);
        editTextRegisterChildName = findViewById(R.id.editText_register_childName);
        editTextRegisterPwd = findViewById(R.id.editText_register_password);


        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        editTextRegisterDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                      editTextRegisterDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                picker.show();
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
                if (editTextRegisterPwd.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    editTextRegisterPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
                }else {
                    editTextRegisterPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                String textYourName = editTextRegisterYourName.getText().toString();
                String textEmail = editTextRegisterEmail.getText().toString();
                String textDOB = editTextRegisterDOB.getText().toString();
                String textChildName = editTextRegisterChildName.getText().toString();
                String textPwd = editTextRegisterPwd.getText().toString();
                String textGender;

                if (TextUtils.isEmpty(textYourName)){
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Full Name", Toast.LENGTH_LONG).show();
                    editTextRegisterYourName.setError("Full Name is Required");
                    editTextRegisterYourName.requestFocus();
                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Email is Required");
                    editTextRegisterEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(RegisterActivity.this, "Please Re-Enter Your Email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Valid email is Required");
                    editTextRegisterEmail.requestFocus();
                } else if (TextUtils.isEmpty(textDOB)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Child's Date Of Birth", Toast.LENGTH_LONG).show();
                    editTextRegisterDOB.setError("Date Of Birth is Required");
                    editTextRegisterDOB.requestFocus();
                } else if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegisterActivity.this, "Please select Child's Gander", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gander is Required");
                    radioButtonRegisterGenderSelected.requestFocus();
                } else if (TextUtils.isEmpty(textChildName)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Child Name", Toast.LENGTH_LONG).show();
                    editTextRegisterChildName.setError("Child Name is Required");
                    editTextRegisterChildName.requestFocus();
                }else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.setError("Password is Required");
                    editTextRegisterPwd.requestFocus();
                } else if (textPwd.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password should be at least 6 digits", Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.setError("Password too weak");
                    editTextRegisterPwd.requestFocus();
                }else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(textYourName, textEmail, textDOB, textGender, textChildName, textPwd);
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

    private void registerUser(String textYourName, String textEmail, String textDOB, String textGender, String textChildName, String textPwd) {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    auth.createUserWithEmailAndPassword(textEmail,textPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){

                FirebaseUser firebaseUser = auth.getCurrentUser();

                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textChildName).build();
                firebaseUser.updateProfile(profileChangeRequest);

                ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textYourName,textDOB,textGender, textEmail, textPwd);

                DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Register Users");
                referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            firebaseUser.sendEmailVerification();

                            Toast.makeText(RegisterActivity.this, "User Register Successfully. Please verify your email", Toast.LENGTH_LONG).show();

                             Intent intent = new Intent(RegisterActivity.this, UserProfileActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                        }else {
                            Toast.makeText(RegisterActivity.this, "User Register failed. Please Try Again", Toast.LENGTH_LONG).show();
                        }
                        progressBar.setVisibility(View.GONE);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ENimesh",e.getMessage());
                    }
                });
            }else {
                try{
                    throw task.getException();
                }catch (FirebaseAuthWeakPasswordException e){
                    editTextRegisterPwd.setError("Your Password is too Weak. Kindly use a mix of alphabets, numbers and special characters.");
                    editTextRegisterPwd.requestFocus();
                }catch (FirebaseAuthInvalidCredentialsException e){
                    editTextRegisterPwd.setError("Your Email is invalid or already i use. Kindly re-enter.");
                    editTextRegisterPwd.requestFocus();
                }catch (FirebaseAuthUserCollisionException e){
                    editTextRegisterPwd.setError("User is already registered with this email. Use another email.");
                    editTextRegisterPwd.requestFocus();
                }catch (Exception e){
                    Log.e(TAG, e.getMessage());
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
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