package com.vmadalin.core.database.characterfavorite

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import com.vmadalin.core.database.characterfavorite.CharacterFavoriteDao
import javax.inject.Inject

class CharacterFavoriteRepository @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    internal val characterFavoriteDao: CharacterFavoriteDao
) {

    fun getAllCharactersFavoriteLiveData(): LiveData<List<CharacterFavorite>> =
        characterFavoriteDao.getAllCharactersFavoriteLiveData()

    suspend fun getAllCharactersFavorite(): List<CharacterFavorite> =
        characterFavoriteDao.getAllCharactersFavorite()

    suspend fun getCharacterFavorite(characterFavoriteId: Long): CharacterFavorite? =
        characterFavoriteDao.getCharacterFavorite(characterFavoriteId)

    suspend fun deleteAllCharactersFavorite() =
        characterFavoriteDao.deleteAllCharactersFavorite()

    suspend fun deleteCharacterFavoriteById(characterFavoriteId: Long) =
        characterFavoriteDao.deleteCharacterFavoriteById(characterFavoriteId)

    suspend fun deleteCharacterFavorite(character: CharacterFavorite) =
        characterFavoriteDao.deleteCharacterFavorite(character)

    suspend fun insertCharactersFavorites(characters: List<CharacterFavorite>) =
        characterFavoriteDao.insertCharactersFavorites(characters)

    suspend fun insertCharacterFavorite(id: Long, name: String, imageUrl: String) {
        val characterFavorite = CharacterFavorite(
            id = id,
            name = name,
            imageUrl = imageUrl
        )
        characterFavoriteDao.insertCharacterFavorite(characterFavorite)
    }
}
