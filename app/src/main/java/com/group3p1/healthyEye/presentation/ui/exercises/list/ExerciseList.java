package com.group3p1.healthyEye.presentation.ui.exercises.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.domain.model.ExerciseModel;
import com.group3p1.healthyEye.presentation.ui.exercises.AddExerciseActivity;
import com.group3p1.healthyEye.presentation.ui.exercises.detail.ExerciseDetail;

import java.util.ArrayList;
import java.util.List;

public class ExerciseList extends AppCompatActivity implements ItemClickListener {
    private ExAdapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<ExerciseModel> list = new ArrayList<>();
    private static final String TAG = "ExerciseList";
    private ListViewModel viewModel;
    private Integer from = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);
        initView();
    }


    private void initView() {
        viewModel = new ViewModelProvider(this).get(ListViewModel.class);
        viewModel.getList().observe(this, exerciseModels -> {
            adapter.updateList(exerciseModels);
        });
        from = getIntent().getIntExtra("from", 0);
        RecyclerView recyclerView = findViewById(R.id.rv1);
        adapter = new ExAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.add_exercise).setOnClickListener(v -> {
            startActivity(new Intent(this, AddExerciseActivity.class));
        });

    }

    @Override
    public void onClick(ExerciseModel model) {
        Intent intent = new Intent(this, ExerciseDetail.class);
        intent.putExtra("ex", model);
        startActivity(intent);
    }
}