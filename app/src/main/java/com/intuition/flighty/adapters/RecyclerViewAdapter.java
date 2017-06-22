package com.intuition.flighty.adapters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.intuition.flighty.R;
import com.intuition.flighty.models.FeedItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FeedViewHolder> {
    ArrayList<FeedItem> mItems;
    Context mContext;
    FeedViewHolder mViewHolder;
    View mView;

    public RecyclerViewAdapter(ArrayList<FeedItem> items, Context context) {
        mItems = items;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,parent,false);
        mViewHolder = new FeedViewHolder(mView);


        return mViewHolder;
    }


    public class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.feedTitle) TextView mFeedTitle;
        @BindView(R.id.feedDescription) TextView mFeedDescription;
        @BindView(R.id.feedLink) TextView mFeedLink;
        @BindView(R.id.feedImg) ImageView mFeedImg;
//         private static final int MAX_WIDTH = 800;
//         private static final int MAX_HEIGHT = 800;
         Context mContext;


        public FeedViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            mContext = v.getContext();
            mFeedLink.setOnClickListener(this);
        }

        public void bindViewHolder(FeedItem feedItem) {
            mFeedDescription.setText(feedItem.getComments());
            mFeedLink.setText(feedItem.getLink());
            mFeedTitle.setText(feedItem.getTitle());

            Picasso.with(mContext)
                    .load(feedItem.getImageUrl())
//                    .resize(MAX_WIDTH, MAX_HEIGHT)
//                    .centerCrop()
                    .into(mFeedImg);
        }

        @Override
        public void onClick(View v) {
            if (v == mFeedLink) {
                        Log.v("HEY", "YES");
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mFeedLink.getText().toString()));
                        mContext.startActivity(webIntent);
                    }
                }
            }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.bindViewHolder(mItems.get(position));
    }
}
