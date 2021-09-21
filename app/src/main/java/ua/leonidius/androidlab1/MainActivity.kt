package ua.leonidius.androidlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {

    private lateinit var languagesList: RecyclerView
    private lateinit var languageEditText: EditText
    private lateinit var okButton: Button
    private lateinit var cancelButton: Button
    private lateinit var expandButton: ImageButton

    private var lastSelectedText: CharSequence = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        languagesList = findViewById(R.id.languages_list)
        languageEditText = findViewById(R.id.language_edittext)
        okButton = findViewById(R.id.ok_button)
        cancelButton = findViewById(R.id.cancel_button)
        expandButton = findViewById(R.id.collapse_button)

        languagesList.let {
            it.adapter = RecyclerArrayAdapter(this, R.array.languages) {
                lastSelectedText = (it as TextView).text
            }
            it.layoutManager = LinearLayoutManager(this)
        }

        okButton.setOnClickListener {
            languageEditText.setText(lastSelectedText)
        }

        cancelButton.setOnClickListener {
            languageEditText.text.clear()
        }

        expandButton.setOnClickListener {
            with(languagesList) {
                if (visibility == View.INVISIBLE) {
                    visibility =  View.VISIBLE
                    expandButton.setImageResource(android.R.drawable.arrow_up_float)
                } else {
                    visibility = View.INVISIBLE
                    expandButton.setImageResource(android.R.drawable.arrow_down_float)
                }
            }
        }

    }

}