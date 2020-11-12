package com.group3p1.healthyEye.presentation.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.presentation.ui.exercises.ExerciseList;

public class ExercisesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button group1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercises);
        group1 = findViewById(R.id.btn_group_1);
        group1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_group_1: {
                startActivity(new Intent(this, ExerciseList.class));
            }
        }
    }
}