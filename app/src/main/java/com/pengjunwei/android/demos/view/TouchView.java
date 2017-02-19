package com.pengjunwei.android.demos.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.pengjunwei.android.demos.util.PLog;

/**
 * Created by WikiPeng on 2017/2/19 09:04.
 */
public class TouchView extends View {


    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TouchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return PLog.motionEventToString(event, super.onTouchEvent(event));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return PLog.motionEventToString(event, super.dispatchTouchEvent(event));
    }
}
