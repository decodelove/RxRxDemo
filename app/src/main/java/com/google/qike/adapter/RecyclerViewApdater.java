package com.google.qike.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.retrofitrxpo.R;
import com.google.qike.RecyclerViewDemo;
import com.google.qike.data.Images;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12.
 */
public class RecyclerViewApdater extends RecyclerView.Adapter{
    private final Context mContext;
    private final ArrayList<String> mList;

    public RecyclerViewApdater(Context context, ArrayList<String> list) {
        this.mContext=context;
        this.mList=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoHolder(LayoutInflater.from(mContext).inflate(R.layout.item_activity,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PhotoHolder mPhotoholder= (PhotoHolder) holder;
        Glide.with(mContext).load(Images.imageUrls[position]).into(mPhotoholder.mImageView);
        mPhotoholder.item_textview1.setText("Text view "+position);
    }

    @Override
    public int getItemCount() {
        return mList==null ? 0 : mList.size();
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView item_textview1;

        public PhotoHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_imageview);
            item_textview1 = (TextView) itemView.findViewById(R.id.item_textview1);
        }
    }
}
