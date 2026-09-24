/* ============================================================================
 * File        : ViewModelFactory.kt
 * Purpose     : Builds the view models by hand from the service locator, so the
 *               project stays free of any dependency-injection framework.
 *               Matches the shape of the real project's ViewModelFactory; each
 *               member adds their own `when` branch here when their ViewModel
 *               and its repository exist - none do yet on main.
 * Author      : Shewon Gunarathne
 * Created     : 2026-09-25
 * ==========================================================================*/
package com.example.smartgrid_mobile.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object AppViewModelFactory : ViewModelProvider.Factory {

    /** Maps a view model class onto its constructor, injecting the shared repository. */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            // TODO (each member, on their own branch), e.g.:
            //   modelClass.isAssignableFrom(LoginViewModel::class.java) ->
            //       LoginViewModel(ServiceLocator.authRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: ${modelClass.name}")
        }
    }
}
