package com.vmadalin.dynamicfeatures.characterslist.ui.list.model

import com.vmadalin.core.mapper.Mapper
import com.vmadalin.core.network.responses.BaseResponse
import com.vmadalin.core.network.responses.CharacterResponse

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
private const val IMAGE_URL_FORMAT = "%s.%s"

class CharacterItemMapper : Mapper<BaseResponse<CharacterResponse>, List<CharacterItem>> {
    override suspend fun map(from: BaseResponse<CharacterResponse>): List<CharacterItem> {
        return from.data.results.map {
            CharacterItem(
                id = it.id,
                name = it.name,
                description = it.description,
                imageUrl = IMAGE_URL_FORMAT.format(
                    it.thumbnail.path.replace("http", "https"),
                    it.thumbnail.extension
                )
            )
        }
    }
}