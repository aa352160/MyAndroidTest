package com.example.pcdalao.mytest.kotlin

import android.content.Context
import android.widget.Toast

/**
 * Created by pan jh on 2016/12/20.
 */

class KotlinToJava(val context: Context, val text:String){
    fun showToast(){
        Toast.makeText(context,text, Toast.LENGTH_LONG).show()
    }
}