package com.vmadalin.dynamicfeatures.home.ui

import com.vmadalin.commons.ui.base.BaseViewState

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
sealed class HomeViewState : BaseViewState {
    object FullScreen : HomeViewState()
    object NavigationScreen : HomeViewState()

    fun isFullScreen() = this is FullScreen
    fun isNavigationScreen() = this is NavigationScreen
}