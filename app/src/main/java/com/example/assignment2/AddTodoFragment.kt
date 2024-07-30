package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_todo, container, false)

        val editText = view.findViewById<EditText>(R.id.edit_text_todo)
        val buttonAdd = view.findViewById<Button>(R.id.button_add_todo)

        buttonAdd.setOnClickListener {
            val todoText = editText.text.toString()
            if (todoText.isNotEmpty()) {
                (activity as MainActivity).addTodoItem(todoText)
                editText.text.clear()
            }
        }

        return view
    }
}
