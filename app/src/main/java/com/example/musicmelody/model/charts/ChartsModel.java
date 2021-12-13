
package com.example.musicmelody.model.charts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChartsModel {

    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

}
