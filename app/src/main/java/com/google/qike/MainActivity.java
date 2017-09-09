package com.google.qike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.retrofitrxpo.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.listview_lv)
    Button listviewLv;
    @BindView(R.id.grideview_gv)
    Button grideviewGv;
    @BindView(R.id.recyclerview_rv)
    Button recyclerviewRv;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        listviewLv.setOnClickListener(this);
        grideviewGv.setOnClickListener(this);
        recyclerviewRv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listview_lv:
                startActivity(new Intent(this, ListViewDemo.class));
                break;
            case R.id.grideview_gv:
                startActivity(new Intent(this, GrideViewDemo.class));
                break;
            case R.id.recyclerview_rv:
                startActivity(new Intent(this, RecyclerViewDemo.class));
                break;
        }
    }
}
