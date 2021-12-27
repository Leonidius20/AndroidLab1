package ua.leonidius.androidlab1.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ua.leonidius.androidlab1.databinding.LogActivityBinding

class LogActivity : AppCompatActivity() {

    private lateinit var binding: LogActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: LogViewModel by viewModels()

        viewModel.records.observe(this) { records ->
            binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                records.map { it.time + ", " + it.selection })
        }

        viewModel.loadRecords()
    }

}