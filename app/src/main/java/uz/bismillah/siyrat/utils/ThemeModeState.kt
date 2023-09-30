package uz.bismillah.siyrat.utils

import androidx.appcompat.app.AppCompatDelegate
import uz.bismillah.siyrat.data.resourse.local.data_store.SharedPreferencesHelper

enum class ThemeModeState {
    SYSTEM, DARK, LIGHT
}

fun setChangeAppTheme(shared: SharedPreferencesHelper) {
    when (shared.getTheme()) {
        ThemeModeState.SYSTEM.name -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        ThemeModeState.LIGHT.name -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        ThemeModeState.DARK.name -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}