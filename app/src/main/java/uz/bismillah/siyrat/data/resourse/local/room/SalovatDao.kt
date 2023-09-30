package uz.bismillah.siyrat.data.resourse.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SalovatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item:Salovat)

    @Query("select *  from Salovatlar")
    fun getAll(): Flow<List<Salovat>>

    @Update
    suspend fun update(item: Salovat)
}