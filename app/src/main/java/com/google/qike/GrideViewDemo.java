package com.google.qike;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.retrofitrxpo.R;
import com.google.qike.adapter.MyAdapter;
import com.google.qike.data.Images;
import com.google.qike.utils.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/7.
 */
public class GrideViewDemo extends Activity {
    @BindView(R.id.grideview_image)
    ImageView grideviewImage;
    @BindView(R.id.gride_view)
    GridView grideView;
    private ArrayList<String> mList;
    private MyAdapter mMyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_grideview);

        ButterKnife.bind(this);
        initData();
        initListener();

//        Glide.with(GrideViewDemo.this).load("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg").into(grideviewImage);
    }

    private void initListener() {

        Logger.i(this,"mList:"+mList.toString());
        if (mMyAdapter==null) {
            mMyAdapter = new MyAdapter(this, mList,grideView);
            grideView.setAdapter(mMyAdapter);
            Glide.with(GrideViewDemo.this).load(Images.imageUrls[1]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(grideviewImage);

        }else{
            Toast.makeText(GrideViewDemo.this,"图片刷新调用",Toast.LENGTH_LONG).show();
        }
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i=0;i <=50;i++){
            mList.add("Textview "+i+"条数据...");
        }
    }
}
