package com.example.babyapp;

public class ReadWriteUserDetails {
    public String YourName,DOB,Gender, Email,Pwd;
    public ReadWriteUserDetails(String textYourName,String textDOB,String textGender, String textEmail,String textPwd){
        this.YourName = textYourName;
        this.DOB = textDOB;
        this.Gender = textGender;
        this.Email = textEmail;
        this.Pwd = textPwd;
    }
}
