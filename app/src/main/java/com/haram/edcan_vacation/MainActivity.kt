package com.haram.edcan_vacation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnvMain = findViewById<BottomNavigationView>(R.id.bn_main)
        bnvMain.run {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.tab1 -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.view, FirstFragment())
                        .commitAllowingStateLoss()
                    R.id.tab2 -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.view, SecondFragment())
                        .commitAllowingStateLoss()
                    R.id.tab3 -> supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.view, ThirdFragment())
                        .commitAllowingStateLoss()
                }
                true
            }
            selectedItemId = R.id.bn_main
        }
    }
}