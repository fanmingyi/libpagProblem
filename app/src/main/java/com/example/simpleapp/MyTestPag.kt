package com.example.simpleapp

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.core.view.isVisible
import org.libpag.PAGView

class MyTestPag @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PAGView(context, attrs, defStyleAttr) {
    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        Log
            .d(
                TAG,
                "MyTestPag invoke setVisibility visibility $visibility     isShow ${isShown()} getJ ${getjFileInfo()}"
            )
    }

    val TAG = "MyTestPag"
    override fun onVisibilityAggregated(isVisible: Boolean) {
        super.onVisibilityAggregated(isVisible)
        Log.d(TAG, "MyTestPag invoke onVisibilityAggregated  $isVisible     isShow ${isShown()} getJ ${getjFileInfo()}"
        )
    }

    fun getjFileInfo(): Boolean {
//        val declaredField = org.libpag.PAGView::class.java.getDeclaredField("j")
//        declaredField.isAccessible = true
        return  true;
    }

    override fun onResume() {
        super.onResume()

        Log
            .d(
                TAG,
                "MyTestPag invoke onResume   isShow ${isShown()} getJ ${getjFileInfo()}"
            )
    }
}