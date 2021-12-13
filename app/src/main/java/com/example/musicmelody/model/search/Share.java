
package com.example.musicmelody.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Share {

    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("snapchat")
    @Expose
    private String snapchat;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

}
