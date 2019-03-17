package com.zo0okadev.newspulse.api;

import com.zo0okadev.newspulse.model.response.NewsArticleResponseWrapper;
import com.zo0okadev.newspulse.model.response.NewsResponseWrapper;
import com.zo0okadev.newspulse.model.response.SectionsResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.zo0okadev.newspulse.utils.Constants.API_KEY;
import static com.zo0okadev.newspulse.utils.Constants.NEWS_ARTICLE_FILTERS;
import static com.zo0okadev.newspulse.utils.Constants.NEWS_LIST_FILTERS;

public interface NewsApi {

    @GET("sections?api-key=" + API_KEY)
    Call<SectionsResponseWrapper> getAllNewsSections();

    @GET("search?api-key=" + API_KEY + NEWS_LIST_FILTERS)
    Call<NewsResponseWrapper> getLatestNews(
            @Query("page") int page,
            @Query("pageSize") int pageSize);

    @GET("search?api-key=" + API_KEY + NEWS_LIST_FILTERS)
    Call<NewsResponseWrapper> getSectionNews(
            @Query("section") String section,
            @Query("page") int page,
            @Query("pageSize") int pageSize);

    @GET("search?api-key=" + API_KEY + NEWS_LIST_FILTERS)
    Call<NewsResponseWrapper> getSearchResultNews(
            @Query("q") String query,
            @Query("page") int page,
            @Query("pageSize") int pageSize);

    @GET("search?api-key=" + API_KEY + NEWS_LIST_FILTERS)
    Call<NewsResponseWrapper> getEditionNews(
            @Query("production-office") String edition,
            @Query("page") int page,
            @Query("pageSize") int pageSize);

    @GET("{id}?api-key=" + API_KEY + NEWS_ARTICLE_FILTERS)
    Call<NewsArticleResponseWrapper> getNewsArticle(
            @Path(value = "id", encoded = true) String articleId);
}
