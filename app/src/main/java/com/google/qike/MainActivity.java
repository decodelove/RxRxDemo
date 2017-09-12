package com.google.qike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.retrofitrxpo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

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
    }

    @OnClick({R.id.listview_lv,R.id.grideview_gv,R.id.recyclerview_rv})
    public void clickButton(Button view){
        Log.e("sss","ok choose"+view.getId());
        switch (view.getId()){
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
