package com.zo0okadev.newspulse.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.zo0okadev.newspulse.data.dataSources.SectionNewsDataSource;
import com.zo0okadev.newspulse.model.news.Article;

public class SectionNewsDataSourceFactory extends DataSource.Factory<Integer, Article> {

    private MutableLiveData<SectionNewsDataSource> sectionNewsLiveDataSource = new MutableLiveData<>();
    private String section;

    public SectionNewsDataSourceFactory(String section) {
        this.section = section;
    }

    @NonNull
    @Override
    public DataSource<Integer, Article> create() {
        SectionNewsDataSource sectionNewsDataSource = new SectionNewsDataSource(section);
        sectionNewsLiveDataSource.postValue(sectionNewsDataSource);
        return sectionNewsDataSource;
    }

    public LiveData<SectionNewsDataSource> getSectionNewsLiveDataSource() {
        return sectionNewsLiveDataSource;
    }
}
