package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pan jh on 2016/11/17.
 */

public class PhotoView extends LinearLayout implements View.OnClickListener{

    Context context;
    RelativeLayout mRlPhotoOne;
    RelativeLayout mRlPhotoTwo;
    RelativeLayout mRlPhotoThree;
    ImageView mIvPhotoOne;
    ImageView mIvPhototwo;
    ImageView mIvPhotothree;
    ImageView mIvCloseone;
    ImageView mIvClosetwo;
    ImageView mIvClosethree;
    List<Bitmap> photoList;

    public PhotoView(Context context) {
        super(context);
        this.context=context;
        bindView();
        init();
    }

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        bindView();
        initValue();
        init();
    }

    private void bindView(){
        View view=LayoutInflater.from(context).inflate(R.layout.view_photo,this);
        mRlPhotoOne=(RelativeLayout) view.findViewById(R.id.rl_photo_one);
        mRlPhotoTwo=(RelativeLayout) view.findViewById(R.id.rl_photo_two);
        mRlPhotoThree=(RelativeLayout) view.findViewById(R.id.rl_photo_three);
        mIvPhotoOne = (ImageView) view.findViewById(R.id.iv_photo_one);
        mIvPhototwo = (ImageView) view.findViewById(R.id.iv_photo_two);
        mIvPhotothree = (ImageView) view.findViewById(R.id.iv_photo_three);
        mIvCloseone = (ImageView) view.findViewById(R.id.iv_close_one);
        mIvClosetwo = (ImageView) view.findViewById(R.id.iv_close_two);
        mIvClosethree = (ImageView) view.findViewById(R.id.iv_close_three);

        mIvPhotoOne.setOnClickListener(this);
        mIvPhototwo.setOnClickListener(this);
        mIvPhotothree.setOnClickListener(this);
        mIvCloseone.setOnClickListener(this);
        mIvClosetwo.setOnClickListener(this);
        mIvClosethree.setOnClickListener(this);
    }

    private void initValue(){
        photoList=new ArrayList<>();
        Drawable drawable=getResources().getDrawable(R.drawable.ic_photo_delete);
        BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
        Bitmap bitmap=bitmapDrawable.getBitmap();
        photoList.add(bitmap);
        photoList.add(bitmap);
        photoList.add(bitmap);
    }

    private void init(){
        mRlPhotoTwo.setVisibility(INVISIBLE);
        mRlPhotoThree.setVisibility(INVISIBLE);
        Iterator<Bitmap> iterator = photoList.iterator();
        if (iterator.hasNext()){
            mIvPhotoOne.setImageBitmap(iterator.next());
            mRlPhotoTwo.setVisibility(VISIBLE);
            mIvCloseone.setVisibility(VISIBLE);
            if (iterator.hasNext()){
                mIvPhototwo.setImageBitmap(iterator.next());
                mRlPhotoThree.setVisibility(VISIBLE);
                mIvClosetwo.setVisibility(VISIBLE);
                if (iterator.hasNext()){
                    mIvPhotothree.setImageBitmap(iterator.next());
                    mIvClosethree.setVisibility(VISIBLE);
                }else{
                    mIvPhotothree.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_image1));
                    mIvClosethree.setVisibility(INVISIBLE);
                }
            }else{
                mIvPhototwo.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_image1));
                mIvClosetwo.setVisibility(INVISIBLE);
            }
        }else{
            mIvPhotoOne.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_image1));
            mIvCloseone.setVisibility(INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        Drawable drawable=getResources().getDrawable(R.drawable.ic_photo_delete);
        BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
        Bitmap bitmap=bitmapDrawable.getBitmap();
        switch (v.getId()){
            case R.id.iv_photo_one:
                photoList.add(bitmap);
                init();
                break;
            case R.id.iv_photo_two:
                photoList.add(bitmap);
                init();
                break;
            case R.id.iv_photo_three:
                photoList.add(bitmap);
                init();
                break;
            case R.id.iv_close_one:
                photoList.remove(0);
                init();
                break;
            case R.id.iv_close_two:
                photoList.remove(1);
                init();
                break;
            case R.id.iv_close_three:
                photoList.remove(2);
                init();
                break;
        }
    }
}
