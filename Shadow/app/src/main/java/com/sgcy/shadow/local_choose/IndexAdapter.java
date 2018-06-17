package com.sgcy.shadow.local_choose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.sgcy.shadow.R;

import java.util.List;

/**
 * Created by sgcy on 2018/6/10.
 */
public class IndexAdapter extends BaseAdapter {

    private Context context;
    private List<LocalBean.PBean> localList;

    public IndexAdapter(Context context, List<LocalBean.PBean> localList){
        this.context = context;
        this.localList = localList;
    }

    @Override
    public int getCount() {
        return localList.size();
    }

    @Override
    public Object getItem(int i) {
        return localList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;

        if(view == null){
            view = View.inflate(context, R.layout.item_local, null);

            viewHolder = new ViewHolder();
            viewHolder.tv_name = view.findViewById(R.id.tv_name);
            viewHolder.tv_word = view.findViewById(R.id.tv_word);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String name = localList.get(i).getN();
        String word = localList.get(i).getPinyinFull().substring(0, 1);

        viewHolder.tv_word.setText(word);
        viewHolder.tv_name.setText(name);
        if(i == 0){
            viewHolder.tv_word.setVisibility(View.VISIBLE);
        }else {
            //得到当前的字母，和上一个字母进行比较。相同就隐藏，否则就显示
            String preWord = localList.get(i-1).getPinyinFull().substring(0, 1);

            if(word.equals(preWord)){
                viewHolder.tv_word.setVisibility(View.GONE);
            }else {
                viewHolder.tv_word.setVisibility(View.VISIBLE);
            }
        }

        return view;
    }

    class ViewHolder{
        TextView tv_word;
        TextView tv_name;
    }
}
