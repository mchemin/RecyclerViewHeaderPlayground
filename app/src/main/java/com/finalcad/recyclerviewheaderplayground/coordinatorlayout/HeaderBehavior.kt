package com.finalcad.recyclerviewheaderplayground.coordinatorlayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

class HeaderBehavior @JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null
) : CoordinatorLayout.Behavior<TextView>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: TextView,
        dependency: View
    ): Boolean = dependency is RecyclerView

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: TextView,
        dependency: View
    ): Boolean = when (dependency) {
        is RecyclerView -> true.also {
            child.text = "${dependency.verticalScrollbarPosition} / ${dependency.childCount}"
        }

        else -> false
    }
}