package com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.holders

import android.view.LayoutInflater
import com.vmadalin.commons.ui.base.BaseViewHolder
import com.vmadalin.dynamicfeatures.characterslist.databinding.ListItemErrorBinding
import com.vmadalin.dynamicfeatures.characterslist.ui.list.CharactersListViewModel

class ErrorViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ListItemErrorBinding>(
    binding = ListItemErrorBinding.inflate(inflater)
) {

    fun bind(viewModel: CharactersListViewModel) {
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
