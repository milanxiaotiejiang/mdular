package com.vmadalin.dynamicfeatures.home.ui.di

import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.home.ui.HomeFragment
import dagger.Component

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}