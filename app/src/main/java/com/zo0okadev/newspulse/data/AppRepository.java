package com.zo0okadev.newspulse.data;


import com.zo0okadev.newspulse.api.NewsApiClient;
import com.zo0okadev.newspulse.data.dataSourceFactories.EditionNewsDataSourceFactory;
import com.zo0okadev.newspulse.data.dataSourceFactories.LatestNewsDataSourceFactory;
import com.zo0okadev.newspulse.data.dataSourceFactories.SearchResultDataSourceFactory;
import com.zo0okadev.newspulse.data.dataSourceFactories.SectionNewsDataSourceFactory;
import com.zo0okadev.newspulse.model.EditionNewsWrapper;
import com.zo0okadev.newspulse.model.NewsArticleContentWrapper;
import com.zo0okadev.newspulse.model.SearchResultsWrapper;
import com.zo0okadev.newspulse.model.SectionNewsWrapper;
import com.zo0okadev.newspulse.model.article.ArticleResponse;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.model.response.NewsArticleResponseWrapper;
import com.zo0okadev.newspulse.model.response.SectionsResponseWrapper;
import com.zo0okadev.newspulse.model.sections.Section;
import com.zo0okadev.newspulse.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {

    public LiveData<PagedList<Article>> getLatestNews() {
        LatestNewsDataSourceFactory latestNewsDataSourceFactory = new LatestNewsDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        return new LivePagedListBuilder<>(latestNewsDataSourceFactory, config).build();
    }

    public SectionNewsWrapper getSectionNews(String section) {
        SectionNewsDataSourceFactory sectionNewsDataSourceFactory = new SectionNewsDataSourceFactory(section);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        LiveData<PagedList<Article>> sectionNews = new LivePagedListBuilder<>(sectionNewsDataSourceFactory, config).build();
        return new SectionNewsWrapper(sectionNews);
    }

    public SearchResultsWrapper getSearchResultNews(String query) {
        SearchResultDataSourceFactory searchResultDataSourceFactory = new SearchResultDataSourceFactory(query);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        LiveData<PagedList<Article>> searchResultNews = new LivePagedListBuilder<>(searchResultDataSourceFactory, config).build();
        return new SearchResultsWrapper(searchResultNews);
    }

    public LiveData<List<Section>> getAllNewsSections() {
        final MutableLiveData<List<Section>> allNewsSections = new MutableLiveData<>();
        NewsApiClient.getInstance().getAllNewsSections().enqueue(new Callback<SectionsResponseWrapper>() {
            @Override
            public void onResponse(@NonNull Call<SectionsResponseWrapper> call, @NonNull Response<SectionsResponseWrapper> response) {
                if (response.isSuccessful()) {
                    List<Section> sections = new ArrayList<>();
                    if (response.body() != null) {
                        List<Section> responseSections = response.body().getSectionsResponse().getSections();
                        for (Section section : responseSections) {
                            if (!Constants.ignoredSections.contains(section.getId())) {
                                sections.add(section);
                            }
                        }
                    } else {
                        sections = Collections.emptyList();
                    }
                    allNewsSections.setValue(sections);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SectionsResponseWrapper> call, @NonNull Throwable t) {

            }
        });
        return allNewsSections;
    }

    public NewsArticleContentWrapper getNewsArticleContent(String articleId) {
        final MutableLiveData<ArticleResponse> articleResponseMutableLiveData = new MutableLiveData<>();
        NewsApiClient.getInstance().getNewsArticle(articleId).enqueue(new Callback<NewsArticleResponseWrapper>() {
            @Override
            public void onResponse(@NonNull Call<NewsArticleResponseWrapper> call, @NonNull Response<NewsArticleResponseWrapper> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        articleResponseMutableLiveData.setValue(response.body().getArticleResponse());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsArticleResponseWrapper> call, @NonNull Throwable t) {

            }
        });
        return new NewsArticleContentWrapper(articleResponseMutableLiveData);
    }

    public EditionNewsWrapper getEditionNews(String edition) {
        EditionNewsDataSourceFactory editionNewsDataSourceFactory = new EditionNewsDataSourceFactory(edition);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .setInitialLoadSizeHint(30)
                .setMaxSize(60)
                .setPrefetchDistance(10)
                .build();
        LiveData<PagedList<Article>> editionNews = new LivePagedListBuilder<>(editionNewsDataSourceFactory, config).build();
        return new EditionNewsWrapper(editionNews);
    }
}

