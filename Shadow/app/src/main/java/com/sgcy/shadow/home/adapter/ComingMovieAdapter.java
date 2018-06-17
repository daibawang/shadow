package com.sgcy.shadow.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sgcy.shadow.R;
import com.sgcy.shadow.home.bean.ComingShowBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sg on 2018/6/1.
 */
public class ComingMovieAdapter extends BaseAdapter {

    private Context context;
    private ComingShowBean comingShowBean;

    public ComingMovieAdapter(Context context, ComingShowBean comingShowBean) {
        this.comingShowBean = comingShowBean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return comingShowBean.getMoviecomings().size();
    }

    @Override
    public Object getItem(int i) {
        return comingShowBean.getMoviecomings().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item_moving_moive, null);
            holder = new ViewHolder(view);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        final List<ComingShowBean.MoviecomingsBean> moviecomings = comingShowBean.getMoviecomings();

        holder.tvMTitle.setText(moviecomings.get(i).getTitle());
        String star =  moviecomings.get(i).getActor1() + "/" + moviecomings.get(i).getActor2();
        holder.tvGType.setText(moviecomings.get(i).getLocationName() + "-" + moviecomings.get(i).getType());
        holder.tvStar.setText(moviecomings.get(i).getDirector() + "\t" + star);

        Glide.with(context).load(moviecomings.get(i).getImage()).into(holder.ivMovieImage);

        String date = moviecomings.get(i).getRYear() + "." + moviecomings.get(i).getRMonth() + "." +  moviecomings.get(i).getRDay();

        holder.tvMYeat.setText("(" + date + "" + ")");

        holder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onComingItemCallBack.onClickItem(moviecomings.get(i).getId());
            }
        });

        return view;
    }


    class ViewHolder {
        @Bind(R.id.iv_movie_image)
        ImageView ivMovieImage;
        @Bind(R.id.tv_m_title)
        TextView tvMTitle;
        @Bind(R.id.tv_m_yeat)
        TextView tvMYeat;
        @Bind(R.id.tv_g_type)
        TextView tvGType;
        @Bind(R.id.tv_star)
        TextView tvStar;
        @Bind(R.id.ll_root)
        LinearLayout llRoot;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private OnComingItemCallBack onComingItemCallBack;

    public interface OnComingItemCallBack{
        void onClickItem(int movieId);

    }

    public void setOnComingItemCallBack(OnComingItemCallBack onComingItemCallBack){
        this.onComingItemCallBack = onComingItemCallBack;
    }

}
