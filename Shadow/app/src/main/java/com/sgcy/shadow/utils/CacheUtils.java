package com.sgcy.shadow.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sg on 2018/5/30.
 * 缓存工具类
 */
public class CacheUtils {

    /**
     * 从本地获取保存的数据
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences("zqw", Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }


    /**
     * 将数据保存到本地
     * @param context
     * @param key
     * @param value
     */
    public static void saveString(Context context, String key, String value) {

        SharedPreferences sp = context.getSharedPreferences("zqw", Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();

    }

}
