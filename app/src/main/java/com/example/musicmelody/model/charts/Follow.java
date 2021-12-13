
package com.example.musicmelody.model.charts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Follow {

    @SerializedName("followkey")
    @Expose
    private String followkey;

    public String getFollowkey() {
        return followkey;
    }

    public void setFollowkey(String followkey) {
        this.followkey = followkey;
    }

}
