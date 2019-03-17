package com.zo0okadev.newspulse.model.sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edition {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("webTitle")
    @Expose
    private String webTitle;
    @SerializedName("webUrl")
    @Expose
    private String webUrl;
    @SerializedName("apiUrl")
    @Expose
    private String apiUrl;
    @SerializedName("code")
    @Expose
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

