package com.sgcy.shadow.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sgcy.shadow.R;
import com.sgcy.shadow.home.bean.HotShowBean;

import java.util.List;

/**
 * Created by sg on 2018/6/1.
 */
public class HotMovieAdapter extends RecyclerView.Adapter<HotMovieAdapter.ViewHolder>{

    private final Context context;
    private List<HotShowBean.MsBean> ms;

    public HotMovieAdapter(Context context, List<HotShowBean.MsBean> ms) {

        this.context = context;
        this.ms = ms;

    }


    @Override
    public HotMovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = View.inflate(context, R.layout.item_hot_moive, null);

        return new ViewHolder(ItemView);
    }


    @Override
    public void onBindViewHolder(HotMovieAdapter.ViewHolder holder, final int position) {

        double ratingFinal = ms.get(position).getR();

        if(ratingFinal < 0){
            holder.tv_score.setText("预");
        }else {
            holder.tv_score.setText(ratingFinal+"");
        }


        Glide.with(context).load(ms.get(position).getImg()).into(holder.iv_movie_image);

        holder.tv_movie_name.setText(ms.get(position).getTCn());

        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHotItemCallBack != null){
                    onHotItemCallBack.onClickItem(ms.get(position).getId());
                }
            }
        });



    }

    @Override
    public int getItemCount() {
                return ms.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder{
                private ImageView iv_movie_image;
                private TextView tv_score;
                private TextView tv_movie_name;
                private LinearLayout ll_root;

                public ViewHolder(View itemView){
                    super(itemView);

                    iv_movie_image = itemView.findViewById(R.id.iv_movie_image);
            tv_score = itemView.findViewById(R.id.tv_score);
            tv_movie_name = itemView.findViewById(R.id.tv_movie_name);
            ll_root = itemView.findViewById(R.id.ll_root);

        }

    }

    private OnHotItemCallBack onHotItemCallBack;

    public interface OnHotItemCallBack{
        void onClickItem(int movieId);

    }

    public void setOnHotItemCallBack(OnHotItemCallBack onHotItemCallBack){
        this.onHotItemCallBack = onHotItemCallBack;
    }

}
