package com.intuition.flighty.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "rss", strict = false)
public class FlightyFeed  implements Serializable {

    @Element
    private FlightyChannel channel;


    public FlightyChannel getChannel() {
        return channel;
    }

    public void setChannel(FlightyChannel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "FlightyFeed{" +
                "channel=" + channel +
                '}';
    }
}
