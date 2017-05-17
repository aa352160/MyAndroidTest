package com.example.pcdalao.mytest.ninegridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pcdalao.mytest.R;

import java.util.List;

/**
 * Created by pan jh on 2017/5/17.
 */

public class ImagePreviewPagerAdapter extends PagerAdapter {
    private List<String> datas;
    private Context mContext;

    public ImagePreviewPagerAdapter(Context mContext, @NonNull List<String> datas) {
        super();
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(mContext);
        ViewGroup.LayoutParams layoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add_image));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
