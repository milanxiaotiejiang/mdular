package com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.holders

import android.view.LayoutInflater
import com.vmadalin.commons.ui.base.BaseViewHolder
import com.vmadalin.dynamicfeatures.characterslist.databinding.ListItemCharacterBinding
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListViewModel
import com.vmadalin.dynamicfeatures.characterslist.ui.list.model.CharacterItem

class CharacterViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ListItemCharacterBinding>(
    binding = ListItemCharacterBinding.inflate(inflater)
) {

    fun bind(viewModel: CharactersListViewModel, item: CharacterItem) {
        binding.viewModel = viewModel
        binding.character = item
        binding.executePendingBindings()
    }
}
