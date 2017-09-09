package com.google.qike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.retrofitrxpo.R;
import com.google.qike.utils.Logger;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/7.
 */
public class MyAdapter extends BaseAdapter {


    private final Context mContext;
    private final ArrayList<String> mList;
    private ViewHolder mViewHolder;

    public MyAdapter(Context context, ArrayList<String> list){
        this.mContext=context;
        this.mList=list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Logger.i(this,"this is a "+position);
        if (convertView==null){
            mViewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_activity, null);
            mViewHolder.mImageView  = (ImageView) convertView.findViewById(R.id.item_imageview);
            mViewHolder.mTextView1= (TextView) convertView.findViewById(R.id.item_textview1);
            mViewHolder.mTextView2= (TextView) convertView.findViewById(R.id.item_textview2);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
//        mViewHolder.mImageView.setImageResource();
        mViewHolder.mTextView1.setText(mList.get(position));
        mViewHolder.mTextView2.setText(mList.get(position));
        return convertView;
    }

    public class ViewHolder{
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
    }
}
