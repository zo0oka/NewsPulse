package com.zo0okadev.newspulse.data.dataSourceFactories;

import com.zo0okadev.newspulse.data.dataSources.EditionNewsDataSource;
import com.zo0okadev.newspulse.model.news.Article;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class EditionNewsDataSourceFactory extends DataSource.Factory<Integer, Article> {

    private String edition;
    private MutableLiveData<EditionNewsDataSource> editionNewsLiveDataSource = new MutableLiveData<>();

    public EditionNewsDataSourceFactory(String edition) {
        this.edition = edition;
    }

    @NonNull
    @Override
    public DataSource<Integer, Article> create() {
        EditionNewsDataSource editionNewsDataSource = new EditionNewsDataSource(edition);
        editionNewsLiveDataSource.postValue(editionNewsDataSource);
        return editionNewsDataSource;
    }

    public LiveData<EditionNewsDataSource> getEditionNewsDataSource() {
        return editionNewsLiveDataSource;
    }
}
