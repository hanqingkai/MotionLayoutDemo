package com.example.motionlayoutdemo.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

/**
 *
 * @Description:     java类作用描述
 * @Author:         hqk
 * @CreateDate:     2022/1/11 18:15
 * @UpdateUser:     更新者：
 * @UpdateDate:     2022/1/11 18:15
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class CollapsibleToolbar @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attributeSet, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}