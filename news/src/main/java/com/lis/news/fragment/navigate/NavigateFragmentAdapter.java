package com.lis.news.fragment.navigate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lis.news.fragment.newslist.NewsListFragment;

import java.util.List;

/**
 * 适配器
 * Created by lis on 2021/9/22.
 */
public class NavigateFragmentAdapter extends FragmentPagerAdapter {
    public NavigateFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public static class Channel {
        public String channelId;
        public String channelName;
    }

    private List<Channel> mChannels;

    public void setChannels(List<Channel> channels) {
        mChannels = channels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return NewsListFragment.newInstance(mChannels.get(position).channelId,
                mChannels.get(position).channelName);
    }

    @Override
    public int getCount() {
        return (mChannels == null || mChannels.isEmpty()) ? 0 : mChannels.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).channelName;
    }
}