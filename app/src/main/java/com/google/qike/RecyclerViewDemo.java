package com.google.qike;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.administrator.retrofitrxpo.R;
import com.google.qike.adapter.RecyclerViewApdater;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/7.
 */
public class RecyclerViewDemo extends Activity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ArrayList<String> mList;
    private RecyclerViewApdater mRecyclerViewApdater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        if (mRecyclerViewApdater==null){
            mRecyclerViewApdater = new RecyclerViewApdater(RecyclerViewDemo.this,mList);
            recyclerView.setAdapter(mRecyclerViewApdater);
        }
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i=0;i <=50;i++){
            mList.add("Textview "+i+"条数据...");
        }
    }
}
