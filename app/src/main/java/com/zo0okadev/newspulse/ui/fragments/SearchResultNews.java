package com.zo0okadev.newspulse.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.ui.AppViewModel;
import com.zo0okadev.newspulse.ui.adapters.NewsPagedListAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SearchResultNews extends Fragment {

    private AppViewModel appViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;

    public SearchResultNews() {
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_result_news, container, false);

        appViewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);

        swipeRefreshLayout = rootView.findViewById(R.id.search_results_strl);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                appViewModel.refreshSearchResults();
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.search_result_news_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
        final NewsPagedListAdapter newsPagedListAdapter = new NewsPagedListAdapter(getActivity());
        recyclerView.setAdapter(newsPagedListAdapter);

        appViewModel.getSearchResultNews().observe(this, new Observer<PagedList<Article>>() {
            @Override
            public void onChanged(PagedList<Article> articles) {
                newsPagedListAdapter.submitList(articles);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return rootView;
    }

}
