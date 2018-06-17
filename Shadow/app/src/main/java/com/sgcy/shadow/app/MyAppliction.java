package com.sgcy.shadow.app;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.yanzhenjie.nohttp.NoHttp;

import okhttp3.OkHttpClient;

/**
 * Created by sg on 2018/6/4.
 */
public class MyAppliction extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        NoHttp.initialize(this);
        OkGo.getInstance().init(this);
    }
    // 获取全局上下文
    public static Context getContext() {
        return mContext;
    }
}
