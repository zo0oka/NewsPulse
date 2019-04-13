package com.zo0okadev.newspulse.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.api.NewsApiClient;
import com.zo0okadev.newspulse.model.article.ArticleResponse;
import com.zo0okadev.newspulse.model.response.NewsArticleResponseWrapper;
import com.zo0okadev.newspulse.ui.adapters.RelatedContentAdapter;
import com.zo0okadev.newspulse.utils.Utils;
import com.zo0okadev.newspulse.utils.WebViewLoader;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.newspulse.utils.Constants.ADMOB_APP_ID;

public class NewsArticleDetails extends Fragment {

    private TextView newsArticleTitle, newsArticleSection, newsArticleDate, relatedArticlesText;
    private ImageView newsArticleImage;
    private WebView newsArticleContent;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AdView aboveArticleAd, belowArticleAd, aboveRelatedAd, belowRelatedAd;

    public NewsArticleDetails() {
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_news_article_details, container, false);

        initializeViews(rootView);

        progressBar.setVisibility(View.VISIBLE);

        NewsApiClient.getInstance().getNewsArticle(getArguments().getString("articleId"))
                .enqueue(new Callback<NewsArticleResponseWrapper>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsArticleResponseWrapper> call, @NonNull Response<NewsArticleResponseWrapper> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                assignValuesToViews(response.body().getArticleResponse(), rootView);
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsArticleResponseWrapper> call, @NonNull Throwable t) {

                    }
                });

        MobileAds.initialize(getContext(), ADMOB_APP_ID);
        AdRequest adRequest = new AdRequest.Builder().build();

        aboveArticleAd.loadAd(adRequest);
        belowArticleAd.loadAd(adRequest);
        aboveRelatedAd.loadAd(adRequest);
        belowRelatedAd.loadAd(adRequest);

        return rootView;
    }

    private void initializeViews(View v) {
        aboveArticleAd = v.findViewById(R.id.article_above_content_adView);
        belowArticleAd = v.findViewById(R.id.article_below_content_adView);
        aboveRelatedAd = v.findViewById(R.id.article_above_related_content_adView);
        belowRelatedAd = v.findViewById(R.id.article_below_related_content_adView);
        newsArticleTitle = v.findViewById(R.id.news_article_title);
        newsArticleImage = v.findViewById(R.id.news_article_image);
        newsArticleContent = v.findViewById(R.id.news_article_body_text);
        recyclerView = v.findViewById(R.id.news_article_related_recyclerView);
        progressBar = v.findViewById(R.id.news_article_progressBar);
        newsArticleSection = v.findViewById(R.id.news_article_section);
        newsArticleDate = v.findViewById(R.id.news_article_date);
        relatedArticlesText = v.findViewById(R.id.related_articles_text);
    }

    private void assignValuesToViews(ArticleResponse articleResponse, View v) {
        newsArticleTitle.setText(articleResponse.getContent().getWebTitle());
        newsArticleDate.setText(Utils.getFormattedDate(articleResponse.getContent().getWebPublicationDate()));
        newsArticleSection.setText(articleResponse.getContent().getSectionName());
        if (articleResponse.getContent().getFields().getThumbnail() != null) {
            Glide.with(v.getContext()).load(articleResponse.getContent().getFields().getThumbnail())
                    .into(newsArticleImage);
        } else {
            Glide.with(v.getContext()).load("https://via.placeholder.com/300x200.png?text=No+Image+Availabe")
                    .into(newsArticleImage);
        }
        WebViewLoader webViewLoader = new WebViewLoader(newsArticleContent);
        webViewLoader.setSettings();
        webViewLoader.loadHtmlData(articleResponse.getContent().getFields().getBody());
        relatedArticlesText.setText(getString(R.string.related_articles));
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        RelatedContentAdapter relatedContentAdapter = new RelatedContentAdapter(getActivity());
        recyclerView.setAdapter(relatedContentAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        relatedContentAdapter.setRelatedContents(articleResponse.getRelatedContent());
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        aboveArticleAd.destroy();
        belowArticleAd.destroy();
        aboveRelatedAd.destroy();
        belowRelatedAd.destroy();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        aboveArticleAd.pause();
        belowArticleAd.pause();
        aboveRelatedAd.pause();
        belowRelatedAd.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        aboveArticleAd.resume();
        belowArticleAd.resume();
        aboveRelatedAd.resume();
        belowRelatedAd.resume();
        super.onResume();
    }

    @Override
    public void onStop() {
        aboveArticleAd.pause();
        belowArticleAd.pause();
        aboveRelatedAd.pause();
        belowRelatedAd.pause();
        super.onStop();
    }
}
