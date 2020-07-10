package com.example.zeesh.virtualmallprototype

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View

/**
 * Created by zeesh on 5/14/2018.
 */
class MySystem {
    companion object {
         fun dpToPx(dp: Int, r: Resources): Int {

            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
        }



    }
}