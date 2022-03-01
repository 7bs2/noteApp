package com.example.notes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setContentView(R.layout.activity_main)
        Handler(Looper.myLooper()!!).postDelayed({replaceFragment(HomeFragment.newInstance(), true)}, 250)
        
    }

    private fun replaceFragment(fragment: Fragment, isTransition: Boolean) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (isTransition) {
            beginTransaction.setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
            )
        }
        beginTransaction.replace(R.id.frame_layout, fragment)
        beginTransaction.commit()
    }


}