package com.vmadalin.core.di.modules

import android.content.Context
import androidx.room.Room
import com.vmadalin.core.BuildConfig
import com.vmadalin.core.database.MarvelDatabase
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteDao
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteRepository
import com.vmadalin.core.database.migrations.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 */
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMarvelDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            BuildConfig.MARVEL_DATABASE_NAME
        ).addMigrations(MIGRATION_1_2)
            .build()

    @Singleton
    @Provides
    fun provideCharacterFavoriteDao(marvelDatabase: MarvelDatabase) =
        marvelDatabase.characterFavoriteDao()

    @Singleton
    @Provides
    fun provideCharacterFavoriteRepository(
        characterFavoriteDao: CharacterFavoriteDao
    ) = CharacterFavoriteRepository(characterFavoriteDao)
}