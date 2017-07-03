package com.example.pcdalao.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pcdalao.mytest.realm.RealmActivity;
import com.google.gson.Gson;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RealmActivity.class);
                startActivity(intent);
            }
        });
        Map change = change();
    }

    private Map change(){
        Gson gson=new Gson();
        Bean bean=new Bean();
        String s = gson.toJson(bean);
        Map map = gson.fromJson(s, Map.class);
        return map;
    }

    class Bean{
        public String name="aaaaaa";
        public String sex="boy";
        public boolean isman=true;
        public int age=10;
    }
}
