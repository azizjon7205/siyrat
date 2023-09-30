package uz.bismillah.siyrat.presentation.main.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainHadith(
    val arabic: String? = null,
    val name: String? = null,
    val text: String? = null,
    val uzbek: String? = null
) : Parcelable