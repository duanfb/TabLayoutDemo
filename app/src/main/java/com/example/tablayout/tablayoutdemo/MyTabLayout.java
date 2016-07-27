package com.example.tablayout.tablayoutdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * @author : neo.duan
 * @date : 	 2016/7/27
 * @desc : 请描述这个文件
 */
public class MyTabLayout extends FrameLayout implements ViewPager.OnPageChangeListener{

    private TabLayout mTabLayout;
    private View mIndicator;

    public MyTabLayout(Context context) {
        this(context, null);
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.tablayout, this);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mIndicator = findViewById(R.id.indicator);



//        mTabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);

        mTabLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (mTabLayout.getScrollX() != getScrollX())
                    mIndicator.scrollTo(mTabLayout.getScrollX(), mTabLayout.getScrollY());
            }
        });

        ViewCompat.setElevation(this, ViewCompat.getElevation(mTabLayout));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);
        mTabLayout.setupWithViewPager(viewPager);
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
