package uz.bismillah.siyrat.data.repository

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import uz.bismillah.siyrat.data.resourse.local.room.Salovat
import uz.bismillah.siyrat.data.resourse.local.room.SalovatDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SalovatRepository @Inject constructor(
    private val salovatDao: SalovatDao,
    private val sharedPreferences: SharedPreferences
) {

    suspend fun insert(salovat: Salovat) =
        salovatDao.insertItem(salovat)

    suspend fun update(salovat: Salovat) =
        salovatDao.update(salovat)

    fun getAllSalovat():Flow<List<Salovat>> = salovatDao.getAll()



}