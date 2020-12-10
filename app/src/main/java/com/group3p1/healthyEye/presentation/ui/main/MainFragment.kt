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
import com.group3p1.healthyEye.presentation.ui.weather.WeatherFragment
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    private var exercises: Button? = null
    private var about: Button? = null
    private var weather: Button? = null

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
        weather = view.findViewById(R.id.weather)
        about?.setOnClickListener { view: View? ->
            requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_cont, AboutFragment(), AboutFragment::class.java.simpleName)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .addToBackStack("about")
                    .commit()
        }

        weather?.setOnClickListener {
            requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_cont, WeatherFragment())
                    .addToBackStack("tag")
                    .commit()
        }

        exercises?.setOnClickListener { v: View? ->
            val intent = Intent(requireContext(), ExercisesActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}