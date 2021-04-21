package com.vmadalin.dynamicfeatures.characterslist.ui.detail.di

import androidx.annotation.VisibleForTesting
import com.vmadalin.commons.ui.extensions.viewModel
import com.vmadalin.commons.views.ProgressBarDialog
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteRepository
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.core.network.repositiories.MarvelRepository
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.CharacterDetailFragment
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.CharacterDetailViewModel
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.model.CharacterDetailMapper
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * @description : TODO
 * </pre>
 */
@Module
class CharacterDetailModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: CharacterDetailFragment
) {
    @FeatureScope
    @Provides
    fun providesCharacterDetailViewModel(
        marvelRepository: MarvelRepository,
        characterFavoriteRepository: CharacterFavoriteRepository,
        characterDetailMapper: CharacterDetailMapper
    ) = fragment.viewModel {
        CharacterDetailViewModel(
            marvelRepository = marvelRepository,
            characterFavoriteRepository = characterFavoriteRepository,
            characterDetailMapper = characterDetailMapper
        )
    }

    @FeatureScope
    @Provides
    fun providesCharacterDetailMapper() = CharacterDetailMapper()

    @FeatureScope
    @Provides
    fun providesProgressBarDialog() = ProgressBarDialog(fragment.requireContext())
}