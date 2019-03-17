package com.zo0okadev.newspulse.model.sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SponsorLogoDimensions {

    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
