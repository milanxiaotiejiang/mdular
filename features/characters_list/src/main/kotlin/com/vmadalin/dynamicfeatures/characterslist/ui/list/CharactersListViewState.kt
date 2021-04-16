package com.vmadalin.dynamicfeatures.characterslist.ui.list

import com.vmadalin.commons.ui.base.BaseViewState

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
sealed class CharactersListViewState : BaseViewState {

    /**
     * Refreshing characters list.
     */
    object Refreshing : CharactersListViewState()

    /**
     * Loaded characters list.
     */
    object Loaded : CharactersListViewState()

    /**
     * Loading characters list.
     */
    object Loading : CharactersListViewState()

    /**
     * Loading on add more elements into characters list.
     */
    object AddLoading : CharactersListViewState()

    /**
     * Empty characters list.
     */
    object Empty : CharactersListViewState()

    /**
     * Error on loading characters list.
     */
    object Error : CharactersListViewState()

    /**
     * Error on add more elements into characters list.
     */
    object AddError : CharactersListViewState()

    /**
     * No more elements for adding into characters list.
     */
    object NoMoreElements : CharactersListViewState()

    // ============================================================================================
    //  Public helpers methods
    // ============================================================================================

    /**
     * Check if current view state is [Refreshing].
     *
     * @return True if is refreshing state, otherwise false.
     */
    fun isRefreshing() = this is Refreshing

    /**
     * Check if current view state is [Loaded].
     *
     * @return True if is loaded state, otherwise false.
     */
    fun isLoaded() = this is Loaded

    /**
     * Check if current view state is [Loading].
     *
     * @return True if is loading state, otherwise false.
     */
    fun isLoading() = this is Loading

    /**
     * Check if current view state is [AddLoading].
     *
     * @return True if is add loading state, otherwise false.
     */
    fun isAddLoading() = this is AddLoading

    /**
     * Check if current view state is [Empty].
     *
     * @return True if is empty state, otherwise false.
     */
    fun isEmpty() = this is Empty

    /**
     * Check if current view state is [Error].
     *
     * @return True if is error state, otherwise false.
     */
    fun isError() = this is Error

    /**
     * Check if current view state is [AddError].
     *
     * @return True if is add error state, otherwise false.
     */
    fun isAddError() = this is AddError

    /**
     * Check if current view state is [NoMoreElements].
     *
     * @return True if is no more elements state, otherwise false.
     */
    fun isNoMoreElements() = this is NoMoreElements
}