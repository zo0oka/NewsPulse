package com.zo0okadev.newspulse.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.sections.Section;
import com.zo0okadev.newspulse.ui.viewHolders.SectionsViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class SectionsAdapter extends RecyclerView.Adapter<SectionsViewHolder> {

    private List<Section> sections;
    private FragmentActivity activity;

    public SectionsAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public SectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsViewHolder holder, int position) {
        holder.bindTo(activity, sections.get(position));
    }

    @Override
    public int getItemCount() {
        return (sections != null) ? sections.size() : 0;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
        notifyDataSetChanged();
    }
}

