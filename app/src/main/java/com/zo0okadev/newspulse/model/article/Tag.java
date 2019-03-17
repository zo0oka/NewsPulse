package com.zo0okadev.newspulse.model.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tag {

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
    @SerializedName("references")
    @Expose
    private List<Object> references = null;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("bylineImageUrl")
    @Expose
    private String bylineImageUrl;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("bylineLargeImageUrl")
    @Expose
    private String bylineLargeImageUrl = null;

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

    public List<Object> getReferences() {
        return references;
    }

    public void setReferences(List<Object> references) {
        this.references = references;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBylineImageUrl() {
        return bylineImageUrl;
    }

    public void setBylineImageUrl(String bylineImageUrl) {
        this.bylineImageUrl = bylineImageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBylineLargeImageUrl() {
        return bylineLargeImageUrl;
    }

    public void setBylineLargeImageUrl(String bylineLargeImageUrl) {
        this.bylineLargeImageUrl = bylineLargeImageUrl;
    }

}

