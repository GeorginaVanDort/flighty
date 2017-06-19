package com.intuition.flighty.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;


@Root(strict = false)
public class FlightyChannel implements Serializable {

    @ElementList(name = "item",required = true, inline = true)
    private List<FeedItem> itemList;

    public List<FeedItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<FeedItem> itemList) {
        this.itemList = itemList;
    }

    public FlightyChannel (List<FeedItem> feedItems) {
        this.itemList = feedItems;
    }

    public FlightyChannel () {}
}
