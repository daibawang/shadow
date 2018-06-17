package com.sgcy.shadow.home_fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.lzy.okgo.OkGo;
import com.sgcy.shadow.R;
import com.sgcy.shadow.home.adapter.ComingMovieAdapter;
import com.sgcy.shadow.home.adapter.BannerAdapter;
import com.sgcy.shadow.home.adapter.HomeAdapter;
import com.sgcy.shadow.home.adapter.HotMovieAdapter;
import com.sgcy.shadow.home.bean.ComingShowBean;
import com.sgcy.shadow.home.bean.HotShowBean;
import com.sgcy.shadow.re.ListViewForScrollView;
import com.sgcy.shadow.utils.CacheUtils;
import com.sgcy.shadow.utils.Constants;
import com.sgcy.shadow.utils.Tools;
import com.youth.banner.Banner;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sg on 2018/6/2.
 */
public class HomeFragment extends Fragment {

    /**
     * HotMovie类型
     */
    public static final int HOTMOVIE = 1;

    /**
     * ComingMovie类型
     */
    public static final int COMINGMOVIE = 2;
//    @Bind(R.id.rv_home)
//    RecyclerView rv_home;
    @Bind(R.id.tv_more)
    TextView tvMore;
    @Bind(R.id.rv_hot_movie)
    RecyclerView rvHotMovie;
    @Bind(R.id.ll_root)
    LinearLayout llRoot;
    @Bind(R.id.lv_coming)
    ListViewForScrollView lvComing;


    private HomeAdapter adapter;
    private HotMovieAdapter hotMovieAdapter;
    private ComingMovieAdapter comingMovieAdapter;
    private BannerAdapter bannerAdapter;//mark
    private Context context;
    private View view;
    private RollPagerView mRollViewPager;/*滚动条*/
    private boolean isShowComingListView = true;

    public String datajson = null; //网络数据

    public HomeFragment(Context context) {
        this.context = context;
    }

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        /**
         * 当内存中有hot数据和coming数据, 并且刷新时间小于一小时，就直接访问本地数据
         */
        if(!TextUtils.isEmpty(CacheUtils.getString(context, "hot")) && !TextUtils.isEmpty(CacheUtils.getString(context, "coming")) && Tools.isRefreshTime(context)){
            setHotMovie(CacheUtils.getString(context, "hot"));
            setComingMovie(CacheUtils.getString(context, "coming"));
            setBanner();//
        } else {
            if(!TextUtils.isEmpty(CacheUtils.getString(context, "local_id"))){
                getDataFromNet(Integer.valueOf(CacheUtils.getString(context, "local_id")));   //联网请求
            } else {
                getDataFromNet(290);
            }

        }


        initView();/*初始化*/
        return view;
    }

    private void setBanner() {
//        BannerAdapter bannerAdapter=new BannerAdapter(context,null);
//        rv_home.setAdapter(bannerAdapter);
    }
    /*初始化*/
    private void initView(){
        setRollPagerView();/*设置轮播图*/
    }
    /*设置轮播图*/
    private void setRollPagerView(){

        mRollViewPager = view.findViewById(R.id.rollPagerView_fragment_hotbroadcast_rollPager);
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(view.getContext(), Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

    }
    /*RollPagerView设置内部类*/
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.rollpagerview_a,
                R.drawable.rollpagerview_b,
                R.drawable.rollpagerview_c,
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
//            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    public void setHotMovie(String hotString) {

        HotShowBean hotShowBean = JSON.parseObject(hotString, HotShowBean.class);

        //设置适配器
        hotMovieAdapter = new HotMovieAdapter(context, hotShowBean.getMs());

        if(rvHotMovie != null){
            //设置布局管理器
            rvHotMovie.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            rvHotMovie.setAdapter(hotMovieAdapter);

            tvMore.setText(hotShowBean.getMs().size() + "部");
        }



        //设置item的点击事件(接口)
        hotMovieAdapter.setOnHotItemCallBack(new HotMovieAdapter.OnHotItemCallBack() {
            @Override
            public void onClickItem(int movieId) {
                inputDetail(movieId);
            }
        });
    }

    public void setComingMovie(String comingString){
        ComingShowBean comingShowBean = JSON.parseObject(comingString, ComingShowBean.class);

        comingMovieAdapter = new ComingMovieAdapter(context, comingShowBean);

        if(lvComing != null){
            lvComing.setAdapter(comingMovieAdapter);
        }


        //设置item的点击事件(接口)
        comingMovieAdapter.setOnComingItemCallBack(new ComingMovieAdapter.OnComingItemCallBack() {
            @Override
            public void onClickItem(int movieId) {
                inputDetail(movieId);
            }
        });


    }

    private void inputDetail(int movieId){
        Bundle b = new Bundle();
        b.putString("movie_id", movieId+"");
//        Intent i = new Intent(context, DetailMovieActivity.class);
//        i.putExtra("movie_id", b);
//        startActivity(i);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                Bundle bundle = msg.getData();

                /**
                 * 存入本地
                 */
                String hotString = bundle.getString("hot", "");
                String comingString = bundle.getString("coming", "");
                String localId = bundle.getString("local", "");
                String refreshTime = String.valueOf(System.currentTimeMillis());    //得到当前的时间（毫秒数）
                CacheUtils.saveString(context, "hot", hotString);
                CacheUtils.saveString(context, "coming", comingString);
                CacheUtils.saveString(context, "local_id", localId);         //保存位置信息
                CacheUtils.saveString(context, "refresh_time", refreshTime);




                //适配
                setHotMovie(hotString);
                setComingMovie(comingString);
            }
        }
    };


    public void getDataFromNet(final int localId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response1 = OkGo.get(Constants.HOTSHOW_URL + localId)
                            .tag(this)
                            .retryCount(2)
                            .cacheTime(5000)
                            .execute();
                    String data1 = response1.body().string();



                    Response response2 = OkGo.get(Constants.COMINGSHOW_URL + localId)
                            .tag(this)
                            .retryCount(2)
                            .cacheTime(5000)
                            .execute();
                    String data2 = response2.body().string();


                    Message message = Message.obtain();
                    message.what = 0;
                    Bundle bundle = new Bundle();
                    bundle.putString("hot", data1);
                    bundle.putString("coming", data2);
                    bundle.putString("local", localId+"");
                    message.setData(bundle);


                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public void refushLocal(int localId){
        getDataFromNet(localId);
    }
}
