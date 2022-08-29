package com.haram.edcan_vacation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        fun setResponseText(resCode:Int, body:MessageInfo?){
//            body.toString()
//        }

        fun getMessageData() {
            RetrofitObject.getApiService().info().enqueue(
                object: Callback<MessageInfo> {
                    override fun onResponse(
                        call: Call<MessageInfo>,
                        response: Response<MessageInfo>
                    ) {
                        response.body()?.let {
                            val num = it.num
                            val userId = it.userId
                            val message = it.message
                            val isHeart = it.isHeart
                            val date = it.date
                            Log.d("oy", "userId: ${userId}")
                            //Toast.makeText(context, "${userId}", 3000).show()
                        }
                    }

                    override fun onFailure(
                        call: Call<MessageInfo>,
                        t: Throwable
                    ) {
                        Log.d("error","${t.printStackTrace()}")
                    }
                }
            )
        }

        val txt = getMessageData()
        Log.d("ㄷㅈㄷ", txt.toString())

        fun Parsing(a: Int) {

        }

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