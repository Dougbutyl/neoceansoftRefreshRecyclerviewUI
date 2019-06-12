package com.neocean.app.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User weixn
 * Date 2019/5/30
 */
public class XrAdapter extends RecyclerView.Adapter<XrAdapter.XrViewholder> {

    @NonNull
    @Override
    public XrViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new XrViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull XrViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class XrViewholder extends RecyclerView.ViewHolder{
        public XrViewholder(View itemView) {
            super(itemView);
        }
    }
}
