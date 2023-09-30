package uz.bismillah.siyrat.data.resourse.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Salovat::class], version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun salovatDao():SalovatDao
}