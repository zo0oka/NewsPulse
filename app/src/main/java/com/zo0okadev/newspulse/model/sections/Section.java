package com.zo0okadev.newspulse.model.sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Section {

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
    @SerializedName("editions")
    @Expose
    private List<Edition> editions = null;
    @SerializedName("activeSponsorships")
    @Expose
    private List<ActiveSponsorship> activeSponsorships = null;

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

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }

    public List<ActiveSponsorship> getActiveSponsorships() {
        return activeSponsorships;
    }

    public void setActiveSponsorships(List<ActiveSponsorship> activeSponsorships) {
        this.activeSponsorships = activeSponsorships;
    }

}

