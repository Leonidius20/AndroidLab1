package ua.leonidius.androidlab1.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class SelectionRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val selection: String,
    val time: String = LocalDateTime.now().toString()
)
