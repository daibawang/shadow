package com.sgcy.shadow.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sgcy.shadow.R;
import com.sgcy.shadow.app.MainActivity;

/**
 * Created by lijiali on 2018/6/7.
 */

public class MainViewStart extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    protected void onCreate(Bundle savedINstanceState){


        super.onCreate(savedINstanceState);
        setContentView(R.layout.activity_splash);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainViewStart.this,
                        MainActivity.class);
                MainViewStart.this.startActivity(mainIntent);
                MainViewStart.this.finish();

            }
        },SPLASH_DISPLAY_LENGHT);

    }


}
