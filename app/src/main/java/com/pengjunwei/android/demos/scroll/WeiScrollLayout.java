package com.pengjunwei.android.demos.scroll;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by WikiPeng on 2017/3/4 10:42.
 */
public class WeiScrollLayout extends LinearLayout {
    public WeiScrollLayout(Context context) {
        super(context);
    }

    public WeiScrollLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeiScrollLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeiScrollLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
