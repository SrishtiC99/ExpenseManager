package com.srishti.expensemanager.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.srishti.expensemanager.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("YOUR PROFILE");
    }
}