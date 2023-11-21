package com.example.reminder.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reminder.R
import com.example.reminder.databinding.ActivityMainBinding
import com.example.reminder.ui.fragment.ReminderFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            val fragment = ReminderFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.reminder_item_container, fragment)
                .commit()
        }
    }
    dkfkdgnkfnjgkfgkfdghfygh
}