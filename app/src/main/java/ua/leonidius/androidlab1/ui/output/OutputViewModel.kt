package ua.leonidius.androidlab1.ui.output

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.leonidius.androidlab1.LabApplication
import ua.leonidius.androidlab1.domain.SelectionRecord

class OutputViewModel: ViewModel() {

    val saved = MutableLiveData(false)

    fun saveRecord(selection: String) {
        val record = SelectionRecord(selection = selection)
        viewModelScope.launch {
            LabApplication.db.selectionRecordDao().insert(record)
            saved.value = true
        }
    }

}