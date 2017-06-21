package com.intuition.flighty.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Root(strict = false)
public class FlightyChannel implements Serializable {

    @ElementList(entry = "item", inline = true)
    private ArrayList<FeedItem> feedItems;


    public FlightyChannel (ArrayList<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public ArrayList<FeedItem> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(ArrayList<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public FlightyChannel () {}
}
