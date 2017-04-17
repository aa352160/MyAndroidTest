package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;

import com.example.pcdalao.mytest.R;

/**
 * Created by pan jh on 2017/2/27.
 */

public class RelativeLayoutWithDottedLine extends RelativeLayout {
    private Context mContext;
    private int mWidth;
    private int mHeight;

    public RelativeLayoutWithDottedLine(Context context) {
        this(context,null);
    }

    public RelativeLayoutWithDottedLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        setWillNotDraw(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制虚线
        Paint mPaint=new Paint();
        mPaint.setColor(getResources().getColor(R.color.color9867FF));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(2));
        mPaint.setPathEffect(new DashPathEffect(new float[]{dp2px(5),dp2px(3)},1));
        Path path = new Path();
        path.moveTo(mWidth/2, 0);
        path.lineTo(mWidth/2,mHeight);
        canvas.drawPath(path,mPaint);
    }

    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
