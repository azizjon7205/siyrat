package uz.bismillah.siyrat.data.resourse.local.data_store

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.bismillah.siyrat.utils.Constants.APP_PREFS_NAME
import uz.bismillah.siyrat.utils.Constants.PREF_APP_THEME_MODE
import uz.bismillah.siyrat.utils.ThemeModeState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesHelper @Inject constructor(
    @ApplicationContext context: Context
) {

    private val masterKey by lazy {
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
    }

    val preferences by lazy {
        EncryptedSharedPreferences.create(
            context,
            APP_PREFS_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun setTheme(order: String) {
        preferences.edit {
            putString(PREF_APP_THEME_MODE, order)
        }
    }

    fun getTheme() = preferences.getString(PREF_APP_THEME_MODE, ThemeModeState.SYSTEM.name)

}