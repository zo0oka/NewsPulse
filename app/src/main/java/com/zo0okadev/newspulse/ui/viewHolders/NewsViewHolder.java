package com.zo0okadev.newspulse.ui.viewHolders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.news.Article;
import com.zo0okadev.newspulse.utils.Utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private TextView articleTitle, articleSection, articleDate;
    private ImageView articleImage;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        articleTitle = itemView.findViewById(R.id.news_list_item_title);
        articleSection = itemView.findViewById(R.id.news_list_item_section);
        articleDate = itemView.findViewById(R.id.news_list_item_date);
        articleImage = itemView.findViewById(R.id.news_list_item_image);
    }

    public void bindTo(final FragmentActivity activity, final Article article) {
        articleTitle.setText(article.getWebTitle());
        articleSection.setText(article.getSectionName());
        articleDate.setText(Utils.getElapsedTime(article.getWebPublicationDate()));
        if ((article.getFields()) != null) {
            Glide.with(itemView.getContext()).load(article.getFields().getThumbnail()).into(articleImage);
        } else {
            Glide.with(itemView.getContext()).load("https://via.placeholder.com/300x200.png?text=No+Image+Available").into(articleImage);
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("articleId", article.getId());
                Navigation.findNavController(activity, R.id.nav_host_fragment)
                        .navigate(R.id.nav_article_details, args);
            }
        });
    }
}

