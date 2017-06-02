package com.example.pcdalao.mytest.annotations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

/**
 * Created by pan jh on 2017/6/1.
 */

public class MyAnnotationTestActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        TextView textView=(TextView) findViewById(R.id.textView);
    }

    @MyAnnotation(date = "123456")
    private void useMyAnnotation(){

    }
}
