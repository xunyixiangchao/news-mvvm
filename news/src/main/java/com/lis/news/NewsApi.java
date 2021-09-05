package com.lis.news;

import retrofit2.Call;

/**
 * Created by lis on 2021/8/24.
 */
public interface NewsApi {

    Call getNewsChannels(String source);
}