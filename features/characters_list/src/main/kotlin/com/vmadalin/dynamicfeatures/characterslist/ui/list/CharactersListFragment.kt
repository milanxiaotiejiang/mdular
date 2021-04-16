package com.vmadalin.dynamicfeatures.characterslist.ui.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.vmadalin.android.SampleApp
import com.vmadalin.commons.ui.base.BaseFragment
import com.vmadalin.commons.ui.extensions.gridLayoutManager
import com.vmadalin.commons.ui.extensions.observe
import com.vmadalin.dynamicfeatures.characterslist.R
import com.vmadalin.dynamicfeatures.characterslist.databinding.FragmentCharactersListBinding
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.CharactersListAdapter
import com.vmadalin.dynamicfeatures.characterslist.ui.list.adapter.CharactersListAdapterState
import com.vmadalin.dynamicfeatures.characterslist.ui.list.di.CharactersListModule
import com.vmadalin.dynamicfeatures.characterslist.ui.list.di.DaggerCharactersListComponent
import javax.inject.Inject

class CharactersListFragment : BaseFragment<FragmentCharactersListBinding, CharactersListViewModel>(
    R.layout.fragment_characters_list
) {

    @Inject
    lateinit var viewAdapter: CharactersListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state) {
            when (it) {
                is CharactersListViewState.Loaded ->
                    viewAdapter.submitState(CharactersListAdapterState.Added)
                is CharactersListViewState.AddLoading ->
                    viewAdapter.submitState(CharactersListAdapterState.AddLoading)
                is CharactersListViewState.AddError ->
                    viewAdapter.submitState(CharactersListAdapterState.AddError)
                is CharactersListViewState.NoMoreElements ->
                    viewAdapter.submitState(CharactersListAdapterState.NoMore)
            }
        }
        observe(viewModel.data) {
            viewAdapter.submitList(it)
        }
        observe(viewModel.event) {
            when (it) {
                is CharactersListViewEvent.OpenCharacterDetail ->
                    findNavController().navigate(
                        CharactersListFragmentDirections
                            .actionCharactersListFragmentToCharacterDetailFragment(it.id)
                    )
            }
        }
    }

    override fun onInitDependencyInjection() {
        DaggerCharactersListComponent
            .builder()
            .coreComponent(SampleApp.coreComponent(requireContext()))
            .charactersListModule(CharactersListModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
        viewBinding.includeList.charactersList.apply {
            adapter = viewAdapter
            gridLayoutManager?.spanSizeLookup = viewAdapter.getSpanSizeLookup()
        }
    }

}