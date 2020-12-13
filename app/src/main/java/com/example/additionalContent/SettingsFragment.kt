package com.example.additionalContent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.example.start.R
import kotlinx.android.synthetic.main.fragment_settings.*
import timber.log.Timber


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val switch1 = container?.findViewById<Switch>(R.id.switch1)
        switch1?.setOnCheckedChangeListener({ _, isChecked ->
            if(isChecked){
                Timber.i("Checked!")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        })
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}