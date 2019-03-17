package com.zo0okadev.newspulse.model.tags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TagsResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userTier")
    @Expose
    private String userTier;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("startIndex")
    @Expose
    private int startIndex;
    @SerializedName("pageSize")
    @Expose
    private int pageSize;
    @SerializedName("currentPage")
    @Expose
    private int currentPage;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("results")
    @Expose
    private List<NewsTag> newsTags = null;

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

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<NewsTag> getNewsTags() {
        return newsTags;
    }

    public void setNewsTags(List<NewsTag> newsTags) {
        this.newsTags = newsTags;
    }

}

