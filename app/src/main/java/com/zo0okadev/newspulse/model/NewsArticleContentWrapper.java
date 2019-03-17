package com.zo0okadev.newspulse.model;

import com.zo0okadev.newspulse.model.article.ArticleResponse;

import androidx.lifecycle.LiveData;

public class NewsArticleContentWrapper {

    private LiveData<ArticleResponse> articleResponseLiveData;

    public NewsArticleContentWrapper(LiveData<ArticleResponse> articleResponseLiveData) {
        this.articleResponseLiveData = articleResponseLiveData;
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }

    public void setArticleResponseLiveData(LiveData<ArticleResponse> articleResponseLiveData) {
        this.articleResponseLiveData = articleResponseLiveData;
    }
}
