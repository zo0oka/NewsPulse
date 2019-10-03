package com.zo0okadev.newspulse.ui.viewHolders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.model.sections.Section;
import com.zo0okadev.newspulse.ui.AppViewModel;

public class SectionsViewHolder extends RecyclerView.ViewHolder {

    private TextView sectionTitle;

    public SectionsViewHolder(@NonNull View itemView) {
        super(itemView);
        sectionTitle = itemView.findViewById(R.id.section_list_item_title);
    }

    public void bindTo(final FragmentActivity activity, final Section section) {
        sectionTitle.setText(section.getWebTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewModelProviders.of(activity).get(AppViewModel.class).setNewsSection(section.getId());
                Bundle args = new Bundle();
                args.putString("sectionName", section.getWebTitle());
                Navigation.findNavController(activity, R.id.nav_host_fragment)
                        .navigate(R.id.nav_section_news, args);
            }
        });
    }
}

