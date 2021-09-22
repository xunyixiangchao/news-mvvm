package com.lis.news_mvvm.app;

import android.app.Application;

import com.lis.news_mvvm.BuildConfig;
import com.xiangxue.network.base.INetworkRequiredInfo;

/**
 * Created by lis on 2021/9/22.
 */
public class NetworkRequestInfo implements INetworkRequiredInfo {
    private Application mApplication;
    public NetworkRequestInfo(Application application){
        this.mApplication = application;
    }

    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Application getApplicationContext() {
        return mApplication;
    }
}