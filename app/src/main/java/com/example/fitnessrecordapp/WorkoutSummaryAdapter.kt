package com.example.fitnessrecordapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutSummaryAdapter(private val workoutSummaryList: List<WorkoutSummary>) : RecyclerView.Adapter<WorkoutSummaryAdapter.WorkoutSummaryViewHolder>() {
    private var currentWeek = 1
    class WorkoutSummaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTotalCalories: TextView = view.findViewById(R.id.tvDuration1)
        val tvTotalDuration: TextView = view.findViewById(R.id.tvIntensity1)
        val tvweeks: TextView = view.findViewById(R.id.tvWorkoutType1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutSummaryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout1, parent, false)
        return WorkoutSummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutSummaryViewHolder, position: Int) {
        val workoutSummary = workoutSummaryList[position]
        holder.tvTotalCalories.text = "Weekly Calories: ${workoutSummary.totalCalories}"
        holder.tvTotalDuration.text = "Total Duration in this week: ${workoutSummary.totalDuration} minutes"
        holder.tvweeks.text = "Week#: $currentWeek"
        currentWeek++
    }

    override fun getItemCount(): Int {
        return workoutSummaryList.size
    }
}