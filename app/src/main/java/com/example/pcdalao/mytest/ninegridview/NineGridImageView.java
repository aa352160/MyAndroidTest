package com.example.pcdalao.mytest.ninegridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import java.util.List;

/**
 * Created by pan jh on 2017/5/18.
 */

/**
 * 使用该空间，需要在activity的onActivityResult方法中对resultCode为
 */
public class NineGridImageView extends GridView {
    private Context mContext;
    private List<String> imagePaths;

    public NineGridImageView(Context context) {
        this(context,null);
    }

    public NineGridImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
    }

    public void setData(List<String> imagePaths){
        this.imagePaths=imagePaths;
        NineGridViewListAdapter adapter=new NineGridViewListAdapter(mContext,this.imagePaths);
        this.setAdapter(adapter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        measure(w, h);
        int height=getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
