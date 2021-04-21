package com.vmadalin.dynamicfeatures.characterslist.ui.list.di

import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListFragment
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
    modules = [CharactersListModule::class],
    dependencies = [CoreComponent::class]
)
interface CharactersListComponent {
    fun inject(listFragment: CharactersListFragment)
}