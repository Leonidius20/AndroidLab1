package ua.leonidius.androidlab1.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
data class SelectionRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val selection: String,
    val time: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
)
