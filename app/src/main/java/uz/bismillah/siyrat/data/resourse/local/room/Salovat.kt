package uz.bismillah.siyrat.data.resourse.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Salovat(
    val id :Int,
    val arabicText:String,
    val uzbekText:String,
    var todayCount:Int,
    var allCount:Int
)