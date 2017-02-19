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
        String message = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                message = "View ===> onTouchEvent ===> MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                message = "View ===> onTouchEvent ===> MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                message = "View ===> onTouchEvent ===> MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                message = "View ===> onTouchEvent ===> MotionEvent.ACTION_CANCEL";
                break;
        }
        PLog.d(message);
        PLog.e(PLog.motionEventToString(event));

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String message = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                message = "View ===> dispatchTouchEvent ===> MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                message = "View ===> dispatchTouchEvent ===> MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                message = "View ===> dispatchTouchEvent ===> MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                message = "View ===> dispatchTouchEvent ===> MotionEvent.ACTION_CANCEL";
                break;
        }
        PLog.d(message);
        PLog.e(PLog.motionEventToString(event));

        return super.dispatchTouchEvent(event);
    }
}
