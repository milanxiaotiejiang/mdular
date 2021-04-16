package com.vmadalin.dynamicfeatures.characterslist.ui.list.paging

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.vmadalin.core.annotations.OpenForTesting
import com.vmadalin.core.network.NetworkState
import com.vmadalin.core.network.repositiories.MarvelRepository
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItem
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItemMapper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * @description : TODO
 * </pre>
 */
const val PAGE_INIT_ELEMENTS = 0
const val PAGE_MAX_ELEMENTS = 50

@OpenForTesting
class CharactersPageDataSource @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val repository: MarvelRepository,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val scope: CoroutineScope,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val mapper: CharacterItemMapper
) : PageKeyedDataSource<Int, CharacterItem>() {

    val networkState = MutableLiveData<NetworkState>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var retry: (() -> Unit)? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterItem>
    ) {
        networkState.postValue(NetworkState.Loading())
        scope.launch(
            CoroutineExceptionHandler { _, _ ->
                retry = {
                    loadInitial(params, callback)
                }
                networkState.postValue(NetworkState.Error())
            }
        ) {
            val response = repository.getCharacters(
                offset = PAGE_INIT_ELEMENTS,
                limit = PAGE_MAX_ELEMENTS
            )
            val data = mapper.map(response)
            callback.onResult(data, null, PAGE_MAX_ELEMENTS)
            networkState.postValue(NetworkState.Success(isEmptyResponse = data.isEmpty()))
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterItem>) {
        networkState.postValue(NetworkState.Loading(true))
        scope.launch(
            CoroutineExceptionHandler { _, _ ->
                retry = {
                    loadAfter(params, callback)
                }
                networkState.postValue(NetworkState.Error(true))
            }
        ) {
            val response = repository.getCharacters(
                offset = params.key,
                limit = PAGE_MAX_ELEMENTS
            )
            val data = mapper.map(response)
            callback.onResult(data, params.key + PAGE_MAX_ELEMENTS)
            networkState.postValue(NetworkState.Success(true, data.isEmpty()))
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterItem>) {
    }

    fun retry() {
        retry?.invoke()
    }
}