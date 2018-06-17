package com.sgcy.shadow.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sgcy.shadow.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by LENOVO on 2018/6/3.
 */

public class BannerAdapter extends RecyclerView.Adapter {
    private View mHeaderView;
    private List<String> mData;
    private Context mContext;
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
    }

    public BannerAdapter(Context context, List<String> data) {//构造方法
        mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mHeaderView);//Holder方法名
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        return;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? mData.size() : mData.size() + 1;
    }

    //参考
    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
                return;
        }
    }
}
