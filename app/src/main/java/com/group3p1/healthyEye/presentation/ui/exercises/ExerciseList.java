package com.group3p1.healthyEye.presentation.ui.exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.domain.model.ExerciseModel;
import com.group3p1.healthyEye.presentation.ui.utils.ExercisesUtils;

public class ExerciseList extends AppCompatActivity implements ItemClickListener {
    private ExAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);
        RecyclerView recyclerView = findViewById(R.id.rv1);
        adapter = new ExAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        adapter.updateList(ExercisesUtils.Companion.getExercises1());
    }

    @Override
    public void onClick(ExerciseModel model) {
        Intent intent = new Intent(this, ExerciseDetail.class);
        intent.putExtra("ex", model);
        startActivity(intent);
    }
}