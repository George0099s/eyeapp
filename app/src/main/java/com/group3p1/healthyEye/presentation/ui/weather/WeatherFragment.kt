package com.group3p1.healthyEye.presentation.ui.weather

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.group3p1.healthyEye.R
import kotlinx.android.synthetic.main.main_fragment.view.*
import kotlinx.android.synthetic.main.weather_fragment.view.*

class WeatherFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
        private const val TAG = "WeatherFragment"
    }

    private lateinit var viewModel: WeatherViewModel
    private lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        v = inflater.inflate(R.layout.weather_fragment, container, false)
        return v
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.getWeather()
        viewModel.weatherLiveData.observe(this) {
           v.weatherTV.text = "${it.name} ${it.weather?.get(0)?.description}"
        }
    }
}