package com.example.fitnessrecordapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class AddWorkoutFragment1 : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_workout1, container, false)

        val etTotalCalories: EditText? = view.findViewById(R.id.totalkaluli)
        val etTotalDuration: EditText? = view.findViewById(R.id.totaltime)
        val btnSubmit: Button? = view.findViewById(R.id.button1)

        if (etTotalCalories == null || etTotalDuration == null || btnSubmit == null) {
            Log.e("AddWorkoutFragment1", "One of the view elements is null")
            throw NullPointerException("One of the view elements is null")
        }

        btnSubmit.setOnClickListener {
            val totalCalories = etTotalCalories.text?.toString()?.toIntOrNull() ?: 0
            val totalDuration = etTotalDuration.text?.toString()?.toIntOrNull() ?: 0

            if (totalCalories <= 0 || totalDuration <= 0) {
                Log.e("AddWorkoutFragment1", "Total Calories or Total Duration is empty or invalid")
                return@setOnClickListener
            }

            val workoutSummary = WorkoutSummary(totalCalories, totalDuration)

            if (targetFragment != null) {
                (targetFragment as? WeeklyWorkoutActivity)?.addWorkoutSummary(workoutSummary)
            } else {
                (activity as? WeeklyWorkoutActivity)?.addWorkoutSummary(workoutSummary)
            }
            dismiss()
        }

        return view
    }
}