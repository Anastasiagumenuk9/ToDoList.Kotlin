package com.example.network.placeholder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.start.R
import com.example.start.databinding.FragmentPlaceholderBinding


class PlaceholderFragment : Fragment() {

    private val viewModel: PlaceholderViewModel by lazy {
        ViewModelProviders.of(this).get(PlaceholderViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentPlaceholderBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setHasOptionsMenu(true)
        return  binding.root
    }
}