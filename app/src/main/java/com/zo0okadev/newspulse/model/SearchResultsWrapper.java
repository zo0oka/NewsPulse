package com.zo0okadev.newspulse.model;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.newspulse.model.news.Article;

public class SearchResultsWrapper {

    private LiveData<PagedList<Article>> searchResults;

    public SearchResultsWrapper(LiveData<PagedList<Article>> searchResults) {
        this.searchResults = searchResults;
    }

    public LiveData<PagedList<Article>> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(LiveData<PagedList<Article>> searchResults) {
        this.searchResults = searchResults;
    }
}
