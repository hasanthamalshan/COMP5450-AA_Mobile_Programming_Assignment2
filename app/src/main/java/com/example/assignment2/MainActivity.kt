package com.example.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var todoListFragment: TodoListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoListFragment = TodoListFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_todo_list -> loadFragment(todoListFragment)
                R.id.nav_add_todo -> loadFragment(AddTodoFragment())
            }
            true
        }

        // Load the default fragment
        loadFragment(todoListFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun addTodoItem(item: String) {
        todoListFragment.addTodoItem(item)
    }
}
