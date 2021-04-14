package com.vmadalin.core.network.responses

import com.vmadalin.core.annotations.OpenForTesting

@OpenForTesting
data class CharacterThumbnailResponse(
    val path: String,
    val extension: String
)
