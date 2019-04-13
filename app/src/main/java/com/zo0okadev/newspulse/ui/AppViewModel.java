package com.zo0okadev.newspulse.ui;

import com.zo0okadev.newspulse.data.AppRepository;
import com.zo0okadev.newspulse.model.EditionNewsWrapper;
import com.zo0okadev.newspulse.model.SearchResultsWrapper;
import com.zo0okadev.newspulse.model.SectionNewsWrapper;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.model.sections.Section;

import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class AppViewModel extends ViewModel {

    private final LiveData<PagedList<Article>> latestNews;
    private final LiveData<List<Section>> allNewsSections;
    private final MutableLiveData<String> sectionId = new MutableLiveData<>();
    private final MutableLiveData<String> query = new MutableLiveData<>();
    private final MutableLiveData<String> editionId = new MutableLiveData<>();
    private AppRepository appRepository = new AppRepository();
    private LiveData<EditionNewsWrapper> editionNewsWrapperLiveData = Transformations
            .map(editionId, new Function<String, EditionNewsWrapper>() {
                @Override
                public EditionNewsWrapper apply(String input) {
                    return appRepository.getEditionNews(input);
                }
            });
    private LiveData<PagedList<Article>> editionNews = Transformations
            .switchMap(editionNewsWrapperLiveData, new Function<EditionNewsWrapper, LiveData<PagedList<Article>>>() {
                @Override
                public LiveData<PagedList<Article>> apply(EditionNewsWrapper input) {
                    return input.getEditionNews();
                }
            });
    private LiveData<SectionNewsWrapper> sectionNewsWrapperLiveData = Transformations
            .map(sectionId, new Function<String, SectionNewsWrapper>() {
                @Override
                public SectionNewsWrapper apply(String input) {
                    return appRepository.getSectionNews(input);
                }
            });
    private LiveData<PagedList<Article>> sectionNews = Transformations
            .switchMap(sectionNewsWrapperLiveData, new Function<SectionNewsWrapper, LiveData<PagedList<Article>>>() {
                @Override
                public LiveData<PagedList<Article>> apply(SectionNewsWrapper input) {
                    return input.getSectionNews();
                }
            });
    private LiveData<SearchResultsWrapper> searchResultsWrapperLiveData = Transformations
            .map(query, new Function<String, SearchResultsWrapper>() {
                @Override
                public SearchResultsWrapper apply(String input) {
                    return appRepository.getSearchResultNews(input);
                }
            });
    private LiveData<PagedList<Article>> searchResultNews = Transformations
            .switchMap(searchResultsWrapperLiveData, new Function<SearchResultsWrapper, LiveData<PagedList<Article>>>() {
                @Override
                public LiveData<PagedList<Article>> apply(SearchResultsWrapper input) {
                    return input.getSearchResults();
                }
            });

    public AppViewModel() {
        latestNews = appRepository.getLatestNews();
        allNewsSections = appRepository.getAllNewsSections();
    }

    @SuppressWarnings("ConstantConditions")
    public void refreshLatestNews() {
        latestNews.getValue().getDataSource().invalidate();
    }

    public LiveData<PagedList<Article>> getLatestNews() {
        return latestNews;
    }

    public LiveData<List<Section>> getAllNewsSections() {
        return allNewsSections;
    }

    public LiveData<PagedList<Article>> getSectionNews() {
        return sectionNews;
    }

    public void setNewsSection(String sectionId) {
        this.sectionId.postValue(sectionId);
    }

    public LiveData<PagedList<Article>> getSearchResultNews() {
        return searchResultNews;
    }

    public void setSearchQuery(String query) {
        this.query.postValue(query);
    }

    public LiveData<PagedList<Article>> getEditionNews() {
        return editionNews;
    }

    public void setEditionId(String edition) {
        editionId.postValue(edition);
    }

    @SuppressWarnings("ConstantConditions")
    public void refreshEditionNews() {
        editionNews.getValue().getDataSource().invalidate();
    }

    @SuppressWarnings("ConstantConditions")
    public void refreshSearchResults() {
        searchResultNews.getValue().getDataSource().invalidate();
    }

    @SuppressWarnings("ConstantConditions")
    public void refreshSectionNews() {
        sectionNews.getValue().getDataSource().invalidate();
    }
}

