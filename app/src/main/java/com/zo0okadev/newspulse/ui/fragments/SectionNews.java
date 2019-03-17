package com.zo0okadev.newspulse.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class SectionNews extends Fragment {


    private NewsPagedListAdapter newsPagedListAdapter;

    public SectionNews() {
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_news, container, false);

        TextView subTitle = getActivity().findViewById(R.id.toolbar_sub_header);
        subTitle.setText(getArguments().getString("sectionName"));

        RecyclerView recyclerView = rootView.findViewById(R.id.section_news_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
        newsPagedListAdapter = new NewsPagedListAdapter(getActivity());
        recyclerView.setAdapter(newsPagedListAdapter);

        AppViewModel appViewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);
        appViewModel.getSectionNews().observe(this, new Observer<PagedList<Article>>() {
            @Override
            public void onChanged(PagedList<Article> articles) {
                newsPagedListAdapter.submitList(articles);
            }
        });

        return rootView;
    }
}
