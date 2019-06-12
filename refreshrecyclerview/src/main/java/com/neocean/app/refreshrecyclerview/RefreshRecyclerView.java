package com.neocean.app.refreshrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * User weixn
 * Date 2019/6/11
 */
public class RefreshRecyclerView extends XRecyclerView {
    public RefreshRecyclerView(Context context) {
        super(context);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }

    @Override
    public Adapter getAdapter() {

        return super.getAdapter();
    }


    /**
     * 设置能否下拉刷新
     *
     * @param enabled
     */
    public void setPullRefreshEnabled(boolean enabled) {
        super.setPullRefreshEnabled(enabled);
    }

    /**
     * 设置能否上拉加载
     *
     * @param enabled
     */
    public void setLoadingMoreEnabled(boolean enabled) {
        super.setLoadingMoreEnabled(enabled);
    }

    /**
     * 设置底部没有更多数据了显示
     *
     * @param noMore
     */
    public void setNoMore(boolean noMore) {
        super.setNoMore(noMore);
    }
    public void setNoMore(boolean noMore,String noMoreDesc) {
        super.setNoMore(noMore,noMoreDesc);
    }

    /**
     * 主动刷新需要设置在刷新监听之后
     */
    public void refresh() {
        super.refresh();
    }


    /**
     * 下拉刷新完成
     */
    public void refreshComplete() {
        super.refreshComplete();
    }

    /**
     * 下拉刷新
     *
     * @param refreshDataStr
     */
    public void refreshComplete(String refreshDataStr) {
        super.refreshComplete(refreshDataStr);
    }


    /**
     * 加载更多
     */
    public void loadMoreComplete() {
        super.loadMoreComplete();
    }

    /**
     * 设置刷新监听
     *
     * @param listener
     */
    public void setLoadingListener(LoadingListener listener) {
        super.setLoadingListener(listener);
    }


    @Override
    public void setRefreshTextColor(int color) {
        super.setRefreshTextColor(color);
    }

    /**
     * 滚动到指定位置
     * @param mRecyclerView
     * @param position
     */
    @Override
    public void smoothMoveToPosition(RecyclerView mRecyclerView, int position) {
        super.smoothMoveToPosition(mRecyclerView, position);
    }

    public interface LoadingListener {

        void onRefresh();

        void onLoadMore();
    }

}
