package com.sgcy.shadow.re;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by sg on 2018/5/30.
 */
public class MLinearLayoutManager extends LinearLayoutManager {
    /**
     * Creates a vertical LinearLayoutManager
     *
     * @param context Current context, will be used to access resources.
     */
    public MLinearLayoutManager(Context context) {
        super(context);
    }

    /**
     * @param context       Current context, will be used to access resources.
     * @param orientation   Layout orientation. Should be {@link #HORIZONTAL} or {@link
     *                      #VERTICAL}.
     * @param reverseLayout When set to true, layouts from end to start.
     */
    public MLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }


    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

//    @Override
//    public boolean canScrollVertically() {
//
//        return false;
//    }
}
