package com.vmadalin.core.mapper

interface Mapper<F, T> {

    suspend fun map(from: F): T
}
