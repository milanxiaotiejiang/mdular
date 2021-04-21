package com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite

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
sealed class CharactersFavoriteViewState : BaseViewState {
    object Empty : CharactersFavoriteViewState()
    object Listed : CharactersFavoriteViewState()

    fun isEmpty() = this is Empty
    fun isListed() = this is Listed
}