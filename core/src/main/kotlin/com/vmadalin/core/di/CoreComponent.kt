package com.vmadalin.core.di

import android.content.Context
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteDao
import com.vmadalin.core.di.modules.ContextModule
import com.vmadalin.core.di.modules.DatabaseModule
import com.vmadalin.core.di.modules.NetworkModule
import com.vmadalin.core.di.modules.UtilsModule
import com.vmadalin.core.network.repositiories.MarvelRepository
import com.vmadalin.core.network.services.MarvelService
import com.vmadalin.core.utils.ThemeUtils
import dagger.Component
import javax.inject.Singleton

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 */
@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UtilsModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun marvelService(): MarvelService

    fun marvelRepository(): MarvelRepository

    fun characterFavoriteDao(): CharacterFavoriteDao

    fun themeUtils(): ThemeUtils
}