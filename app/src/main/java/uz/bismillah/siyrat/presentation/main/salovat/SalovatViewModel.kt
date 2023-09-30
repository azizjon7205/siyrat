package uz.bismillah.siyrat.presentation.main.salovat

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

   private val _arabicText = MutableLiveData<String>("")
   val arabicText : LiveData<String> = _arabicText

   private val _uzbekText = MutableLiveData<String>("")
   val uzbekText : LiveData<String> = _uzbekText

   private val _countToday = MutableLiveData<Int>(0)
   val countToday : LiveData<Int> = _countToday

   private val _countAll = MutableLiveData<Int>(0)
   val countAll : LiveData<Int> = _countAll

   private val _activeSalovat = MutableLiveData<Salovat>()
   val activeSalovat:LiveData<Salovat> = _activeSalovat



}