package com.ryanbrooks.expandablerecyclerviewsample;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by ${GB} on 12/31/15.
 */
public class ClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}