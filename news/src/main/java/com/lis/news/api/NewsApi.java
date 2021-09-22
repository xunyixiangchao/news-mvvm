package com.lis.news.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lis on 2021/8/24.
 */
public interface NewsApi {

    @GET("release/news")
    Observable<NewsListBean> getNewsList(@Query("channelId") String channelId,
                                         @Query("channelName") String channelName,
                                         @Query("page") String page);

    @GET("release/channel")
    Observable<NewsChannelsBean> getNewsChannels();
}