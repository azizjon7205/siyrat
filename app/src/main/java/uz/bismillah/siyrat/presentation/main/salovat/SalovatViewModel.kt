package uz.bismillah.siyrat.presentation.main.salovat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.bismillah.siyrat.data.repository.SalovatRepository
import uz.bismillah.siyrat.data.resourse.local.room.Salovat
import javax.inject.Inject

@HiltViewModel
class SalovatViewModel @Inject constructor(
   private val salovatRepository: SalovatRepository
) :ViewModel(){

    var counter = 0

   private val _salovatList = MutableLiveData<List<Salovat>>()
   val salovatList:LiveData<List<Salovat>> = _salovatList

   private val _countToday = MutableLiveData<Int>(0)
   val countToday : LiveData<Int> = _countToday

   private val _countAll = MutableLiveData<Int>(0)
   val countAll : LiveData<Int> = _countAll

   private val _activeSalovat = MutableLiveData<Salovat>(salovatRepository.listSalovat[0])
   val activeSalovat:LiveData<Salovat> = _activeSalovat

   fun changeActiveSalovat(id:Int){
      Log.d("TTTT", "changeActiveSalovat: ${activeSalovat.value!!.id}")
      salovatRepository.updateSalovat(activeSalovat.value!!.id,counter)
      counter=0
      _activeSalovat.value = salovatRepository.listSalovat[id]
   }

   fun getAllSalovat(){
      _salovatList.value =  salovatRepository.listSalovat
   }

   fun setZero(){
      _countToday.value = counter
   }

   fun count(){
      counter++
      _countToday.value = counter
      _countAll.value = counter
   }



}