package de.skoove.simplemusicplayer.framework.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.skoove.simplemusicplayer.framework.db.TestDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TestDatabase {

        return Room.databaseBuilder(
            context,
            TestDatabase::class.java,
            "music_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}