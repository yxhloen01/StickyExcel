package com.example.kenny.stickyexcel.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import com.example.kenny.stickyexcel.Utils;

import java.util.ArrayList;
import java.util.List;

public class MyHScrollView extends HorizontalScrollView {
    private int mBaseScrollX;
    private int mScreenWidth;
    private int mScrollX;
    ScrollViewObserver mScrollViewObserver = new ScrollViewObserver();

    public MyHScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        mScreenWidth = Utils.getDisplay(context)[0] * 2 / 3;
        mScrollX = mScreenWidth / 4;
    }

    public MyHScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public MyHScrollView(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    /**
     * 获取相对滑动位置。由右向左滑动，返回正值；由左向右滑动，返回负值。
     *
     * @return
     */
    private int getBaseScrollX() {
        return getScrollX() - mBaseScrollX;
    }

    /**
     * 使相对于基线移动x距离。
     *
     * @param x x为正值时右移；为负值时左移。
     */
    private void baseSmoothScrollTo(int x) {
        smoothScrollTo(x + mBaseScrollX, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getBaseScrollX();
                //左滑，大于一半，移到下一页
                if (scrollX > mScrollX) {
                    baseSmoothScrollTo(mScreenWidth);
                    mBaseScrollX += mScreenWidth;
                }
                //左滑，不到一半，返回原位
                else if (scrollX > 0) {
                    baseSmoothScrollTo(0);
                }
                //右滑，不到一半，返回原位
                else if (scrollX > -mScrollX) {
                    baseSmoothScrollTo(0);
                }
                //右滑，大于一半，移到下一页
                else {
                    baseSmoothScrollTo(-mScreenWidth);
                    mBaseScrollX -= mScreenWidth;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        if (mScrollViewObserver != null /*&& (l != oldl || t != oldt)*/) {
            mScrollViewObserver.NotifyOnScrollChanged(l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void AddOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.AddOnScrollChangedListener(listener);
    }

    public void RemoveOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.RemoveOnScrollChangedListener(listener);
    }

    public static interface OnScrollChangedListener {
        public void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    public static class ScrollViewObserver {
        List<OnScrollChangedListener> mList;

        public ScrollViewObserver() {
            super();
            mList = new ArrayList<OnScrollChangedListener>();
        }

        public void AddOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.add(listener);
        }

        public void RemoveOnScrollChangedListener(
                OnScrollChangedListener listener) {
            mList.remove(listener);
        }

        public void NotifyOnScrollChanged(int l, int t, int oldl, int oldt) {
            if (mList == null || mList.size() == 0) {
                return;
            }
            for (int i = 0; i < mList.size(); i++) {
                if (mList.get(i) != null) {
                    mList.get(i).onScrollChanged(l, t, oldl, oldt);
                }
            }
        }
    }
}
