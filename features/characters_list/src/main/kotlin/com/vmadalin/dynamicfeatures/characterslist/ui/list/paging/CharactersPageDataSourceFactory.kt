package com.vmadalin.dynamicfeatures.characterslist.ui.list.paging

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItem
import javax.inject.Inject
import javax.inject.Provider

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
class CharactersPageDataSourceFactory
@Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val providerDataSource: Provider<CharactersPageDataSource>
) : DataSource.Factory<Int, CharacterItem>() {

    var sourceLiveData = MutableLiveData<CharactersPageDataSource>()

    override fun create(): DataSource<Int, CharacterItem> {
        val dataSource = providerDataSource.get()
        sourceLiveData.postValue(dataSource)
        return dataSource
    }

    fun refresh() {
        sourceLiveData.value?.invalidate()
    }

    fun retry() {
        sourceLiveData.value?.retry()
    }
}