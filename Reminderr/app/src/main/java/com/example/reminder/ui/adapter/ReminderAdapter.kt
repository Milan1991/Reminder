package com.example.reminder.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reminder.R
import com.example.reminder.domain.entity.ReminderItem

class ReminderAdapter (
    private val reminders: List<ReminderItem>,
    private var onReminderClickListener: (ReminderItem) -> Unit

) :
    RecyclerView.Adapter<ReminderAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView
        val textViewTitle: TextView


        init {
            textViewId = view.findViewById(R.id.tvName)
            textViewTitle = view.findViewById(R.id.tvDetail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.reminder_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount() = reminders.size


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = reminders[position]
        holder.textViewId.text = item.id.toString()
        holder.textViewTitle.text = item.title
        holder.itemView.setOnClickListener {
            onReminderClickListener(item)
        }
    }
    }