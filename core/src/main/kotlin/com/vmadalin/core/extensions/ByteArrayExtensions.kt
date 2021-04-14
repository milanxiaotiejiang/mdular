package com.vmadalin.core.extensions

fun ByteArray.toHex() = joinToString("") {
    "%02x".format(it)
}
