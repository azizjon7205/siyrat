package uz.bismillah.siyrat.data.resourse.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Salovatlar")
data class Salovat(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    @ColumnInfo(name = "arabic_text")
    val arabicText:String,
    @ColumnInfo(name = "uzbek_text")
    val uzbekText:String,
    @ColumnInfo(name = "today_count")
    val todayCount:Int,
    @ColumnInfo(name = "all_count")
    val allCount:Int
)