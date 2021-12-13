
package com.example.musicmelody.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hit__1 {

    @SerializedName("artist")
    @Expose
    private Artist__1 artist;

    public Artist__1 getArtist() {
        return artist;
    }

    public void setArtist(Artist__1 artist) {
        this.artist = artist;
    }

}
