package com.zo0okadev.newspulse.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zo0okadev.newspulse.model.news.NewsResponse;

public class NewsResponseWrapper {

    @SerializedName("response")
    @Expose
    private NewsResponse newsResponse;

    public NewsResponse getNewsResponse() {
        return newsResponse;
    }

    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
    }

}
