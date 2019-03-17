package com.zo0okadev.newspulse.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.article.RelatedContent;
import com.zo0okadev.newspulse.ui.viewHolders.RelatedContentViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RelatedContentAdapter extends RecyclerView.Adapter<RelatedContentViewHolder> {

    private List<RelatedContent> relatedContents;
    private FragmentActivity activity;

    public RelatedContentAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RelatedContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RelatedContentViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedContentViewHolder holder, int position) {
        holder.bindTo(activity, relatedContents.get(position));
    }

    @Override
    public int getItemCount() {
        return (relatedContents != null) ? relatedContents.size() : 0;
    }

    public void setRelatedContents(List<RelatedContent> relatedContents) {
        this.relatedContents = relatedContents;
        notifyDataSetChanged();
    }
}

