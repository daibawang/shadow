package com.sgcy.shadow.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sgcy.shadow.R;
import com.sgcy.shadow.home_fragment.HomeFragment;
import com.sgcy.shadow.local_choose.LocalChooseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.dl_left)
    DrawerLayout dlLeft;
    @Bind(R.id.fl_context)
    FrameLayout flContext;
    @Bind(R.id.tv_local)
    TextView tvLocal;


    private ActionBarDrawerToggle mDrawerToggle;
    private View leftMenu_header; //左侧菜单头布局
    private ImageView image_header; //头像
    private TextView tv_userName;  //用户名

    //  private Fragment[] fragments;
    private MenuItem lastItem; // 上一个选中的item
    private MainViewPagerAdapter adapter;

    private HomeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        toolbar.getBackground().setAlpha(255);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //显示Home图标
//        toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));

        /**
         * 选择地点的点击事件
         */
        tvLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, LocalChooseActivity.class), 1);
            }
        });

        initView();

        hideScrollBar();    //去掉navigation中的滑动条

        setDrawerToggle();      //设置Drawerlayout的开关,并且和Home图标联动

        setListener();          //设置监听
    }

    private void initView() {

        leftMenu_header = navigationView.inflateHeaderView(R.layout.left_menu_header_layout);
        image_header = leftMenu_header.findViewById(R.id.iv_head);
        tv_userName = leftMenu_header.findViewById(R.id.tv_user_name);

        fragment = new HomeFragment(this);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_context, fragment);
        transaction.commit();


    }


    /**
     * 设置监听
     */
    private void setListener() {
        image_header.setOnClickListener(this);
        tv_userName.setOnClickListener(this);


        navigationView.setNavigationItemSelectedListener(new MyOnNavigationItemSelectedListener());
        //设置颜色可用
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                Toast.makeText(MainActivity.this, "点击了用户头像", Toast.LENGTH_SHORT).show();
                dlLeft.closeDrawer(GravityCompat.START);
                break;
            case R.id.tv_user_name:
                Toast.makeText(MainActivity.this, "点击了用户名", Toast.LENGTH_SHORT).show();
                dlLeft.closeDrawer(GravityCompat.START);
                break;
        }
    }

    /**
     * 设置Drawerlayout的开关,并且和Home图标联动
     */
    private void setDrawerToggle() {
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, dlLeft, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                mAnimationDrawable.stop();
//                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAnimationDrawable.start();
//                invalidateOptionsMenu();
            }
        };

        dlLeft.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    /**
     * 去掉navigation中的滑动条
     */
    private void hideScrollBar() {
        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    /**
     * 监听返回键，当左侧菜单打开时，返回键关闭左侧菜单
     */
    @Override
    public void onBackPressed() {
        if (dlLeft.isDrawerOpen(GravityCompat.START)) {
            dlLeft.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            Bundle bundle = data.getExtras();
            int localId = bundle.getInt("LOCAL_ID");


            tvLocal.setText(bundle.getString("LOCAL_N"));

            fragment.refushLocal(localId);

        }
    }



    /**
     * 左侧菜单的Item点击事件
     */
    class MyOnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.favorite:
                    Toast.makeText(MainActivity.this, "点击了标记", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.wallet:
//                        Intent i = new Intent(MainActivity.this, MyDataActivity.class);
//                       startActivity(i);
                    Toast.makeText(MainActivity.this, "点击了图册", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.photo:
                    Toast.makeText(MainActivity.this, "点击了我的信息", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.file:
                    Toast.makeText(MainActivity.this, "点击了设置", Toast.LENGTH_SHORT).show();
                    break;
            }
            dlLeft.closeDrawer(GravityCompat.START);
            return true;
        }
    }
//
//    /**
//     * viewPager选择监听
//     */
//    class MyViewPagerChangeListener implements ViewPager.OnPageChangeListener {
//
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//
//        @Override
//        public void onPageSelected(int position) {
//            // 当 ViewPager 滑动后设置BottomNavigationView 选中相应选项
//            bottomNavigationView.getMenu().getItem(position).setChecked(true);
//            if(position == 2){
//                tvTitle.setText("精彩推荐");
//            }
//
//        }
//
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }
//
//    /**
//     * 判断用户点击的菜单项，并开启fragment
//     *
//     * @param id
//     */
//    private void onTabItemSelected(int id) {
//        switch (id) {
//            case R.id.tab_menu_home:
//                vpContext.setCurrentItem(0);
//                break;
//            case R.id.tab_menu_discovery:
//                vpContext.setCurrentItem(1);
//                break;
//            case R.id.tab_menu_attention:
//                vpContext.setCurrentItem(2);
//                break;
//            case R.id.tab_menu_profile:
//                vpContext.setCurrentItem(3);
//                break;
//        }
//    }
}
