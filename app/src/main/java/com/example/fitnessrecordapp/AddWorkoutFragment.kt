package com.example.fitnessrecordapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class AddWorkoutFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_workout, container, false)

        val etWorkoutType: EditText? = view.findViewById(R.id.etWorkoutType)
        val etDuration: EditText? = view.findViewById(R.id.etDuration)
        val radioGroupIntensity: RadioGroup? = view.findViewById(R.id.radioGroupIntensity)
        val btnSubmit: Button? = view.findViewById(R.id.btnSubmit)

        if (etWorkoutType == null || etDuration == null  || radioGroupIntensity == null || btnSubmit == null) {
            Log.e("AddWorkoutFragment", "One of the view elements is null")
            throw NullPointerException("One of the view elements is null")
        }

        btnSubmit.setOnClickListener {
            val workoutType = etWorkoutType.text?.toString() ?: ""
            val duration = etDuration.text?.toString()?.toIntOrNull() ?: 0
            val intensity = when (radioGroupIntensity.checkedRadioButtonId) {
                R.id.rbLow -> "Low"
                R.id.rbMedium -> "Medium"
                R.id.rbHigh -> "High"
                else -> "Unknown"
            }

            if (workoutType.isEmpty() || intensity == "Unknown") {
                Log.e("AddWorkoutFragment", "WorkoutType, WorkoutCategory or Intensity is empty or unknown")
                return@setOnClickListener
            }

            val workout = Workout(workoutType, duration, intensity)

            (activity as? MainActivity)?.addWorkout(workout)
            dismiss()
        }

        return view
    }
}