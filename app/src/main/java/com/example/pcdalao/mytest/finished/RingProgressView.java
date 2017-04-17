package com.example.pcdalao.mytest.finished;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.pcdalao.mytest.R;

/**
 * Created by pan jh on 2017/2/21.
 */

public class RingProgressView extends View {
    final String TYPE_DAILY="Daily result";
    final String TYPE_MONTH="Month result";

    float r=400;
    float strokeWidth=120;
    float padding=75;

    private Context mContext;

    private float mWidth;
    private float mHeight;

    private float maxNumber=100;
    private float currentNumber=0;

    public RingProgressView(Context context) {
        this(context,null);
    }

    public RingProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
        strokeWidth=mHeight/3.5f;
        padding=mHeight/6f;
        r=(mWidth-(padding*2)-strokeWidth)/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2-r, mHeight-(0.7f*r));

        drawStroke(canvas);

        RectF rectF;
        rectF=new RectF(0,0,2*r,2*r);
        Paint paint=new Paint();
        paint.setColor(getResources().getColor(R.color.color9867FF));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        canvas.drawArc(rectF,210,120*(currentNumber/maxNumber),false,paint);
    }

    private void drawStroke(Canvas canvas) {
        //Paint初始化
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.color9867FF));
        paint.setStyle(Paint.Style.STROKE);

        RectF rectF;
        float temp=strokeWidth/2;
        //绘制外边框
        rectF=new RectF(-temp,-temp,2*r+temp,2*r+temp);
        paint.setStrokeWidth(5);
        canvas.drawArc(rectF,210,120,false,paint);
        //绘制内边框
        rectF=new RectF(temp,temp,2*r-temp,2*r-temp);
        paint.setStrokeWidth(5);
        canvas.drawArc(rectF,210,120,false,paint);
        //绘制左右封闭线条
        canvas.translate(r,r);
        float startX,startY,stopX,stopY;
        startY=(r+temp)/2;
        stopY=(r-temp)/2;
        startX=(float) (Math.sqrt(3)/2)*(r+temp);
        stopX=(float) (Math.sqrt(3)/2)*(r-temp);
        canvas.drawLine(-startX,-startY,-stopX,-stopY,paint);
        canvas.drawLine(startX,-startY,stopX,-stopY,paint);
        //将canvas位置重置
        canvas.translate(-r,-r);
    }

    public void setData(float maxNumber,float currentNumber){
        this.maxNumber=maxNumber;
        this.currentNumber=currentNumber;
        invalidate();
    }
}
