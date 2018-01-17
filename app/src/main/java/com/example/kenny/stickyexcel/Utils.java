package com.example.kenny.stickyexcel;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Kenny on 2018/1/17.
 */

public class Utils {
    /**
     * 获取屏幕分辨率
     *
     * @param c
     * @return
     */
    public static int[] getDisplay(Context c) {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();//屏幕分辨率容器
        ((Activity) c).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        return new int[]{mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels};
    }
}
