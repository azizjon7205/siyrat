package uz.bismillah.siyrat.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    class SharedPreferencesModule {

        @Singleton
        @Provides
        fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
            return context.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        }
    }


}