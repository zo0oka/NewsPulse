package com.zo0okadev.newspulse.model.sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveSponsorship {

    @SerializedName("sponsorshipType")
    @Expose
    private String sponsorshipType;
    @SerializedName("sponsorName")
    @Expose
    private String sponsorName;
    @SerializedName("sponsorLogo")
    @Expose
    private String sponsorLogo;
    @SerializedName("sponsorLink")
    @Expose
    private String sponsorLink;
    @SerializedName("aboutLink")
    @Expose
    private String aboutLink;
    @SerializedName("sponsorLogoDimensions")
    @Expose
    private SponsorLogoDimensions sponsorLogoDimensions;
    @SerializedName("highContrastSponsorLogo")
    @Expose
    private String highContrastSponsorLogo;
    @SerializedName("highContrastSponsorLogoDimensions")
    @Expose
    private HighContrastSponsorLogoDimensions highContrastSponsorLogoDimensions;
    @SerializedName("validFrom")
    @Expose
    private String validFrom;
    @SerializedName("validTo")
    @Expose
    private String validTo;

    public String getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(String sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorLogo() {
        return sponsorLogo;
    }

    public void setSponsorLogo(String sponsorLogo) {
        this.sponsorLogo = sponsorLogo;
    }

    public String getSponsorLink() {
        return sponsorLink;
    }

    public void setSponsorLink(String sponsorLink) {
        this.sponsorLink = sponsorLink;
    }

    public String getAboutLink() {
        return aboutLink;
    }

    public void setAboutLink(String aboutLink) {
        this.aboutLink = aboutLink;
    }

    public SponsorLogoDimensions getSponsorLogoDimensions() {
        return sponsorLogoDimensions;
    }

    public void setSponsorLogoDimensions(SponsorLogoDimensions sponsorLogoDimensions) {
        this.sponsorLogoDimensions = sponsorLogoDimensions;
    }

    public String getHighContrastSponsorLogo() {
        return highContrastSponsorLogo;
    }

    public void setHighContrastSponsorLogo(String highContrastSponsorLogo) {
        this.highContrastSponsorLogo = highContrastSponsorLogo;
    }

    public HighContrastSponsorLogoDimensions getHighContrastSponsorLogoDimensions() {
        return highContrastSponsorLogoDimensions;
    }

    public void setHighContrastSponsorLogoDimensions(HighContrastSponsorLogoDimensions highContrastSponsorLogoDimensions) {
        this.highContrastSponsorLogoDimensions = highContrastSponsorLogoDimensions;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

}

