package com.cysion.targetfun

import android.support.v4.view.ViewPager

class OnPageChangeListenerObj : ViewPager.OnPageChangeListener {

    //---
    private var _A: ((position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit)? = null

    fun _onPageScrolled(a: ((position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit)) {
        _A = a
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        _A?.invoke(position, positionOffset, positionOffsetPixels)
    }


    //---
    private var _B: ((position: Int) -> Unit)? = null

    fun _onPageSelected(b: ((position: Int) -> Unit)) {
        _B = b
    }

    override fun onPageSelected(position: Int) {
        _B?.invoke(position)
    }

    //---
    private var _C: ((state: Int) -> Unit)? = null

    fun _onPageScrollStateChanged(c: ((state: Int) -> Unit)) {
        _C = c
    }

    override fun onPageScrollStateChanged(state: Int) {
        _C?.invoke(state)
    }
}


inline fun ViewPager._addOnPageChangeListener(func: (OnPageChangeListenerObj.() -> Unit)) =
    addOnPageChangeListener(OnPageChangeListenerObj().apply(func))
