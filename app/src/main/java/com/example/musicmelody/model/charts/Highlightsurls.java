
package com.example.musicmelody.model.charts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Highlightsurls {

    @SerializedName("artisthighlightsurl")
    @Expose
    private String artisthighlightsurl;
    @SerializedName("relatedhighlightsurl")
    @Expose
    private String relatedhighlightsurl;

    public String getArtisthighlightsurl() {
        return artisthighlightsurl;
    }

    public void setArtisthighlightsurl(String artisthighlightsurl) {
        this.artisthighlightsurl = artisthighlightsurl;
    }

    public String getRelatedhighlightsurl() {
        return relatedhighlightsurl;
    }

    public void setRelatedhighlightsurl(String relatedhighlightsurl) {
        this.relatedhighlightsurl = relatedhighlightsurl;
    }

}
