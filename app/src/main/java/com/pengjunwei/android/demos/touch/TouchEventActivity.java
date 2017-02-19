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

        return PLog.motionEventToString(ev, super.dispatchTouchEvent(ev));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return PLog.motionEventToString(event, super.onTouchEvent(event));
    }
}
