package com.intuition.flighty.models;


import java.lang.ref.SoftReference;

public class FeedItem {

    private String mTitle;
    private String mBody;
    private String mLink;

    public FeedItem(String title, String body, String link) {
        mTitle = title;
        mBody = body;
        mLink = link;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }

    public String getLink() {
        return mLink;
    }
}
