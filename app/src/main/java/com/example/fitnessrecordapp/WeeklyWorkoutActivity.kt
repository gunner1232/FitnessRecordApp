package com.example.fitnessrecordapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeeklyWorkoutActivity : AppCompatActivity() {
    private lateinit var workoutSummaryList: MutableList<WorkoutSummary>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkoutSummaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly_workout)

        workoutSummaryList = mutableListOf()

        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WorkoutSummaryAdapter(workoutSummaryList)
        recyclerView.adapter = adapter

        val btnAddWorkout: Button = findViewById(R.id.btnAddWorkout2)
        btnAddWorkout.setOnClickListener {
            showAddWorkoutFragment1()
        }
    }

    private fun showAddWorkoutFragment1() {
        val fragment = AddWorkoutFragment1()
        fragment.show(supportFragmentManager, "AddWorkoutFragment1")
    }

    fun addWorkoutSummary(workoutSummary: WorkoutSummary) {
        workoutSummaryList.add(workoutSummary)
        adapter.notifyItemInserted(workoutSummaryList.size - 1)
    }
}