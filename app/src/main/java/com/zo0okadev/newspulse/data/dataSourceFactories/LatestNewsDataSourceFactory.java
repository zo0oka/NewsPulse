package com.zo0okadev.newspulse.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.zo0okadev.newspulse.data.dataSources.LatestNewsDataSource;
import com.zo0okadev.newspulse.model.news.Article;

public class LatestNewsDataSourceFactory extends DataSource.Factory<Integer, Article> {

    private MutableLiveData<LatestNewsDataSource> latestNewsLiveDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Article> create() {
        LatestNewsDataSource latestNewsDataSource = new LatestNewsDataSource();
        latestNewsLiveDataSource.postValue(latestNewsDataSource);
        return latestNewsDataSource;
    }

    public LiveData<LatestNewsDataSource> getLatestNewsLiveDataSource() {
        return latestNewsLiveDataSource;
    }

}
