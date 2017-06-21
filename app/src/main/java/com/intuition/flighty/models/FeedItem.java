package com.intuition.flighty.models;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.lang.ref.SoftReference;

@Root(name = "item", strict = false)
public class FeedItem {


    @Element
    private String title;

    @Element
    private String link;

    @Path("comments")
    @Text(required=false)
    public String comments = "";

    public FeedItem(String title, String link, String comments) {
        this.title = title;
        this.link = link;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public FeedItem () {}

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
