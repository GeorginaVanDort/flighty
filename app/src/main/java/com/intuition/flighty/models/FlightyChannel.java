package com.intuition.flighty.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;


@Root(strict = false)
public class FlightyChannel implements Serializable {

    @ElementList(entry = "item", inline = true)
    private List<FeedItem> feedItems;


    public FlightyChannel (List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public FlightyChannel () {}
}
