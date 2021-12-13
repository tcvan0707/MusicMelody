
package com.example.musicmelody.model.search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Artists {

    @SerializedName("hits")
    @Expose
    private List<Hit__1> hits = null;

    public List<Hit__1> getHits() {
        return hits;
    }

    public void setHits(List<Hit__1> hits) {
        this.hits = hits;
    }

}
