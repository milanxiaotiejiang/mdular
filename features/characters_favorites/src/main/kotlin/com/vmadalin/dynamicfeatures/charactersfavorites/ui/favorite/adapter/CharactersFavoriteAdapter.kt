package com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vmadalin.commons.ui.base.BaseListAdapter
import com.vmadalin.core.database.characterfavorite.CharacterFavorite
import com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite.adapter.holders.CharacterFavoriteViewHolder

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * </pre>
 */
class CharactersFavoriteAdapter : BaseListAdapter<CharacterFavorite>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CharacterFavoriteViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterFavoriteViewHolder -> holder.bind(getItem(position))
        }
    }
}