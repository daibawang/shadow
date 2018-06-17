package com.sgcy.shadow.local_choose;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.sgcy.shadow.R;
import com.sgcy.shadow.utils.CacheUtils;
import com.sgcy.shadow.utils.Constants;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sgcy on 2018/6/10.
 */
public class LocalChooseActivity extends AppCompatActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lv_local)
    ListView lvLocal;
    @Bind(R.id.tv_word)
    TextView tvWord;
    @Bind(R.id.index_view)
    IndexView indexView;


    List<LocalBean.PBean> localList;

    IndexAdapter indexAdapter;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_local);
        ButterKnife.bind(this);

        indexView.setOnIndexChangeListener(new IndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String word) {
                updataWord(word);
                updataListView(word);
            }
        });

        lvLocal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int localId = localList.get(i).getId();

                Intent intent = new Intent();
                intent.putExtra("LOCAL_ID", localId);
                intent.putExtra("LOCAL_N", localList.get(i).getN());
                setResult(1, intent);
                finish();

            }
        });

        getNetData();

    }

    private void updataListView(String word) {

        for(int i=0; i<localList.size(); i++){
            String listWord = localList.get(i).getPinyinFull().substring(0, 1);

            if(word.equals(listWord)){
                //定位
                lvLocal.setSelection(i);
                return;
            }
        }
    }

    private void updataWord(String word){

        tvWord.setVisibility(View.VISIBLE);
        tvWord.setText(word);

        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //主线程
                tvWord.setVisibility(View.GONE);
            }
        }, 1500);
    }

    public void getNetData() {

        String url = Constants.LOCAL_URL;


        OkGo.<String>post(url)
                .retryCount(2)
                .cacheTime(5000)
                .execute(new StringCallback() {

                    /**
                     * 对返回数据进行操作的回调， UI线程
                     */
                    @Override
                    public void onSuccess(Response<String> response) {
                        processData(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }


    private void processData(String json) {

        LocalBean localBean = JSON.parseObject(json, LocalBean.class);

        localList = localBean.getP();

        //排序(比较全拼)
        Collections.sort(localList, new Comparator<LocalBean.PBean>() {
            @Override
            public int compare(LocalBean.PBean lhs, LocalBean.PBean rhs) {
                return lhs.getPinyinFull().compareTo(rhs.getPinyinFull());
            }
        });

        CacheUtils.saveString(this, "local", json);


        if (localList != null) {

            indexAdapter = new IndexAdapter(this, localList);
            lvLocal.setAdapter(indexAdapter);
        }
    }
}
