package com.vmadalin.android.di

import android.content.Context
import com.vmadalin.android.SampleApp
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 */
@Module
class AppModule {
    @Provides
    fun provideContext(application: SampleApp): Context = application.applicationContext
}