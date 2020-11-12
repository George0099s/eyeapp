package com.group3p1.healthyEye.presentation.ui.exercises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.group3p1.healthyEye.R
import com.group3p1.healthyEye.domain.model.ExerciseModel
import kotlinx.android.synthetic.main.activity_exercise_detail.*
import kotlinx.android.synthetic.main.item_ex.*

class ExerciseDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail)
        val model = intent.getParcelableExtra<ExerciseModel>("ex")
        exText.text = model?.text
        exTitle.text = model?.title
    }
}