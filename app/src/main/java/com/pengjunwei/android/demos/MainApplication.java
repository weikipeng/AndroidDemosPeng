package com.pengjunwei.android.demos;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by WikiPeng on 2017/3/5 08:28.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
