package com.lis.news_mvvm.app;

import android.app.Application;

import com.xiangxue.network.base.NetworkApi;

/**
 * Created by lis on 2021/9/22.
 */
public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkApi.init(new NetworkRequestInfo(this));
    }
}