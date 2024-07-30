package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoListFragment : Fragment() {

    private lateinit var todoAdapter: TodoAdapter
    private val todoItems = mutableListOf<String>()
    private lateinit var textNoItems: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        todoAdapter = TodoAdapter(todoItems) { position ->
            removeTodoItem(position)
        }
        recyclerView.adapter = todoAdapter

        textNoItems = view.findViewById(R.id.text_no_items)
        updateEmptyView()

        return view
    }

    fun addTodoItem(item: String) {
        todoItems.add(item)
        todoAdapter.notifyItemInserted(todoItems.size - 1)
        updateEmptyView()
    }

    private fun removeTodoItem(position: Int) {
        if (position in todoItems.indices) {
            todoItems.removeAt(position)
            todoAdapter.notifyItemRemoved(position)
            todoAdapter.notifyItemRangeChanged(position, todoItems.size)
            updateEmptyView()
        }
    }

    private fun updateEmptyView() {
        if (todoItems.isEmpty()) {
            textNoItems.visibility = View.VISIBLE
        } else {
            textNoItems.visibility = View.GONE
        }
    }
}
