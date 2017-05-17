package com.example.pcdalao.mytest.ninegridview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.pcdalao.mytest.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pan jh on 2017/5/17.
 */

public class NineGridViewListAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> datas;

    public NineGridViewListAdapter(Context context, List<String> datas){
        this.mContext=context;
        this.datas=datas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(dp2px(mContext,75),dp2px(mContext,75));
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(mContext.getResources().getColor(R.color.colorE6593F));

        if (position>datas.size()-1){
            imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_add_image));
        }else{
            imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_photo_delete));
        }

        setListener(position,imageView);
        return imageView;
    }

    private void setListener(final int position, final ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>datas.size()-1){
                    //添加新照片
                    datas.add("");
                    notifyDataSetChanged();
                }else{
                    showBigPhoto(position);
                }
            }
        });
    }

    private void showBigPhoto(int position) {
        Intent intent = new Intent(mContext,ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("images", (Serializable) datas);
        bundle.putInt("index",position);
        intent.putExtras(bundle);
        ((AppCompatActivity)mContext).startActivityForResult(intent,1);
    }

    @Override
    public int getCount() {
        return datas.size()<9?datas.size()+1:datas.size();
    }

    @Override
    public Object getItem(int position) {
        if (position>datas.size()){
            return null;
        }
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
