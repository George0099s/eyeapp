package com.group3p1.healthyEye.presentation.ui.exercises.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.group3p1.healthyEye.domain.model.ExerciseModel

class ExDetailViewModel: ViewModel() {
    val liveData = MutableLiveData<ExerciseModel>()

}