package com.example.pcdalao.mytest.kotlin;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by pan jh on 2016/12/20.
 */

public class JavaToKotlin {

    Context context;
    String string;

    JavaToKotlin(Context context,String text){
        this.context=context;
        this.string=text;
    }

    public void showToast(){
        Toast.makeText(context,string,Toast.LENGTH_LONG).show();
    }

}
