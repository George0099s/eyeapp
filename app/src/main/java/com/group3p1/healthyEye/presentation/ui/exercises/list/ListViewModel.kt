package com.group3p1.healthyEye.presentation.ui.exercises.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.group3p1.healthyEye.domain.model.ExerciseModel

class ListViewModel: ViewModel() {
    val list = MutableLiveData<List<ExerciseModel?>>()
    private val db = FirebaseFirestore.getInstance()

    init {
        getData()
    }
    private fun getData(){

        db.collection("exercises")
                .orderBy("title")
                .get()
                .addOnCompleteListener(OnCompleteListener { task: Task<QuerySnapshot> ->
                    if (task.isSuccessful) {
                        list.value = task.result!!.toObjects(ExerciseModel::class.java) as ArrayList<ExerciseModel?>
                    } else {
                        Log.w(Companion.TAG, "Error getting documents.", task.exception)
                    }
                })
    }


    companion object {
        private const val TAG = "ListViewModel"
    }
}