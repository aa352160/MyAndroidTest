package com.example.pcdalao.mytest.ninegridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

import java.util.List;

/**
 * Created by pan jh on 2017/5/17.
 */

public class ImagePreviewActivity extends AppCompatActivity {
    private List<String> images;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_preview);

        Bundle extras = getIntent().getExtras();
        images = (List<String>) extras.getSerializable("images");
        index = extras.getInt("index");

        final TextView tvProgress=(TextView)findViewById(R.id.tv_progress);
        tvProgress.setText((index+1)+"/"+images.size());

        ViewPager viewPager=(ViewPager)findViewById(R.id.view_pager);
        ImagePreviewPagerAdapter adapter=new ImagePreviewPagerAdapter(this,images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(index);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                index=position;
                tvProgress.setText((position+1)+"/"+images.size());
            }
        });

        ImageView mIvDelete=(ImageView)findViewById(R.id.iv_delete);
        mIvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("index",index);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
