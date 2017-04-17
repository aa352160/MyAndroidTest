package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan jh on 2016/11/18.
 */

public class TypeChooseView extends LinearLayout {

    private Context context;
    private List packUpList,expandList;

    public TypeChooseView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public TypeChooseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init(){
        View view= LayoutInflater.from(getContext()).inflate(R.layout.view_type_choose,this);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.rv_type_list);
        ImageView imageView=(ImageView)findViewById(R.id.iv_expand);

        packUpList=new ArrayList();
        expandList=new ArrayList();
        for (int i = 0; i < 3; i++) {
            packUpList.add(new Object());
        }
        for (int i = 0; i < 10; i++) {
            expandList.add(new Object());
        }


    }
}
