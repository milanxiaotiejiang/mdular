package com.vmadalin.dynamicfeatures.characterslist.ui.detail

import com.vmadalin.commons.ui.base.BaseViewState

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * @description : TODO
 * </pre>
 */
sealed class CharacterDetailViewState : BaseViewState {
    object Loading : CharacterDetailViewState()
    object Error : CharacterDetailViewState()
    object AddToFavorite : CharacterDetailViewState()
    object AddedToFavorite : CharacterDetailViewState()
    object AlreadyAddedToFavorite : CharacterDetailViewState()
    object Dismiss : CharacterDetailViewState()

    fun isLoading() = this is Loading
    fun isError() = this is Error
    fun isAddToFavorite() = this is AddToFavorite
    fun isAddedToFavorite() = this is AddedToFavorite
    fun isAlreadyAddedToFavorite() = this is AlreadyAddedToFavorite
    fun isDismiss() = this is Dismiss
}
