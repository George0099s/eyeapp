package com.group3p1.healthyEye.presentation.ui.exercises.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.group3p1.healthyEye.R
import com.group3p1.healthyEye.domain.model.ExerciseModel
import kotlinx.android.synthetic.main.activity_exercise_detail.*

class ExerciseDetail : AppCompatActivity() {

    private lateinit var viewModel: ExDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail)
        viewModel = ViewModelProvider(this).get(ExDetailViewModel::class.java)
        viewModel.liveData.observe(this, observeModel)
        viewModel.liveData.value = intent.getParcelableExtra("ex")
    }


    private val observeModel = Observer<ExerciseModel>{ model->
        exText.text = model?.text
        exTitle.text = model?.title
    }

    companion object {
        private const val TAG = "ExerciseDetail"
    }
}