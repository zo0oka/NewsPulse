package com.zo0okadev.newspulse.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.ui.viewHolders.LargeBannerViewHolder;
import com.zo0okadev.newspulse.ui.viewHolders.NewsViewHolder;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import static com.zo0okadev.newspulse.utils.Constants.ADMOB_APP_ID;

public class NewsPagedListAdapter extends PagedListAdapter<Article, RecyclerView.ViewHolder> {

    private static final int BANNER = 0;
    private static final int ARTICLE = 1;
    private FragmentActivity activity;

    public NewsPagedListAdapter(FragmentActivity activity) {
        super(Article.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ARTICLE:
                return new NewsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.news_list_item, parent, false));
            case BANNER:
            default:
                return new LargeBannerViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.large_banner_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case ARTICLE:
                ((NewsViewHolder) holder).bindTo(activity, getItem(position));
                break;
            case BANNER:
                LargeBannerViewHolder bannerViewHolder = (LargeBannerViewHolder) holder;
                AdView adView = (AdView) bannerViewHolder.itemView;
                MobileAds.initialize(activity, ADMOB_APP_ID);
                AdRequest adRequest = new AdRequest.Builder()
                        .build();
                adView.loadAd(adRequest);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 5 == 0) ? BANNER : ARTICLE;
    }
}

