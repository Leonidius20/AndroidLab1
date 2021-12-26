package ua.leonidius.androidlab1

import android.app.Application
import androidx.room.Room
import ua.leonidius.androidlab1.data.SelectionsDatabase

class LabApplication : Application() {

    companion object {
        lateinit var db: SelectionsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            SelectionsDatabase::class.java, "selections-database"
        ).build()
    }

}