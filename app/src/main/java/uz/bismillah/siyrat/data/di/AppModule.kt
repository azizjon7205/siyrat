package uz.bismillah.siyrat.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.bismillah.siyrat.data.resourse.local.data_store.SharedPreferencesHelper
import uz.bismillah.siyrat.data.resourse.local.room.AppDatabase
import uz.bismillah.siyrat.data.resourse.local.room.SalovatDao
import javax.inject.Singleton

object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    class DatabaseModule {
        @Provides
        @Singleton
        fun provideSalovatDao(appDatabase: AppDatabase): SalovatDao {
            return appDatabase.salovatDao()
        }


        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "AppDatabase"
            ).build()
        }

    }


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