package com.vmadalin.dynamicfeatures.characterslist.ui.list.di

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.viewModelScope
import com.vmadalin.commons.ui.extensions.viewModel
import com.vmadalin.core.di.scopes.FeatureScope
import com.vmadalin.core.network.repositiories.MarvelRepository
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListFragment
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListViewModel
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.CharactersListAdapter
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItemMapper
import com.vmadalin.dynamicfeatures.characterslist.ui.list.paging.CharactersPageDataSource
import com.vmadalin.dynamicfeatures.characterslist.ui.list.paging.CharactersPageDataSourceFactory
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
class CharactersListModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: CharactersListFragment
) {

    @FeatureScope
    @Provides
    fun providesCharactersListViewModel(
        dataFactory: CharactersPageDataSourceFactory
    ) = fragment.viewModel {
        CharactersListViewModel(dataFactory)
    }

    @Provides
    fun providesCharactersPageDataSource(
        viewModel: CharactersListViewModel,
        repository: MarvelRepository,
        mapper: CharacterItemMapper
    ) = CharactersPageDataSource(
        repository = repository,
        scope = viewModel.viewModelScope,
        mapper = mapper
    )

    @FeatureScope
    @Provides
    fun providesCharacterItemMapper() = CharacterItemMapper()

    @FeatureScope
    @Provides
    fun providesCharactersListAdapter(
        viewModel: CharactersListViewModel
    ) = CharactersListAdapter(viewModel)
}