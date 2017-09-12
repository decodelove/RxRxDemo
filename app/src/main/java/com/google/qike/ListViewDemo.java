package com.google.qike;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.retrofitrxpo.R;
import com.google.qike.adapter.MyAdapter;
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
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listview);

        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        Logger.i(this,"mList:"+mList.toString());
        if (mMyAdapter==null) {
            mMyAdapter = new MyAdapter(this, mList,listviewView);
            listviewView.setAdapter(mMyAdapter);
        }else{
            Toast.makeText(ListViewDemo.this,"图片刷新调用",Toast.LENGTH_LONG).show();
//            mMyAdapter.notifyData();
//            listviewView.curseradapter
        }
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i=0;i <=50;i++){
            mList.add("Textview "+i+"条数据...");
        }
    }

}
