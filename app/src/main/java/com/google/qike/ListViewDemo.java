package com.google.qike;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.administrator.retrofitrxpo.R;
import com.google.qike.utils.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/7.
 */
public class ListViewDemo extends Activity {
    @BindView(R.id.listview_view)
    ListView listviewView;
    private ArrayList<String> mList;
    private MyAdapter mMyAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        Logger.i(this,"mList:"+mList.toString());
        if (mMyAdapter==null) {
            mMyAdapter = new MyAdapter(this, mList);
            listviewView.setAdapter(mMyAdapter);
        }
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i=0;i <=100;i++){
            mList.add("Textview "+i+"条数据...");
        }
    }

}
