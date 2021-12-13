
package com.example.musicmelody.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SearchModel {

    @SerializedName("tracks")
    @Expose
    private Tracks tracks;
    @SerializedName("artists")
    @Expose
    private Artists artists;

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

}
