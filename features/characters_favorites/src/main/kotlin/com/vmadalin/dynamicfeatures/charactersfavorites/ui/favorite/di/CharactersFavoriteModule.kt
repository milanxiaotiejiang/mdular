package com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.di

import androidx.annotation.VisibleForTesting
import com.vmadalin.commons.ui.extensions.viewModel
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteRepository
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.CharactersFavoriteFragment
import com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.CharactersFavoriteViewModel
import com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.adapter.CharactersFavoriteAdapter
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * </pre>
 */
@Module
class CharactersFavoriteModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: CharactersFavoriteFragment
) {

    @Provides
    @FeatureScope
    fun providesCharactersFavoriteViewModel(
        characterFavoriteRepository: CharacterFavoriteRepository
    ): CharactersFavoriteViewModel {
        return fragment.viewModel {
            CharactersFavoriteViewModel(characterFavoriteRepository)
        }
    }

    @Provides
    @FeatureScope
    fun providesCharactersFavoriteAdapter() = CharactersFavoriteAdapter()

}