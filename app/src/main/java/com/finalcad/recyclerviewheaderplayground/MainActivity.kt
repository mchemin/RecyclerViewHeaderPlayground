package com.finalcad.recyclerviewheaderplayground

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.finalcad.recyclerviewheaderplayground.mergeadapter.MergeAdapterActivity
import com.finalcad.recyclerviewheaderplayground.motionlayout.MotionLayoutActivity
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.motion_layout).setOnClickListener { start(MotionLayoutActivity::class) }
        findViewById<View>(R.id.merge_adapter).setOnClickListener { start(MergeAdapterActivity::class) }
    }

    private fun start(kClass: KClass<out Activity>) {
        val intent = Intent(this, kClass.java)
        startActivity(intent)
    }
}
