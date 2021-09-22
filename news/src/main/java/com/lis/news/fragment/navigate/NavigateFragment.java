package com.lis.news.fragment.navigate;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.lis.news.R;
import com.lis.news.api.NewsApi;
import com.lis.news.api.NewsChannelsBean;
import com.lis.news.databinding.FragmentNavigateBinding;
import com.xiangxue.network.TecentNetworkApi;
import com.xiangxue.network.observer.BaseObserver;

/**
 * 顶部导航
 * Created by lis on 2021/9/22.
 */
public class NavigateFragment extends Fragment {
    FragmentNavigateBinding mNavigateBinding;
    NavigateFragmentAdapter mNavigateFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mNavigateBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigate, container, false);
        mNavigateFragmentAdapter = new NavigateFragmentAdapter(getChildFragmentManager(), 0);
        mNavigateBinding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mNavigateBinding.viewpager.setAdapter(mNavigateFragmentAdapter);
        mNavigateBinding.tablayout.setupWithViewPager(mNavigateBinding.viewpager);
        mNavigateBinding.viewpager.setOffscreenPageLimit(1);
        load();
        return mNavigateBinding.getRoot();
    }

    private void load() {
        TecentNetworkApi.getService(NewsApi.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        Log.e("MainActivity", new Gson().toJson(newsChannelsBean));
                        // ArrayList<HeadlineNewsFragmentAdapter.Channel> channels = new ArrayList<>();
                        // for (NewsChannelsBean.ChannelList source : newsChannelsBean.showapiResBody.channelList) {
                        //     HeadlineNewsFragmentAdapter.Channel channel = new HeadlineNewsFragmentAdapter.Channel();
                        //     channel.channelId = source.channelId;
                        //     channel.channelName = source.name;
                        //     channels.add(channel);
                        // }
                        // adapter.setChannels(channels);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }
}