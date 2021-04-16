package com.vmadalin.dynamicfeatures.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.navigation.ui.NavigationUI
import com.vmadalin.android.SampleApp
import com.vmadalin.commons.ui.base.BaseFragment
import com.vmadalin.commons.ui.extensions.setupWithNavController
import com.vmadalin.core.utils.ThemeUtils
import com.vmadalin.dynamicfeatures.home.R
import com.vmadalin.dynamicfeatures.home.databinding.FragmentHomeBinding
import com.vmadalin.dynamicfeatures.home.ui.di.DaggerHomeComponent
import com.vmadalin.dynamicfeatures.home.ui.di.HomeModule
import javax.inject.Inject

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
private const val DELAY_TO_APPLY_THEME = 1000L

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {

    @Inject
    lateinit var themeUtils: ThemeUtils

    private val navGraphIds = listOf(
        R.navigation.navigation_characters_list_graph,
        R.navigation.navigation_characters_favorites_graph
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
        menu.findItem(R.id.menu_toggle_theme).apply {
            val actionView = this.actionView
            if (actionView is ToggleThemeCheckBox) {
                actionView.isChecked = themeUtils.isDarkTheme(requireContext())
                actionView.setOnCheckedChangeListener { _, isChecked ->
                    themeUtils.setNightMode(isChecked, DELAY_TO_APPLY_THEME)
                }
            }
        }
    }

    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(SampleApp.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    private fun setupToolbar() {
        setHasOptionsMenu(true)
        requireCompatActivity().setSupportActionBar(viewBinding.toolbar)
    }

    private fun setupBottomNavigationBar() {
        val navController = viewBinding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container,
            intent = requireActivity().intent
        )
        navController.observe(viewLifecycleOwner) {
            viewModel.navigationControllerChanged(it)
            NavigationUI.setupActionBarWithNavController(requireCompatActivity(), it)
        }
    }
}