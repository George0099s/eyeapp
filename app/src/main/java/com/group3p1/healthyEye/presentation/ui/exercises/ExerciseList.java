package com.group3p1.healthyEye.presentation.ui.exercises;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.domain.model.ExerciseModel;

import java.util.ArrayList;

public class ExerciseList extends AppCompatActivity implements ItemClickListener {
    private ExAdapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<ExerciseModel> list = new ArrayList<>();
    private static final String TAG = "ExerciseList";

    private Integer from = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);
        initView();
    }


    private void initView() {
        from = getIntent().getIntExtra("from", 0);
        RecyclerView recyclerView = findViewById(R.id.rv1);
        adapter = new ExAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.add_exercise).setOnClickListener(v -> {
            startActivity(new Intent(this, AddExerciseActivity.class));
        });

        db.collection("exercises")
                .orderBy("title")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        list = (ArrayList<ExerciseModel>) task.getResult().toObjects(ExerciseModel.class);
                        adapter.updateList(list);
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

    @Override
    public void onClick(ExerciseModel model) {
        Intent intent = new Intent(this, ExerciseDetail.class);
        intent.putExtra("ex", model);
        startActivity(intent);
    }
}