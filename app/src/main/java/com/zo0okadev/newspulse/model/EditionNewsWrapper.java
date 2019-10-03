package com.zo0okadev.newspulse.model;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.newspulse.model.news.Article;

public class EditionNewsWrapper {

    private LiveData<PagedList<Article>> editionNews;

    public EditionNewsWrapper(LiveData<PagedList<Article>> editionNews) {
        this.editionNews = editionNews;
    }

    public LiveData<PagedList<Article>> getEditionNews() {
        return editionNews;
    }

    public void setEditionNews(LiveData<PagedList<Article>> editionNews) {
        this.editionNews = editionNews;
    }
}

