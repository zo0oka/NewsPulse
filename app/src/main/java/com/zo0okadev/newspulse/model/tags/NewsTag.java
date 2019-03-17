package com.zo0okadev.newspulse.model.tags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NewsTag {

    public static DiffUtil.ItemCallback<NewsTag> DIFF_CALLBACK = new DiffUtil.ItemCallback<NewsTag>() {
        @Override
        public boolean areItemsTheSame(@NonNull NewsTag oldItem, @NonNull NewsTag newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewsTag oldItem, @NonNull NewsTag newItem) {
            return oldItem.getWebTitle().equals(newItem.getWebTitle());
        }
    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("sectionId")
    @Expose
    private String sectionId;
    @SerializedName("sectionName")
    @Expose
    private String sectionName;
    @SerializedName("webTitle")
    @Expose
    private String webTitle;
    @SerializedName("webUrl")
    @Expose
    private String webUrl;
    @SerializedName("apiUrl")
    @Expose
    private String apiUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}

