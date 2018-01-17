package com.example.kenny.stickyexcel.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class InterceptScrollContainer extends LinearLayout {

    public InterceptScrollContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public InterceptScrollContainer(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        //return super.onInterceptTouchEvent(ev);
        Log.i("pdwy", "ScrollContainer onInterceptTouchEvent");
        return true;

//		return super.onInterceptTouchEvent(ev);
    }

//    private int lastXIntercept = 0;
//    private int lastYIntercept = 0;

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        // TODO Auto-generated method stub
//        //return super.onInterceptTouchEvent(ev);
//        boolean intercepted = false;
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastXIntercept = x;
//                lastYIntercept = y;
//                intercepted = false;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                final int deltaX = x - lastXIntercept;
//                final int deltaY = y - lastYIntercept;
//                /*根据条件判断是否拦截该事件*/
//                if (Math.abs(deltaX) > Math.abs(deltaY)) {
////                    try {
////                        getChildAt(0).dispatchTouchEvent(ev);
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
//                    intercepted = true;
//                } else {
//                    intercepted = false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                intercepted = false;
//                break;
//        }
//        lastXIntercept = x;
//        lastYIntercept = y;
//        return intercepted;
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // TODO Auto-generated method stub
//        return super.onTouchEvent(event);
//    }
}
