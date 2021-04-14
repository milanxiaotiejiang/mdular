package com.vmadalin.core.database.characterfavorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/14
 * </pre>
 */
@Dao
interface CharacterFavoriteDao {
    @Query("SELECT * FROM character_favorite ORDER BY name")
    fun getAllCharactersFavoriteLiveData(): LiveData<List<CharacterFavorite>>

    @Query("SELECT * FROM character_favorite ORDER BY name")
    suspend fun getAllCharactersFavorite(): List<CharacterFavorite>

    @Query("SELECT * FROM character_favorite WHERE id = :characterFavoriteId")
    suspend fun getCharacterFavorite(characterFavoriteId: Long): CharacterFavorite?

    @Query("DELETE FROM character_favorite")
    suspend fun deleteAllCharactersFavorite()

    @Query("DELETE FROM character_favorite WHERE id = :characterFavoriteId")
    suspend fun deleteCharacterFavoriteById(characterFavoriteId: Long)

    @Delete
    suspend fun deleteCharacterFavorite(character: CharacterFavorite)

    @Insert
    suspend fun insertCharactersFavorites(characters: List<CharacterFavorite>)

    @Insert
    suspend fun insertCharacterFavorite(character: CharacterFavorite)
}