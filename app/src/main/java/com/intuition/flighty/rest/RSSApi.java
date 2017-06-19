package com.intuition.flighty.rest;


import com.intuition.flighty.models.FeedItem;
import com.intuition.flighty.models.FlightyFeed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RSSApi {

    @GET("/feed/")
    Call<FlightyFeed> getFeedItems();


}
