package com.zo0okadev.newspulse.model.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userTier")
    @Expose
    private String userTier;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("relatedContent")
    @Expose
    private List<RelatedContent> relatedContent = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<RelatedContent> getRelatedContent() {
        return relatedContent;
    }

    public void setRelatedContent(List<RelatedContent> relatedContent) {
        this.relatedContent = relatedContent;
    }
}

