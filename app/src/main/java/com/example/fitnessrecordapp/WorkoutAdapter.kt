package com.example.fitnessrecordapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutAdapter(private val workoutList: List<Workout>) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    class WorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvWorkoutType: TextView = view.findViewById(R.id.tvWorkoutType)
        val tvDuration: TextView = view.findViewById(R.id.tvDuration)
        val tvIntensity: TextView = view.findViewById(R.id.tvIntensity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workout = workoutList[position]
        holder.tvWorkoutType.text = workout.type
        holder.tvDuration.text = "Duration: ${workout.duration} minutes"
        holder.tvIntensity.text = "Intensity: ${workout.intensity}"
    }

    override fun getItemCount(): Int {
        return workoutList.size
    }
}