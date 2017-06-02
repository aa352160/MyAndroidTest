package com.example.pcdalao.mytest.ninegridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan jh on 2017/5/17.
 */

public class NineGridViewActivity extends AppCompatActivity {
    private List<String> datas;
    private NineGridViewListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_grid_view);

        datas=new ArrayList<>();
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        adapter=new NineGridViewListAdapter(this,datas);

        NineGridImageView gridLayout=(NineGridImageView) findViewById(R.id.grid_view);
        gridLayout.setData(datas);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            int index = data.getIntExtra("index", -1);
            if (index!=-1){
                datas.remove(index);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
