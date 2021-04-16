package com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vmadalin.commons.ui.base.BasePagedListAdapter
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListViewModel
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.holders.CharacterViewHolder
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.holders.ErrorViewHolder
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.holders.LoadingViewHolder
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItem
import javax.inject.Inject

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
internal enum class ItemView(val type: Int, val span: Int) {
    CHARACTER(type = 0, span = 1),
    LOADING(type = 1, span = 2),
    ERROR(type = 2, span = 2);

    companion object {
        fun valueOf(type: Int): ItemView = values().first { it.type == type }
    }
}

class CharactersListAdapter @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val viewModel: CharactersListViewModel
) : BasePagedListAdapter<CharacterItem>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    private var state: CharactersListAdapterState = CharactersListAdapterState.Added

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (ItemView.valueOf(viewType)) {
            ItemView.CHARACTER -> CharacterViewHolder(inflater)
            ItemView.LOADING -> LoadingViewHolder(inflater)
            else -> ErrorViewHolder(inflater)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemView(position)) {
            ItemView.CHARACTER ->
                getItem(position)?.let {
                    if (holder is CharacterViewHolder) {
                        holder.bind(viewModel, it)
                    }
                }
            ItemView.ERROR ->
                if (holder is ErrorViewHolder) {
                    holder.bind(viewModel)
                }
            else -> {
            }
        }
    }

    override fun getItemId(position: Int) =
        when (getItemView(position)) {
            ItemView.CHARACTER -> getItem(position)?.id ?: -1L
            ItemView.LOADING -> 0L
            ItemView.ERROR -> 1L
        }

    override fun getItemCount() =
        if (state.hasExtraRow) {
            super.getItemCount() + 1
        } else {
            super.getItemCount()
        }

    override fun getItemViewType(position: Int) = getItemView(position).type
    fun submitState(newState: CharactersListAdapterState) {
        val oldState = state
        state = newState
        if (newState.hasExtraRow && oldState != newState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    fun getSpanSizeLookup(): GridLayoutManager.SpanSizeLookup =
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return getItemView(position).span
            }
        }

    internal fun getItemView(position: Int) =
        if (state.hasExtraRow && position == itemCount - 1) {
            if (state.isAddError()) {
                ItemView.ERROR
            } else {
                ItemView.LOADING
            }
        } else {
            ItemView.CHARACTER
        }
}