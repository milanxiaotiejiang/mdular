package com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.di

import com.vmadalin.core.di.CoreComponent
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.CharactersFavoriteFragment
import dagger.Component

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * </pre>
 */
@FeatureScope
@Component(
    modules = [CharactersFavoriteModule::class],
    dependencies = [CoreComponent::class]
)
interface CharactersFavoriteComponent {
    fun inject(favoriteFragment: CharactersFavoriteFragment)
}