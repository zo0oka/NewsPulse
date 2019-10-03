package com.zo0okadev.newspulse.model;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.newspulse.model.news.Article;

public class SectionNewsWrapper {

    private LiveData<PagedList<Article>> sectionNews;

    public SectionNewsWrapper(LiveData<PagedList<Article>> sectionNews) {
        this.sectionNews = sectionNews;
    }

    public LiveData<PagedList<Article>> getSectionNews() {
        return sectionNews;
    }

    public void setSectionNews(LiveData<PagedList<Article>> sectionNews) {
        this.sectionNews = sectionNews;
    }
}
