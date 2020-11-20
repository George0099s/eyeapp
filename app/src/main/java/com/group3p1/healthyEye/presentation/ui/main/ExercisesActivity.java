package com.group3p1.healthyEye.presentation.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.presentation.ui.exercises.list.ExerciseList;

public class ExercisesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button group1, group2, group3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercises);
        group1 = findViewById(R.id.btn_group_1);
        group2 = findViewById(R.id.btn_group_2);
        group3 = findViewById(R.id.btn_group_3);
        group1.setOnClickListener(this);
        group2.setOnClickListener(this);
        group3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_group_1: {
                Intent intent = new Intent(this, ExerciseList.class);
                intent.putExtra("from", 1);
                startActivity(intent);
                break;
            }
            case R.id.btn_group_2: {
                Intent intent = new Intent(this, ExerciseList.class);
                intent.putExtra("from", 2);
                startActivity(intent);
                break;
            }
            case R.id.btn_group_3: {
                Intent intent = new Intent(this, ExerciseList.class);
                intent.putExtra("from", 3);
                startActivity(intent);
                break;
            }
        }
    }
}