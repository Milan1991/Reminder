package com.example.reminder.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.reminder.R
import com.example.reminder.data.repository.ReminderRepository
import com.example.reminder.databinding.FragmentReminderBinding
import com.example.reminder.domain.entity.ReminderItem
import com.example.reminder.ui.adapter.ReminderAdapter

enum class InputFields {
    REMINDER_NAME,
    REMINDER_DETAIL;
}

class ReminderFragment : Fragment() {
    private lateinit var binding: FragmentReminderBinding
    private lateinit var adapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderBinding.inflate(inflater, container, false)
        val remindersList = mutableListOf<ReminderItem>()
        adapter = ReminderAdapter(remindersList) { reminderItem -> /* Callback logic if needed */ }
        val recyclerView = binding.rvReminder
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()

    }

    private fun setupListeners() {
        val remindersList = mutableListOf<ReminderItem>()
        val reminderName: EditText = binding.reminderName
        val reminderDetail: EditText = binding.reminderDetail
        val btnSave: Button = binding.btnSave
        btnSave.setOnClickListener {
            val reminderFieldsValidationResult = validateFields(
                reminderName.text.toString(),
                reminderDetail.text.toString(),
            )
            if (reminderFieldsValidationResult.isNotEmpty()) {
                reminderName.error = "Please enter reminder name"
                reminderDetail.error = "Please enter reminder detail"

            }else{

                val reminder = ReminderItem()
                remindersList.add(reminder)
                adapter.notifyDataSetChanged()

                cleanFields()
            }
        }
    }


    private fun cleanFields() {
        binding.reminderName.setText("")
        binding.reminderDetail.setText("")
    }

    private fun validateFields(
        remName: String,
        remDetail: String,
    ): MutableMap<InputFields, Boolean> {
        val inputFields: MutableMap<InputFields, Boolean> = mutableMapOf()

        if (remName.isEmpty()) {
            inputFields[InputFields.REMINDER_NAME] = false
        }

        if (remDetail.isEmpty()) {
            inputFields[InputFields.REMINDER_DETAIL] = false
        }

        return inputFields
    }

}