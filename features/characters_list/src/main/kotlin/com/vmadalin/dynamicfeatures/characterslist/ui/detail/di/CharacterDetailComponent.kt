package com.vmadalin.dynamicfeatures.characterslist.ui.detail.di

import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.CharacterDetailFragment
import dagger.Component

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * @description : TODO
 * </pre>
 */
@FeatureScope
@Component(
    modules = [CharacterDetailModule::class],
    dependencies = [CoreComponent::class]
)
interface CharacterDetailComponent {
    fun inject(detailFragment: CharacterDetailFragment)
}