
package com.example.musicmelody.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hit {

    @SerializedName("track")
    @Expose
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
