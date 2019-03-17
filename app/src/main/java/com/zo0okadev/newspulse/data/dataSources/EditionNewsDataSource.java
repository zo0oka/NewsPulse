package com.zo0okadev.newspulse.data.dataSources;

import com.zo0okadev.newspulse.api.NewsApiClient;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.model.response.NewsResponseWrapper;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.newspulse.utils.Constants.NETWORK_PAGE_SIZE;

public class EditionNewsDataSource extends PageKeyedDataSource<Integer, Article> {

    private String edition;

    public EditionNewsDataSource(String edition) {
        this.edition = edition;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Article> callback) {
        NewsApiClient.getInstance().getEditionNews(edition, 1, NETWORK_PAGE_SIZE)
                .enqueue(new Callback<NewsResponseWrapper>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResponseWrapper> call, @NonNull Response<NewsResponseWrapper> response) {
                        if (response.isSuccessful()) {
                            List<Article> articles;
                            if (response.body() != null) {
                                articles = response.body().getNewsResponse().getArticles();
                            } else {
                                articles = Collections.emptyList();
                            }
                            callback.onResult(articles, null, 2);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResponseWrapper> call, @NonNull Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Article> callback) {
        NewsApiClient.getInstance().getEditionNews(edition, params.key, NETWORK_PAGE_SIZE)
                .enqueue(new Callback<NewsResponseWrapper>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResponseWrapper> call, @NonNull Response<NewsResponseWrapper> response) {
                        if (response.isSuccessful()) {
                            List<Article> articles;
                            if (response.body() != null) {
                                articles = response.body().getNewsResponse().getArticles();
                            } else {
                                articles = Collections.emptyList();
                            }
                            callback.onResult(articles, params.key - 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResponseWrapper> call, @NonNull Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Article> callback) {
        NewsApiClient.getInstance().getEditionNews(edition, params.key, NETWORK_PAGE_SIZE)
                .enqueue(new Callback<NewsResponseWrapper>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResponseWrapper> call, @NonNull Response<NewsResponseWrapper> response) {
                        if (response.isSuccessful()) {
                            List<Article> articles;
                            if (response.body() != null) {
                                articles = response.body().getNewsResponse().getArticles();
                            } else {
                                articles = Collections.emptyList();
                            }
                            callback.onResult(articles, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResponseWrapper> call, @NonNull Throwable t) {

                    }
                });
    }
}
