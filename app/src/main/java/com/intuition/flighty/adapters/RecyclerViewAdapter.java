package com.intuition.flighty.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.intuition.flighty.R;
import com.intuition.flighty.models.FeedItem;

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


     static class FeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.feedTitle) TextView mFeedTitle;
        @BindView(R.id.feedDescription) TextView mFeedDescription;
        @BindView(R.id.feedLink) TextView mFeedLink;


        public FeedViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
        public void bindViewHolder(FeedItem feedItem) {
            mFeedDescription.setText(feedItem.getComments());
            mFeedLink.setText(feedItem.getLink());
            mFeedTitle.setText(feedItem.getTitle());
        }
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.bindViewHolder(mItems.get(position));
    }
}