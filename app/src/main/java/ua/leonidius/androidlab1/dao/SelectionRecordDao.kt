package ua.leonidius.androidlab1.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ua.leonidius.androidlab1.domain.SelectionRecord

@Dao
interface SelectionRecordDao {

    @Query("select * from SelectionRecord")
    suspend fun getAll(): List<SelectionRecord>

    @Insert
    suspend fun insert(item: SelectionRecord)

}