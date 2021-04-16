package com.vmadalin.dynamicfeatures.home.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.vmadalin.dynamicfeatures.home.R

/**
 * <pre>
 * @user : milanxiaotiejiang
 * @email : 765151629@qq.com
 * @version : 1.0
 * @date : 2021/4/16
 * </pre>
 */
class ToggleThemeCheckBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatCheckBox(context, attrs) {
    init {
        setButtonDrawable(R.drawable.asl_theme)
    }
}