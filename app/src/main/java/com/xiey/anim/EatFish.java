package com.xiey.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class EatFish extends View {

    private Paint mPaint;
    private RectF mRectF;
    private float mMaxAngle = 90f;
    private float mHalfMaxAngle = mMaxAngle / 2;

    private Paint mPaintFood;
    private float mMaxY = 200f;
    private float mFootX1 = mMaxY;
    private float mFootX2 = mMaxY;
    private float mFootX3 = mMaxY;
    private float mFootX4 = mMaxY;
    private float mWidth = 50f;
    private float mPadding = 50f;
    private long mEatTime = 400;


    public EatFish(Context context) {
        this(context, null);
    }

    public EatFish(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public EatFish(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {

        //
        mPaint = new Paint();
        mPaint.setStrokeWidth(15);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        //
        mPaintFood = new Paint();
        mPaintFood.setStrokeWidth(7);
        mPaintFood.setColor(Color.WHITE);
        mPaintFood.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintFood.setStrokeCap(Paint.Cap.ROUND);

        //
        mRectF = new RectF(mPadding, mPadding, mPadding + mWidth, mPadding + mWidth);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(mFootX1, mPadding + mWidth / 2, mPaintFood);
        canvas.drawPoint(mFootX2, mPadding + mWidth / 2, mPaintFood);
        canvas.drawPoint(mFootX3, mPadding + mWidth / 2, mPaintFood);
        canvas.drawPoint(mFootX4, mPadding + mWidth / 2, mPaintFood);
        canvas.drawArc(mRectF, 0f + mHalfMaxAngle, 360f - mHalfMaxAngle * 2, true, mPaint);

    }

    private ValueAnimator anim;
    private ValueAnimator animFood1;
    private ValueAnimator animFood2;
    private ValueAnimator animFood3;
    private ValueAnimator animFood4;


    public void startAnimation() {

        //
        anim = ValueAnimator.ofFloat(45, 12, 45);
        anim.setRepeatCount(ValueAnimator.INFINITE);//设置无限重复
        anim.setRepeatMode(ValueAnimator.RESTART);//设置重复模式
        anim.setDuration(mEatTime);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mHalfMaxAngle = (Float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        anim.start();

        //
        animFood1 = ValueAnimator.ofFloat(mMaxY, 75);
        animFood1.setRepeatCount(ValueAnimator.INFINITE);//设置无限重复
        animFood1.setRepeatMode(ValueAnimator.RESTART);//设置重复模式
        animFood1.setDuration(mEatTime * 4);
        animFood1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mFootX1 = (Float) animation.getAnimatedValue();
            }
        });
        animFood1.start();

        //
        animFood2 = ValueAnimator.ofFloat(mMaxY, 75);
        animFood2.setRepeatCount(ValueAnimator.INFINITE);//设置无限重复
        animFood2.setRepeatMode(ValueAnimator.RESTART);//设置重复模式
        animFood2.setDuration(mEatTime * 4);
        animFood2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mFootX2 = (Float) animation.getAnimatedValue();
            }
        });
        animFood2.setStartDelay(mEatTime);
        animFood2.start();

        //
        animFood3 = ValueAnimator.ofFloat(mMaxY, 75);
        animFood3.setRepeatCount(ValueAnimator.INFINITE);//设置无限重复
        animFood3.setRepeatMode(ValueAnimator.RESTART);//设置重复模式
        animFood3.setDuration(mEatTime * 4);
        animFood3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mFootX3 = (Float) animation.getAnimatedValue();
            }
        });
        animFood3.setStartDelay(mEatTime * 2);
        animFood3.start();

        //
        animFood4 = ValueAnimator.ofFloat(mMaxY, 75);
        animFood4.setRepeatCount(ValueAnimator.INFINITE);//设置无限重复
        animFood4.setRepeatMode(ValueAnimator.RESTART);//设置重复模式
        animFood4.setDuration(mEatTime * 4);
        animFood4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mFootX4 = (Float) animation.getAnimatedValue();
            }
        });
        animFood4.setStartDelay(mEatTime * 3);
        animFood4.start();


    }

    public void stopAnimation() {
        if (anim != null) {
            anim.cancel();
            anim = null;
        }
        if (animFood1 != null) {
            animFood1.cancel();
            animFood1 = null;
        }
        if (animFood2 != null) {
            animFood2.cancel();
            animFood2 = null;
        }
        if (animFood3 != null) {
            animFood3.cancel();
            animFood3 = null;
        }
        if (animFood4 != null) {
            animFood4.cancel();
            animFood4 = null;
        }
    }

}
