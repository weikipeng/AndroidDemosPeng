package com.pengjunwei.android.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pengjunwei.android.demos.graphics.TextAlign;
import com.pengjunwei.android.demos.touch.TouchEventActivity;
import com.pengjunwei.android.demos.ui.WebViewRecyclerActivity;

/**
 * Created by WikiPeng on 2017/2/19 07:51.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        findViewById(R.id.buttonTouchEvent).setOnClickListener(this);
        findViewById(R.id.buttonTextAlign).setOnClickListener(this);
        startActivity(new Intent(this, WebViewRecyclerActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTouchEvent:
                startActivity(new Intent(this, TouchEventActivity.class));
                break;
            case R.id.buttonTextAlign:
                startActivity(new Intent(this, TextAlign.class));
                break;
        }
    }

}
