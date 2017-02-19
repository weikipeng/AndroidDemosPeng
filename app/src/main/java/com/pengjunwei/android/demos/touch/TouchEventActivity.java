package com.pengjunwei.android.demos.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.pengjunwei.android.demos.R;
import com.pengjunwei.android.demos.util.PLog;

/**
 * Created by WikiPeng on 2017/2/19 08:03.
 */
public class TouchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String message = "";

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                message = "Activity ===> dispatchTouchEvent ===> MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                message = "Activity ===> dispatchTouchEvent ===> MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                message = "Activity ===> dispatchTouchEvent ===> MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                message = "Activity ===> dispatchTouchEvent ===> MotionEvent.ACTION_CANCEL";
                break;
        }
        PLog.d(message);
        PLog.e(PLog.motionEventToString(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String message = "";

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                message = "Activity ===> onTouchEvent ===> MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                message = "Activity ===> onTouchEvent ===> MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                message = "Activity ===> onTouchEvent ===> MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                message = "Activity ===> onTouchEvent ===> MotionEvent.ACTION_CANCEL";
                break;
        }
        PLog.d(message);
        PLog.e(PLog.motionEventToString(event));

        return super.onTouchEvent(event);
    }


}
