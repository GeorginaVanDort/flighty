package com.intuition.flighty.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.intuition.flighty.R;
import com.intuition.flighty.adapters.RecyclerViewAdapter;
import com.intuition.flighty.models.FeedItem;
import com.intuition.flighty.models.FlightyFeed;
import com.intuition.flighty.rest.RSSApi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    Context context;
    @BindView (R.id.feedList) RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = getApplicationContext();
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        OkHttpClient client = new OkHttpClient.Builder().build();

        SimpleXmlConverterFactory conv = SimpleXmlConverterFactory.createNonStrict();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.secretflying.com/")
                .client(client)
                .addConverterFactory(conv)
                .build();


        RSSApi retrofitService = retrofit.create(RSSApi.class);
        Call<FlightyFeed> call = retrofitService.getFeedItems();
        call.enqueue(new Callback<FlightyFeed>() {

            @Override
            public void onResponse(Call<FlightyFeed> call, Response<FlightyFeed> response) {
                Log.v("RESPONSE", "HI");
                if(response.isSuccessful()){
                    final ArrayList<FeedItem> mItems = response.body().getChannel().getFeedItems();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerViewAdapter = new RecyclerViewAdapter(mItems, context);
                            recyclerView.setAdapter(recyclerViewAdapter);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<FlightyFeed> call, Throwable t) {
                Log.v("ONFAIL", "FAIL");
            }
        });

    }
}
