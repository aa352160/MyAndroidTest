package com.example.pcdalao.mytest.finished;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.pcdalao.mytest.R;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        LinearLayout toolbar=(LinearLayout)findViewById(R.id.toolbar);

//        setScrollListener();
    }

//    private void setScrollListener() {
//        appBar=(AppBarLayout)findViewById(R.id.app_bar);
//        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset==0){
//                    mTvText.setVisibility(View.GONE);
//                    mRpProgress.setVisibility(View.VISIBLE);
//                }else if(Math.abs(verticalOffset)>=appBarLayout.getTotalScrollRange()){
//                    mTvText.setVisibility(View.VISIBLE);
//                    mRpProgress.setVisibility(View.GONE);
//                }
//            }
//        });
//    }
}
