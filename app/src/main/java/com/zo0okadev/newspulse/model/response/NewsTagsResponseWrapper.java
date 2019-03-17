package com.zo0okadev.newspulse.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zo0okadev.newspulse.model.tags.TagsResponse;

public class NewsTagsResponseWrapper {

    @SerializedName("response")
    @Expose
    private TagsResponse tagsResponse;

    public TagsResponse getTagsResponse() {
        return tagsResponse;
    }

    public void setTagsResponse(TagsResponse tagsResponse) {
        this.tagsResponse = tagsResponse;
    }

}
