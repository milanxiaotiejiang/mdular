package com.vmadalin.dynamicfeatures.charactersfavorites.ui.favorite

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmadalin.core.database.characterfavorite.CharacterFavorite
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * </pre>
 */
class CharactersFavoriteViewModel @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val characterFavoriteRepository: CharacterFavoriteRepository
) : ViewModel() {

    val data = characterFavoriteRepository.getAllCharactersFavoriteLiveData()

    val state = Transformations.map(data) {
        if (it.isEmpty())
            CharactersFavoriteViewState.Empty
        else
            CharactersFavoriteViewState.Listed
    }

    fun removeFavoriteCharacter(characterFavorite: CharacterFavorite) {
        viewModelScope.launch {
            characterFavoriteRepository.deleteCharacterFavorite(characterFavorite)
        }
    }
}