package ua.leonidius.androidlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var languagesList: Spinner
    private lateinit var languageEditText: EditText
    private lateinit var okButton: Button
    private lateinit var cancelButton: Button

    private var lastSelectedText: CharSequence = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        languagesList = findViewById(R.id.languages_list)
        languageEditText = findViewById(R.id.language_edittext)
        okButton = findViewById(R.id.ok_button)
        cancelButton = findViewById(R.id.cancel_button)

        languagesList.let {
            it.adapter = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                android.R.layout.simple_spinner_item
            ).apply {
                // Specify the layout to use when the list of choices appears
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
            it.onItemSelectedListener = this
        }

        okButton.setOnClickListener {
            languageEditText.setText(lastSelectedText)
        }

        cancelButton.setOnClickListener {
            languageEditText.text.clear()
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        lastSelectedText = resources.getStringArray(R.array.languages)[position]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }


}