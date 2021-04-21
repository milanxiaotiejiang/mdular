package com.vmadalin.dynamicfeatures.characterslist.ui.detail.model

import com.vmadalin.core.mapper.Mapper
import com.vmadalin.core.network.responses.BaseResponse
import com.vmadalin.core.network.responses.CharacterResponse

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/21
 * </pre>
 */
private const val IMAGE_URL_FORMAT = "%s.%s"

class CharacterDetailMapper : Mapper<BaseResponse<CharacterResponse>, CharacterDetail> {
    override suspend fun map(from: BaseResponse<CharacterResponse>): CharacterDetail {
        val characterResponse = from.data.results.first()
        return CharacterDetail(
            id = characterResponse.id,
            name = characterResponse.name,
            description = characterResponse.description,
            imageUrl = IMAGE_URL_FORMAT.format(
                characterResponse.thumbnail.path.replace("http", "https"),
                characterResponse.thumbnail.extension
            )
        )
    }
}