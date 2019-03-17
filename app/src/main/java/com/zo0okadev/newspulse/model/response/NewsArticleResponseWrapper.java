package com.zo0okadev.newspulse.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zo0okadev.newspulse.model.article.ArticleResponse;

public class NewsArticleResponseWrapper {

    @SerializedName("response")
    @Expose
    private ArticleResponse articleResponse;

    public ArticleResponse getArticleResponse() {
        return articleResponse;
    }

    public void setArticleResponse(ArticleResponse articleResponse) {
        this.articleResponse = articleResponse;
    }

}
