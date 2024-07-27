package com.example.fitnessrecordapp
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var workoutList: MutableList<Workout>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workoutList = mutableListOf()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WorkoutAdapter(workoutList)
        recyclerView.adapter = adapter

        val btnAddWorkout: Button = findViewById(R.id.btnAddWorkout)
        btnAddWorkout.setOnClickListener {
            showAddWorkoutFragment()
        }
    }

    private fun showAddWorkoutFragment() {
        val fragment = AddWorkoutFragment()
        fragment.show(supportFragmentManager, "AddWorkoutFragment")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_today -> {
                // 处理 "Today's Workout" 菜单项点击事件
                true
            }
            R.id.action_week -> {
                // 处理 "Weekly Workout Stats" 菜单项点击事件
                val intent = Intent(this, WeeklyWorkoutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun addWorkout(workout: Workout) {
        workoutList.add(workout)
        adapter.notifyItemInserted(workoutList.size - 1)
    }
}