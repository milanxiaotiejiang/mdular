package com.vmadalin.core.extensions

import java.security.MessageDigest

fun String.toMD5() =
    MessageDigest
        .getInstance("MD5")
        .digest(toByteArray())
        .toHex()
