package com.neocean.app.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import com.neocean.app.refreshrecyclerview.RefreshRecyclerView;



public class MainActivity extends AppCompatActivity {

    RefreshRecyclerView mXRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mXRecyclerView = (RefreshRecyclerView) findViewById(R.id.xr);
        mXRecyclerView.setRefreshTextColor(R.color.blue_fujian);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mXRecyclerView.setLoadingMoreEnabled(true);
        mXRecyclerView.setLoadingListener(new RefreshRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mXRecyclerView.refreshComplete("此次更新10条数据");
                    }
                }, 3000);
            }

            ;

            @Override
            public void onLoadMore() {

//                Log.e("xxx","刷新完成");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mXRecyclerView.loadMoreComplete();
                        mXRecyclerView.setNoMore(true);
                    }
                }, 3000);
            }
        });
        mXRecyclerView.refresh();
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setAdapter(new XrAdapter());

    }
}
