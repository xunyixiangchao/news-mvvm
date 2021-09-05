package com.lis.news_mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lis.network.utils.RetrofitHelper;
import com.lis.news.NewsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.搭建网络模块
        NewsApi apiImpl = RetrofitHelper.getApiImpl("", NewsApi.class);
        Call newsChannels = apiImpl.getNewsChannels("");
        newsChannels.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}