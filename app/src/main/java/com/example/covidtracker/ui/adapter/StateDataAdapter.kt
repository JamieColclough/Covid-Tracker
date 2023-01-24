package com.example.covidtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtracker.api.StateCaseData
import com.example.covidtracker.databinding.StateDataItemBinding

class StateDataAdapter(private val dataset: List<StateCaseData>) : RecyclerView.Adapter<StateDataAdapter.StateDataViewHolder>() {
    class StateDataViewHolder(private val binding: StateDataItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindStateData(state: StateCaseData){
            binding.state = state
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateDataViewHolder {
        val binding = StateDataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StateDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StateDataViewHolder, position: Int) {
        val stateData = dataset[position]
        holder.bindStateData(stateData)
    }

    override fun getItemCount(): Int = dataset.size
}