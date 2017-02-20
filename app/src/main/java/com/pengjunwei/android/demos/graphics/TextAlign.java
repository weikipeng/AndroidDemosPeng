package com.pengjunwei.android.demos.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by WikiPeng on 2017/2/20 10:34.
 */
public class TextAlign extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextPaintView(this));
    }

    class TextPaintView extends View {

        public TextPaintView(Context context) {
            super(context);
        }

        public TextPaintView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public TextPaintView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public TextPaintView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Rect  targetRect = new Rect(50, 50, 1000, 200);
            Paint paint      = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(3);
            paint.setTextSize(80);
            String testString = "测试：ijkJQKA:1234";
            paint.setColor(Color.CYAN);
            canvas.drawRect(targetRect, paint);
            paint.setColor(Color.RED);
            canvas.drawText(testString, targetRect.left, targetRect.bottom, paint);
        }
    }
}
