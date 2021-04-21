package com.vmadalin.dynamicfeatures.characterslist.ui.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.vmadalin.android.SampleApp
import com.vmadalin.commons.ui.base.BaseFragment
import com.vmadalin.commons.ui.extensions.observe
import com.vmadalin.commons.views.ProgressBarDialog
import com.vmadalin.dynamicfeatures.characterslist.R
import com.vmadalin.dynamicfeatures.characterslist.databinding.FragmentCharacterDetailBinding
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.di.CharacterDetailModule
import com.vmadalin.dynamicfeatures.characterslist.ui.detail.di.DaggerCharacterDetailComponent
import javax.inject.Inject

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterDetailViewModel>(
        layoutId = R.layout.fragment_character_detail
    ) {

    @Inject
    lateinit var progressDialog: ProgressBarDialog

    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state) {
            when (it) {
                is CharacterDetailViewState.Loading ->
                    progressDialog.show(R.string.character_detail_dialog_loading_text)
                is CharacterDetailViewState.Error ->
                    progressDialog.dismissWithErrorMessage(R.string.character_detail_dialog_error_text)
                is CharacterDetailViewState.AddedToFavorite ->
                    Snackbar.make(
                        requireView(),
                        R.string.character_detail_added_to_favorite_message,
                        Snackbar.LENGTH_LONG
                    ).show()
                is CharacterDetailViewState.Dismiss ->
                    findNavController().navigateUp()
                else -> progressDialog.dismiss()
            }
        }
        viewModel.loadCharacterDetail(args.characterId)
    }

    override fun onInitDependencyInjection() {
        DaggerCharacterDetailComponent
            .builder()
            .coreComponent(SampleApp.coreComponent(requireContext()))
            .characterDetailModule(CharacterDetailModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}