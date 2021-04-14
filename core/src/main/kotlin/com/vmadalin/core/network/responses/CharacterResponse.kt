package com.vmadalin.core.network.responses

import com.vmadalin.core.annotations.OpenForTesting

@OpenForTesting
data class CharacterResponse(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: CharacterThumbnailResponse
)
