package com.zo0okadev.newspulse.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.zo0okadev.newspulse.data.dataSources.SearchResultDataSource;
import com.zo0okadev.newspulse.model.news.Article;

public class SearchResultDataSourceFactory extends DataSource.Factory<Integer, Article> {

    private String query;
    private MutableLiveData<SearchResultDataSource> searchResultLiveDataSource = new MutableLiveData<>();

    public SearchResultDataSourceFactory(String query) {
        this.query = query;
    }

    @NonNull
    @Override
    public DataSource<Integer, Article> create() {
        SearchResultDataSource searchResultDataSource = new SearchResultDataSource(query);
        searchResultLiveDataSource.postValue(searchResultDataSource);
        return searchResultDataSource;
    }

    public LiveData<SearchResultDataSource> getSearchResultLiveDataSource() {
        return searchResultLiveDataSource;
    }
}
