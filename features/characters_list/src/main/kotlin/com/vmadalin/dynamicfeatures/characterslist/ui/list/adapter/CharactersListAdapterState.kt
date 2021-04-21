package com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
sealed class CharactersListAdapterState(val hasExtraRow: Boolean) {
    object Added : CharactersListAdapterState(hasExtraRow = true)
    object AddLoading : CharactersListAdapterState(hasExtraRow = true)
    object AddError : CharactersListAdapterState(hasExtraRow = true)
    object NoMore : CharactersListAdapterState(hasExtraRow = false)

    fun isAdded() = this is Added
    fun isAddLoading() = this is AddLoading
    fun isAddError() = this is AddError
    fun isNoMore() = this is NoMore
}