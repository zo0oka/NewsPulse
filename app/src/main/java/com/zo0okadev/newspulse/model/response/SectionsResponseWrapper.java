package com.zo0okadev.newspulse.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zo0okadev.newspulse.model.sections.SectionsResponse;

public class SectionsResponseWrapper {

    @SerializedName("response")
    @Expose
    private SectionsResponse sectionsResponse;

    public SectionsResponse getSectionsResponse() {
        return sectionsResponse;
    }

    public void setSectionsResponse(SectionsResponse sectionsResponse) {
        this.sectionsResponse = sectionsResponse;
    }

}
