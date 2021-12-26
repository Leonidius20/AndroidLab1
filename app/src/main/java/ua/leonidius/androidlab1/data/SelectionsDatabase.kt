package ua.leonidius.androidlab1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.leonidius.androidlab1.dao.SelectionRecordDao
import ua.leonidius.androidlab1.domain.SelectionRecord

@Database(entities = [SelectionRecord::class], version = 1)
abstract class SelectionsDatabase: RoomDatabase() {

    abstract fun selectionRecordDao(): SelectionRecordDao
}