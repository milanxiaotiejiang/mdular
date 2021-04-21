package com.vmadalin.dynamicfeatures.characterslist.ui.list

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
sealed class CharactersListViewEvent {
    data class OpenCharacterDetail(val id: Long) : CharactersListViewEvent()
}