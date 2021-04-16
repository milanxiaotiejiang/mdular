package com.vmadalin.dynamicfeatures.home.ui.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.vmadalin.commons.ui.extensions.viewModel
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.home.ui.HomeFragment
import com.vmadalin.dynamicfeatures.home.ui.HomeViewModel
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * @description : TODO
 * </pre>
 */
@Module
class HomeModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: HomeFragment
) {
    @Provides
    @FeatureScope
    fun providesHomeViewModel() = fragment.viewModel {
        HomeViewModel()
    }
}