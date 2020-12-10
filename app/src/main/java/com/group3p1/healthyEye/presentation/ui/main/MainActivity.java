package com.group3p1.healthyEye.presentation.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.group3p1.healthyEye.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_cont, new MainFragment(), MainFragment.class.getSimpleName())
                .addToBackStack("MainFragment")
                .commit();
    }
}