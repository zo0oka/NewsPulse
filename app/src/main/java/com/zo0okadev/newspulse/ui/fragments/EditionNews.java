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


public class EditionNews extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private AppViewModel appViewModel;

    public EditionNews() {
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edition_news, container, false);

        appViewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);

        swipeRefreshLayout = rootView.findViewById(R.id.edition_news_strl);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                appViewModel.refreshEditionNews();
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.aus_news_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
        final NewsPagedListAdapter newsPagedListAdapter = new NewsPagedListAdapter(getActivity());
        recyclerView.setAdapter(newsPagedListAdapter);

        appViewModel.getEditionNews().observe(this, new Observer<PagedList<Article>>() {
            @Override
            public void onChanged(PagedList<Article> articles) {
                newsPagedListAdapter.submitList(articles);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return rootView;
    }

}

