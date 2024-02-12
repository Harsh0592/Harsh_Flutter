package com.example.babyapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText editTextUpdateChildName, editTextDOB;
    private RadioGroup radioGroupUpdateGenderSelected;
    private RadioButton radioButtonUpdateGenderSelected;
    private String textChildName, textDOB, textGender;
    private FirebaseAuth authProfile;
    private ProgressBar progressBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        RadioButton radioButtonUpdateGenderSelected_male = findViewById(R.id.radio_male);
        radioButtonUpdateGenderSelected = findViewById(R.id.radio_female);

        progressBar = findViewById(R.id.progressBar);
        editTextUpdateChildName = findViewById(R.id.editText_update_profile_child_name);
        editTextDOB = findViewById(R.id.editText_update_profile_dob);
        radioGroupUpdateGenderSelected = findViewById(R.id.radio_group_update_profile_gender);

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        showProfile(firebaseUser);

        editTextDOB.setOnClickListener(new View.OnClickListener() {
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
//                String textSADOB[] = textDOB.split("/");
//
//                int day = Integer.parseInt(textSADOB[0]);
//                int month = Integer.parseInt(textSADOB[1])-1;
//                int year = Integer.parseInt(textSADOB[2]);

                DatePickerDialog picker;

                picker = new DatePickerDialog(UpdateProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        editTextDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });
        Button buttonUpdateProfile = findViewById(R.id.button_update_profile);
        buttonUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
//                updateProfile(firebaseUser);
                String userIOofRegistered = firebaseUser.getUid();
                DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Register Users").child(userIOofRegistered);


                final String[] DOB_ST = new String[1];
                final String[] Childname_ST = new String[1];
                final String[] GENDER_ST = new String[1];
                final String[] Email = new String[1];
                final String[] PWD = new String[1];

                referenceProfile.child("DOB").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        data.add(snapshot.getValue());
                        DOB_ST[0] = String.valueOf(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                referenceProfile.child("YourName").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Childname_ST[0] = (String) snapshot.getValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                referenceProfile.child("Gender").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        GENDER_ST[0] = String.valueOf(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                referenceProfile.child("Email").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Email[0] = String.valueOf(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                referenceProfile.child("Pwd").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        PWD[0] = String.valueOf(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//        ReadWriteUpdateDetails readUserDetails = new ReadWriteUpdateDetails(Childname_ST[0],DOB_ST[0],GENDER_ST[0]);

//        if(readUserDetails != null){

//

                textGender = radioButtonUpdateGenderSelected.getText().toString();
                textChildName = editTextUpdateChildName.getText().toString();
                textDOB = editTextDOB.getText().toString();

                if(radioButtonUpdateGenderSelected.isChecked()){
                    textGender = "Female";
                }else{
                    textGender = "Male";
                }

                Log.d("ENimesh", "gender = " + radioButtonUpdateGenderSelected.isChecked());


                ReadWriteUserDetails readWriteUserDetails = new ReadWriteUserDetails(textChildName, textDOB, textGender, Email[0], PWD[0]);

                referenceProfile.child("DOB").setValue(textDOB);
                referenceProfile.child("YourName").setValue(textChildName);
                referenceProfile.child("Gender").setValue(textGender);

                Toast.makeText(UpdateProfileActivity.this, "Update Successfull!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(UpdateProfileActivity.this, UserProfileActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();

                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void updateProfile(FirebaseUser firebaseUser) {
//        int selectedGenderID = radioGroupUpdateGenderSelected.getCheckedRadioButtonId();
//        Log.d("ENimesh","ID = "+selectedGenderID);
//        radioGroupUpdateGenderSelected = findViewById(selectedGenderID);

//        if (TextUtils.isEmpty(textYourName)){
//            Toast.makeText(RegisterActivity.this, "Please Enter Your Full Name", Toast.LENGTH_LONG).show();
//            editTextRegisterYourName.setError("Full Name is Required");
//            editTextRegisterYourName.requestFocus();
//        } else if (TextUtils.isEmpty(textEmail)) {
//            Toast.makeText(RegisterActivity.this, "Please Enter Your Email", Toast.LENGTH_LONG).show();
//            editTextRegisterEmail.setError("Email is Required");
//            editTextRegisterEmail.requestFocus();
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
//            Toast.makeText(RegisterActivity.this, "Please Re-Enter Your Email", Toast.LENGTH_LONG).show();
//            editTextRegisterEmail.setError("Valid email is Required");
//            editTextRegisterEmail.requestFocus();
//        } else
//        if (TextUtils.isEmpty(textDOB)) {
//            Toast.makeText(UpdateProfileActivity.this, "Please Enter Child's Date Of Birth", Toast.LENGTH_LONG).show();
//            editTextDOB.setError("Date Of Birth is Required");
//            editTextDOB.requestFocus();
//        } else if (TextUtils.isEmpty(radioButtonUpdateGenderSelected.getText())) {
//            Toast.makeText(UpdateProfileActivity.this, "Please select Child's Gander", Toast.LENGTH_LONG).show();
//            radioButtonUpdateGenderSelected.setError("Gander is Required");
//            radioButtonUpdateGenderSelected.requestFocus();
//        } else if (TextUtils.isEmpty(textChildName)) {
//            Toast.makeText(UpdateProfileActivity.this, "Please Enter Your Child Name", Toast.LENGTH_LONG).show();
//            editTextUpdateChildName.setError("Child Name is Required");
//            editTextUpdateChildName.requestFocus();
//        }
//        else if (TextUtils.isEmpty(textPwd)) {
//            Toast.makeText(RegisterActivity.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
//            editTextRegisterPwd.setError("Password is Required");
//            editTextRegisterPwd.requestFocus();
//        }
//        else if (textPwd.length() < 6) {
//            Toast.makeText(RegisterActivity.this, "Password should be at least 6 digits", Toast.LENGTH_LONG).show();
//            editTextRegisterPwd.setError("Password too weak");
//            editTextRegisterPwd.requestFocus();
//        }
//        else {

//            ReadWriteUserDetails Update_user_detail = new ReadWriteUserDetails(textChildName, textDOB, textGender);

//            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Register Users");
//            String userID = firebaseUser.getUid();
//
//            progressBar.setVisibility(View.VISIBLE);
//
//            referenceProfile.child(userID).setValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if (task.isSuccessful()){
//                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(textChildName).build();
//                        firebaseUser.updateProfile(profileUpdates);
//
//                        Toast.makeText(UpdateProfileActivity.this, "Update Successfull!", Toast.LENGTH_LONG).show();
//                        Intent i = new Intent(UpdateProfileActivity.this,UpdateProfileActivity.class);
//                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(i);
//                        finish();
//                    }else {
//                        try {
//                            throw task.getException();
//                        }catch (Exception e){
//                            Toast.makeText(UpdateProfileActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                    progressBar.setVisibility(View.GONE);
//                }
//            });

//        }
    }


    ArrayList data = new ArrayList<>();

    private void showProfile(FirebaseUser firebaseUser) {
        String userIOofRegistered = firebaseUser.getUid();
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Register Users").child(userIOofRegistered);


        final String[] DOB_ST = new String[1];
        final String[] Childname_ST = new String[1];
        final String[] GENDER_ST = new String[1];
        final String[] Email = new String[1];
        final String[] PWD = new String[1];

        referenceProfile.child("DOB").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.add(snapshot.getValue());
                DOB_ST[0] = String.valueOf(snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceProfile.child("YourName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Childname_ST[0] = (String) snapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceProfile.child("Gender").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GENDER_ST[0] = String.valueOf(snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceProfile.child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Email[0] = String.valueOf(snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceProfile.child("Pwd").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PWD[0] = String.valueOf(snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        ReadWriteUpdateDetails readUserDetails = new ReadWriteUpdateDetails(Childname_ST[0],DOB_ST[0],GENDER_ST[0]);

//        if(readUserDetails != null){

//

//        ReadWriteUserDetails readWriteUserDetails = new ReadWriteUserDetails(Childname_ST[0],DOB_ST[0],GENDER_ST[0],Email[0],PWD[0]);

        textChildName = Childname_ST[0];
        textDOB = DOB_ST[0];
        textGender = GENDER_ST[0];

        editTextUpdateChildName.setText(textChildName);
        editTextDOB.setText(textDOB);



//        if(Objects.equals(GENDER_ST[0], "Male")){
//            radioButtonUpdateGenderSelected_male.setChecked(true);
//        }else{
//            radioButtonUpdateGenderSelected.setChecked(true);
//        }

//        }else {
//            Toast.makeText(UpdateProfileActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
//        }
        progressBar.setVisibility(View.GONE);
//        .addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                Log.d("ENimesh","IN listener = "+snapshot.getValue());
//
//
////                    data.add(snapshot.getValue());
////
////
////
////                Log.d("ENimesh", "onChildAdded: "+data);
//
////                HashMap map2 = new HashMap((Map) Objects.requireNonNull(snapshot.getValue()));
////                ReadWriteUpdateDetails readWriteUpdateDetails = new ReadWriteUpdateDetails((String) data.get(4), (String) data.get(0), (String) data.get(2));
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
// -----------------------------------------
//        referenceProfile.child(userIOofRegistered).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
////
////
////
//                ReadWriteUpdateDetails readUserDetails = snapshot.getValue(ReadWriteUpdateDetails.class);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(UpdateProfileActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
//                progressBar.setVisibility(View.GONE);
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