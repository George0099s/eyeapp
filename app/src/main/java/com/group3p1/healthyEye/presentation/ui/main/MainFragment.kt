package com.group3p1.healthyEye.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialSharedAxis
import com.group3p1.healthyEye.R


class MainFragment : Fragment() {

    private var exercises: Button? = null
    private var about: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = MaterialSharedAxis(
                MaterialSharedAxis.Z,
                /* forward= */ true
        )
        enterTransition = MaterialSharedAxis(
                MaterialSharedAxis.Z,
                /* forward= */ false
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        exercises = view.findViewById(R.id.exercises)
        about = view.findViewById(R.id.about)
        about?.setOnClickListener { view: View? ->
            requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_cont, AboutFragment(), AboutFragment::class.java.simpleName)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .addToBackStack("about")
                    .commit()
        }
        exercises?.setOnClickListener { v: View? ->
            val intent = Intent(requireContext(), ExercisesActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}