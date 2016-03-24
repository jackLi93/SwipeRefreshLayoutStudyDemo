package com.sansi.jack.swiperefreshlayoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jack on 2016/3/24.
 */
public class SwipeRefreshLayoutActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    public  static final String TAG = "SwipeRefreshLayoutActivity ";
    private  SwipeRefreshLayout refreshLayout;
    private ListView data_lv;
    private String [] datas ;
    private Handler mRefreshHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_layout);
        initView();
    }
    private  void initView(){
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh_layout);
        data_lv = (ListView) findViewById(R.id.data_list);
        datas = getResources().getStringArray(R.array.cat_names);
        ListAdapter madapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        data_lv.setAdapter(madapter);

        refreshLayout.setColorSchemeResources(R.color.blue, R.color.green, R.color.orange);
        refreshLayout.setOnRefreshListener(this);


    }
    @Override
    public void onRefresh() {
        mRefreshHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas = getResources().getStringArray(R.array.newdatas);
                ListAdapter madapter = new ArrayAdapter<String>(SwipeRefreshLayoutActivity.this, android.R.layout.simple_list_item_1, datas);
                data_lv.setAdapter(madapter);
                refreshLayout.setRefreshing(false);
            }
        }, 3000);
        //3000代表3000ms,每转一圈会耗时1s;

        //Toast.makeText(this,"哈哈哈哈",Toast.LENGTH_LONG).show();

    }



    }

