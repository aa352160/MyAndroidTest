package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan jh on 2017/2/23.
 */

public class TaskFeedbackMultipleView extends LinearLayout {
    private Context mContext;
    private List datas;
    private String selectData="";
    private List<View> viewList;

    public TaskFeedbackMultipleView(Context context) {
        this(context,null);
    }

    public TaskFeedbackMultipleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        viewList=new ArrayList<>();
    }

    private void initView() {
        this.setOrientation(VERTICAL);
        for (int i = 0; i < datas.size(); i++) {
            final LinearLayout linearLayout=new LinearLayout(mContext);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0,dp2px(15),0,0);
            layoutParams.gravity= Gravity.CENTER_VERTICAL;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(HORIZONTAL);

            ImageView imageView=new ImageView(mContext);
            LayoutParams imageLp = new LayoutParams(dp2px(22),dp2px(22));
            imageLp.setMargins(0,0,dp2px(10),0);
            imageView.setLayoutParams(imageLp);
            imageView.setImageResource(R.drawable.selector_item_select);
            imageView.setDuplicateParentStateEnabled(true);
            linearLayout.addView(imageView);

            TextView textView=new TextView(mContext);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setText("Good");
            textView.setTextColor(getResources().getColor(R.color.color1E1E1E));
            textView.setTextSize(dp2px(5));
            linearLayout.addView(textView);

            this.addView(linearLayout);
            viewList.add(linearLayout);
        }
    }

    public void setDatas(List datas) {
        this.datas = datas;
        initView();
    }

    public String getSelect(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < viewList.size(); i++) {
            if (viewList.get(i).isSelected()){
                list.add(i+"");
            }
        }
        return "no select";
    }

    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
