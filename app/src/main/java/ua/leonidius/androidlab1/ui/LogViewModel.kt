package ua.leonidius.androidlab1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.leonidius.androidlab1.LabApplication
import ua.leonidius.androidlab1.domain.SelectionRecord

class LogViewModel: ViewModel() {

    val records = MutableLiveData<Array<SelectionRecord>>()

    fun loadRecords() {
        viewModelScope.launch {
            records.value = LabApplication.db.selectionRecordDao().getAll().toTypedArray()
        }
    }
}