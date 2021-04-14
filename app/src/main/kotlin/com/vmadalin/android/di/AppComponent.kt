package com.vmadalin.android.di

import com.vmadalin.android.SampleApp
import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.scopes.AppScope
import dagger.Component

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(application: SampleApp)
}