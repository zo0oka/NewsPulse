package com.zo0okadev.newspulse.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.sections.Section;
import com.zo0okadev.newspulse.ui.AppViewModel;
import com.zo0okadev.newspulse.ui.adapters.SectionsAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsSections extends Fragment {


    public NewsSections() {
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_sections, container, false);

        TextView subTitle = getActivity().findViewById(R.id.toolbar_sub_header);
        subTitle.setText(getString(R.string.news_sections_toolbar_header));

        RecyclerView recyclerView = rootView.findViewById(R.id.news_sections_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), RecyclerView.VERTICAL, false));
        final SectionsAdapter sectionsAdapter = new SectionsAdapter(getActivity());
        recyclerView.setAdapter(sectionsAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        AppViewModel appViewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);
        appViewModel.getAllNewsSections().observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {
                sectionsAdapter.setSections(sections);
            }
        });

        return rootView;
    }

}
