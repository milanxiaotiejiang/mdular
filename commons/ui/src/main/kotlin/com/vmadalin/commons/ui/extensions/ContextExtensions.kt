package com.vmadalin.commons.ui.extensions

import android.content.Context
import androidx.annotation.StringRes

fun Context.getString(@StringRes resId: Int?) =
    resId?.let {
        getString(it)
    } ?: run {
        ""
    }
