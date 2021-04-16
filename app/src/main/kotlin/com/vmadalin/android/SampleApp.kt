package com.vmadalin.android

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.vmadalin.android.di.DaggerAppComponent
import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.DaggerCoreComponent
import com.vmadalin.core.di.modules.ContextModule
import com.vmadalin.core.utils.ThemeUtils
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 * 3b363fe5029d1135945c8f9f7bdcd10c
 * db56772ade4372a4e5065b01f8511f51e5b6aced
 */
class SampleApp : SplitCompatApplication() {

    lateinit var coreComponent: CoreComponent

    @Inject
    lateinit var themeUtils: ThemeUtils

    companion object {

        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? SampleApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initCoreDependencyInjection()
        initAppDependencyInjection()
        initRandomNightMode()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    private fun initRandomNightMode() {
        if (BuildConfig.DEBUG) {
            themeUtils.setNightMode(Random.nextBoolean())
        }
    }
}