package com.wwsl.game.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wwsl.game.R;

/**
 * Created by cxf on 2017/8/15.
 * 可以调节drawable大小的TextView
 */

public class DrawableTextView2 extends TextView {

    private int mTopWidth;
    private int mTopHeight;
    private int mLeftWidth;
    private int mLeftHeight;
    private int mRightWidth;
    private int mRightHeight;
    private int mBottomWidth;
    private int mBottomHeight;
    private Drawable mTopDrawable;
    private Drawable mLeftDrawable;
    private Drawable mRightDrawable;
    private Drawable mBottomDrawable;

    public DrawableTextView2(Context context) {
        this(context, null);
    }

    public DrawableTextView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public DrawableTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView2);
        mTopWidth = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_top_width, 0);
        mTopHeight = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_top_height, 0);
        mLeftWidth = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_left_width, 0);
        mLeftHeight = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_left_height, 0);
        mRightWidth = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_right_width, 0);
        mRightHeight = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_right_height, 0);
        mBottomWidth = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_bottom_width, 0);
        mBottomHeight = (int) ta.getDimension(R.styleable.DrawableTextView2_dt2_bottom_height, 0);
        mTopDrawable = ta.getDrawable(R.styleable.DrawableTextView2_dt2_top_drawable);
        mLeftDrawable = ta.getDrawable(R.styleable.DrawableTextView2_dt2_left_drawable);
        mRightDrawable = ta.getDrawable(R.styleable.DrawableTextView2_dt2_right_drawable);
        mBottomDrawable = ta.getDrawable(R.styleable.DrawableTextView2_dt2_bottom_drawable);
        ta.recycle();
    }

    public void setTopDrawable(Drawable topDrawable) {
        mTopDrawable = topDrawable;
        invalidate();
    }

    public void setBottomDrawable(Drawable bottomDrawable) {
        mBottomDrawable = bottomDrawable;
        invalidate();
    }

    public void setLeftDrawable(Drawable leftDrawable) {
        mLeftDrawable = leftDrawable;
        invalidate();
    }

    public void setRightDrawable(Drawable rightDrawable) {
        mRightDrawable = rightDrawable;
        invalidate();
    }

    public Drawable getTopDrawable() {
        return mTopDrawable;
    }

    public Drawable getLeftDrawable() {
        return mLeftDrawable;
    }

    public Drawable getRightDrawable() {
        return mRightDrawable;
    }

    public Drawable getBottomDrawable() {
        return mBottomDrawable;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setCompoundDrawablesWithIntrinsicBounds(mLeftDrawable, mTopDrawable, mRightDrawable, mBottomDrawable);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            left.setBounds(0, 0, mLeftWidth, mLeftHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mTopWidth, mTopHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mRightWidth, mRightHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mBottomWidth, mBottomHeight);
        }
        setCompoundDrawables(left, top, right, bottom);
    }

}
