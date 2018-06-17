package com.sgcy.shadow.utils;

import android.content.Context;

import java.util.List;

/**
 * Created by sg on 2018/6/11.
 */
public class Tools {

    public static String timeFormat(String time){

        time = time.substring(0, 4)+"."+time.substring(4, 6)+"."+time.substring(6, 8);

        return time;

    }

    public static String typeChange(List<String> type){

        String s_type = "";
        for (int i = 0; i < type.size(); i++) {
            s_type += type.get(i);
            s_type += "/";
        }

        return  s_type.substring(0, s_type.length()-1);
    }


    /**
     * false: 需要刷新
     * true: 不需要刷新
     * @param context
     * @return
     */
    public static boolean isRefreshTime(Context context){

        long now = System.currentTimeMillis();

        String stringOld = CacheUtils.getString(context, "refresh_time");


        if(stringOld != null){

            long old = Long.valueOf(CacheUtils.getString(context, "refresh_time"));


            if(now > old + 3600000){
                return false;
            }else {
                return true;
            }
        }

        return false;

    }
}
