package com.example.covidtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidtracker.ui.CovidViewModel
import com.example.covidtracker.databinding.FragmentCovidBinding
import com.example.covidtracker.ui.adapter.StateDataAdapter

class CovidFragment : Fragment() {
    private val viewModel: CovidViewModel by viewModels()
    lateinit var binding : FragmentCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCovidBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val recyclerView = binding.stateBreakdown
        viewModel.covidData.observe(viewLifecycleOwner) {
            recyclerView.adapter = StateDataAdapter(it.casesByState)
        }
        recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
        viewModel.updateData()
        return binding.root
    }
}