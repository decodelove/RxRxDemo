package com.google.qike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.retrofitrxpo.R;
import com.google.qike.GrideViewDemo;
import com.google.qike.data.Images;
import com.google.qike.utils.Logger;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/7.
 */
public class MyAdapter extends BaseAdapter {


    private final Context mContext;
    private final ArrayList<String> mList;
//    private final ListView mListView;
    private ViewHolder mViewHolder;
    private final LayoutInflater mLayoutInflater;
    private int mPosition;

    public MyAdapter(Context context, ArrayList<String> list, ListView listviewView){
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext=context;
        this.mList=list;
//        this.mListView=listviewView;
    }

    public MyAdapter(GrideViewDemo context, ArrayList<String> list, GridView grideView) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext=context;
        this.mList=list;
    }

    @Override
    public int getCount() {
        return mList==null ? 0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? 0 : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        this.mPosition=position;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Logger.i(this,"this is a "+position);
        if (convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.item_activity, parent,false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) convertView.getTag();
//            resetViewHolder(mViewHolder);
        }
        mViewHolder.mTextView1.setText(mList.get(position));
        Glide.with(mContext).load(Images.imageUrls[position]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(mViewHolder.mImageView);

//        if (convertView != null && convertView.getTag() instanceof ViewHolder) {
//            updateView((ViewHolder)convertView.getTag(), position);
//        }
        return convertView;
    }

    private void resetViewHolder(ViewHolder holder) {
        holder.mImageView=null;
        holder.mTextView1=null;
    }


    private void updateView(ViewHolder holder, Integer data) {
        if (holder!=null&&data!=null){
            holder.mTextView1.setText(mList.get(data));
            Glide.with(mContext).load(Images.imageUrls[data]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.mImageView);
            resetViewHolder(holder);
        }
    }

    public static class ViewHolder{
        ImageView mImageView;
        TextView mTextView1;

        public ViewHolder(View convertView) {
            mImageView  = (ImageView) convertView.findViewById(R.id.item_imageview);
            mTextView1= (TextView) convertView.findViewById(R.id.item_textview1);
        }
    }

    /*public void notifyData() {
        int firstVisiblePosition = mListView.getFirstVisiblePosition();
        int lastVisiblePosition = mListView.getLastVisiblePosition();
        int relativePosition  = lastVisiblePosition - firstVisiblePosition;
        if (mPosition>=firstVisiblePosition &&mPosition<=lastVisiblePosition){
            updateView((ViewHolder) mListView.getChildAt(relativePosition).getTag(),(Integer) getItem(mPosition));
        }
    }*/
}
