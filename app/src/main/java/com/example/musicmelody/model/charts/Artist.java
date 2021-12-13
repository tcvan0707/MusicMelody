
package com.example.musicmelody.model.charts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("follow")
    @Expose
    private Follow follow;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("adamid")
    @Expose
    private String adamid;

    public Follow getFollow() {
        return follow;
    }

    public void setFollow(Follow follow) {
        this.follow = follow;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdamid() {
        return adamid;
    }

    public void setAdamid(String adamid) {
        this.adamid = adamid;
    }

}
