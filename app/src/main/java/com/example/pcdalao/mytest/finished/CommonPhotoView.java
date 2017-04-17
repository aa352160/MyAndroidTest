package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan jh on 2016/12/27.
 */

public class CommonPhotoView extends GridView{
    private Context mContext;
    private int photoCount=9;
    private List<String> imageList;

    public CommonPhotoView(Context context) {
        super(context);
        mContext=context;
        initValue();
        init();
    }

    public CommonPhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initValue();
        init();
    }

    private void initValue() {
        imageList=new ArrayList<>();
    }

    private void init() {
        this.setAdapter(new CommonPhotoViewAdapter(imageList));
    }

    class CommonPhotoViewAdapter extends BaseAdapter {
        private List<String> imageDatas;

        public CommonPhotoViewAdapter(List<String> imageDatas) {
            this.imageDatas=imageDatas;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RelativeLayout relativeLayout=new RelativeLayout(mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public String getItem(int position) {
            return imageDatas.get(position);
        }

        @Override
        public int getCount() {
            return imageList.size();
        }
    }
}
