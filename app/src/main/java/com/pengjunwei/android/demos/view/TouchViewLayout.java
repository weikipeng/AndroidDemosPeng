package com.pengjunwei.android.demos.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.pengjunwei.android.demos.util.PLog;

/**
 * Created by WikiPeng on 2017/2/19 08:59.
 */
public class TouchViewLayout extends FrameLayout {
    public TouchViewLayout(Context context) {
        super(context);
    }

    public TouchViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TouchViewLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        PLog.e(PLog.motionEventToString(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PLog.e(PLog.motionEventToString(event));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        PLog.e(PLog.motionEventToString(ev));
        return super.onInterceptTouchEvent(ev);
    }

}
