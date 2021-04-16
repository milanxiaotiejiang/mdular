package com.vmadalin.dynamicfeatures.characterslist.ui.list

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.vmadalin.commons.ui.livedata.SingleLiveData
import com.vmadalin.core.network.NetworkState
import com.vmadalin.dynamicfeatures.characterslist.ui.list.paging.CharactersPageDataSourceFactory
import com.vmadalin.dynamicfeatures.characterslist.ui.list.paging.PAGE_MAX_ELEMENTS
import javax.inject.Inject

class CharactersListViewModel
@Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val dataSourceFactory: CharactersPageDataSourceFactory
) : ViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val networkState = Transformations.switchMap(dataSourceFactory.sourceLiveData) {
        it.networkState
    }

    val event = SingleLiveData<CharactersListViewEvent>()

    val data = LivePagedListBuilder(dataSourceFactory, PAGE_MAX_ELEMENTS).build()

    val state = Transformations.map(networkState) {
        when (it) {
            is NetworkState.Success ->
                if (it.isAdditional && it.isEmptyResponse) {
                    CharactersListViewState.NoMoreElements
                } else if (it.isEmptyResponse) {
                    CharactersListViewState.Empty
                } else {
                    CharactersListViewState.Loaded
                }
            is NetworkState.Loading ->
                if (it.isAdditional) {
                    CharactersListViewState.AddLoading
                } else {
                    CharactersListViewState.Loading
                }
            is NetworkState.Error ->
                if (it.isAdditional) {
                    CharactersListViewState.AddError
                } else {
                    CharactersListViewState.Error
                }
        }
    }

    fun refreshLoadedCharactersList() {
        dataSourceFactory.refresh()
    }

    fun retryAddCharactersList() {
        dataSourceFactory.retry()
    }

    fun openCharacterDetail(characterId: Long) {
        event.postValue(CharactersListViewEvent.OpenCharacterDetail(characterId))
    }
}